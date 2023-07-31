package com.government.government.servicesImpl;

import com.government.government.Enum.CardTypeConstant;
import com.government.government.configurations.AppConfigurationProperties;
import com.government.government.dto.PdfDto;
import com.government.government.dto.PrintDto;
import com.government.government.entity.applications.DeathApplications;
import com.government.government.repository.DeathApplicationRepo;
import com.government.government.service.PrintService;
import com.government.government.utils.HtmlToPdfCreator;
import com.government.government.utils.PDFRenderToMultiplePages;
import com.government.government.utils.QrCodeServices;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrintServiceImpl implements PrintService {

    private final DeathApplicationRepo cardRepository;
    private final QrCodeServices qrCodeServices;
    private final HtmlToPdfCreator htmlToPdfCreator;
    private final PDFRenderToMultiplePages pdfRenderToMultiplePages;
    private final AppConfigurationProperties appConfigurationProperties;

    @Override
    public Resource printCard(List<PrintDto> dtos) throws Exception {
        List<PdfDto> pdfDtos = dtos.stream().map(printDto -> {
            DeathApplications card = cardRepository.findById(printDto.getId()).orElseThrow(RuntimeException::new);

            Map<String, Object> extraParameter = new TreeMap<>();
            String templateName = getTemplate(printDto.getType());
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd - MMM - yyyy");
            Boolean insurance;

            String dataValue = card.getApplicationId();
            String qrCode = qrCodeServices.base64CertificateQrCode(dataValue);

            extraParameter.put("aid", card.getApplicationId());
            extraParameter.put("name", card.getApplicantFirstName() + " " + card.getApplicantLastName());
            extraParameter.put("address", card.getDeceasedAddress());
            extraParameter.put("phoneNumber", card.getApplicantPhonenumber());
            extraParameter.put("dateCreated", card.getCreatedAt().format(df));
            extraParameter.put("qrCode", qrCode);

            PdfDto pojo = new PdfDto();
            pojo.setTemplateName(templateName);
            pojo.setExtraParameter(extraParameter);
            pojo.setCard(card);

            return pojo;

        }).collect(Collectors.toList());

        List<String> templates = new ArrayList();

        pdfDtos.forEach(pdfPojo -> {
            try {
                templates.add(htmlToPdfCreator.createPDFString(pdfPojo.getTemplateName(), htmlToPdfCreator.getContext(pdfPojo.getCard(), pdfPojo.getExtraParameter())));
            } catch (IllegalAccessException | IOException | DocumentException e) {
                e.printStackTrace();
            }
        });


        String fileName = pdfRenderToMultiplePages.multiPage(templates);

        if (StringUtils.isBlank(fileName)) {
            throw new Exception("file not found");
        }

        return pdfRenderToMultiplePages.loadFileAsResource(appConfigurationProperties.getPrintDirectory() + fileName);
    }




    private String getTemplate(CardTypeConstant type){
        String templateName = "";

        switch (type) {
            case BIRTH:
                return templateName = "birth";
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
