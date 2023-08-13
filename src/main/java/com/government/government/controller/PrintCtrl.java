package com.government.government.controller;

import com.government.government.dto.PrintDto;
import com.government.government.service.PrintService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/print/")
public class PrintCtrl {

    private final PrintService printService;

    @PostMapping("certificate")
    @Transactional
    public ResponseEntity<Resource> printCard(@RequestBody List<PrintDto> dtos, HttpServletRequest request) throws Exception {
        System.out.println(dtos);
        Resource resource = printService.printCard(dtos);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.error("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/pdf";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=card.pdf")
                .body(resource);
    }

    @PostMapping("marriage/certificate")
    @Transactional
    public ResponseEntity<Resource> printMarriage(@RequestBody List<PrintDto> dtos, HttpServletRequest request) throws Exception {
        Resource resource = printService.printMarriage(dtos);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.error("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/pdf";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=card.pdf")
                .body(resource);
    }

}
