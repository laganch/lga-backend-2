package com.government.government.controller;


import com.government.government.dto.ApplicationDto;
import com.government.government.dto.MarriageDto;
import com.government.government.dto.MessagesDTO;
import com.government.government.entity.applications.DeathApplications;
import com.government.government.entity.applications.MarriageApplication;
import com.government.government.entity.applications.QDeathApplications;
import com.government.government.entity.applications.QMarriageApplication;
import com.government.government.filter.DeathApplicationFilter;
import com.government.government.filter.MarriageApplicationFilter;
import com.government.government.repository.app.AppRepository;
import com.government.government.repository.app.PredicateExtractor;
import com.government.government.response.JsonResponse;
import com.government.government.service.UtilityCtrlService;
import com.government.government.utils.CloudinaryUpload;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api")
public class UtilityCtrl {

    @Autowired
    private UtilityCtrlService utilityCtrlService;
    @Autowired
    private AppRepository appRepository;
    @Autowired
    private PredicateExtractor predicateExtractor;
    @Autowired
    private CloudinaryUpload cloudinaryUpload;


    @PostMapping("/death/assessment/search")
    private QueryResults<ApplicationDto> getAssessmentBill(DeathApplicationFilter filter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        JPAQuery<DeathApplications> userJPAQuery = appRepository.startJPAQuery(QDeathApplications.deathApplications)
                .where(predicateExtractor.getPredicate(filter))
                .offset(filter.getOffset().orElse(0))
                .limit(filter.getLimit().orElse(10));

//        if (filter.getStartDate()!= null && !filter.getStartDate().equals("")) {
//            LocalDate startDate =  LocalDate.parse(filter.getStartDate(), formatter);
//            userJPAQuery.where(QDirectTaxModel.directTaxModel.timeCreated.goe(startDate.atStartOfDay()));
//        }
//        if (filter.getAfterDate() != null && !filter.getAfterDate().equals("")) {
//            LocalDate endDate = LocalDate.parse(filter.getAfterDate(), formatter);
//            userJPAQuery.where(QDirectTaxModel.directTaxModel.timeCreated.loe(endDate.atTime(LocalTime.MAX)));
//
//        }

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QDeathApplications.deathApplications);
        QueryResults<DeathApplications> userQueryResults = userJPAQuery.select(QDeathApplications.deathApplications).distinct().orderBy(sortedColumn).fetchResults();
        return new QueryResults<>(utilityCtrlService.getDeathApplicationSearch(userQueryResults.getResults()), userQueryResults.getLimit(), userQueryResults.getOffset(), userQueryResults.getTotal());
    }

    @PostMapping("/marriage/assessment/search")
    private QueryResults<MarriageDto> getMarriageAssessment(MarriageApplicationFilter filter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        JPAQuery<MarriageApplication> userJPAQuery = appRepository.startJPAQuery(QMarriageApplication.marriageApplication)
                .where(predicateExtractor.getPredicate(filter))
                .offset(filter.getOffset().orElse(0))
                .limit(filter.getLimit().orElse(10));

//        if (filter.getStartDate()!= null && !filter.getStartDate().equals("")) {
//            LocalDate startDate =  LocalDate.parse(filter.getStartDate(), formatter);
//            userJPAQuery.where(QDirectTaxModel.directTaxModel.timeCreated.goe(startDate.atStartOfDay()));
//        }
//        if (filter.getAfterDate() != null && !filter.getAfterDate().equals("")) {
//            LocalDate endDate = LocalDate.parse(filter.getAfterDate(), formatter);
//            userJPAQuery.where(QDirectTaxModel.directTaxModel.timeCreated.loe(endDate.atTime(LocalTime.MAX)));
//
//        }

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QMarriageApplication.marriageApplication);
        QueryResults<MarriageApplication> userQueryResults = userJPAQuery.select(QMarriageApplication.marriageApplication).distinct().orderBy(sortedColumn).fetchResults();
        return new QueryResults<>(utilityCtrlService.getMarriageApplicationSearch(userQueryResults.getResults()), userQueryResults.getLimit(), userQueryResults.getOffset(), userQueryResults.getTotal());
    }

    @GetMapping("/death/assessment/search")
    public ResponseEntity<?> ReportDashboard(@RequestParam String aid) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", utilityCtrlService.getDeathApplication(aid)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }


    @GetMapping("/report/dashboard")
    public ResponseEntity<?> ReportDashboard() {
        try {
            return ResponseEntity.ok(new JsonResponse("done", utilityCtrlService.ReportDashboard()));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @GetMapping("/general/approval")
    public ResponseEntity<?> GeneralApproval(@RequestParam String type, @RequestParam String aid) {
        System.out.println("Reached out");
        try {
            return ResponseEntity.ok(new JsonResponse("done", utilityCtrlService.GeneralApproval(type, aid)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @GetMapping("/general/query")
    public ResponseEntity<?> GeneralQuery(@RequestParam String type, @RequestParam String aid, @RequestParam String reason) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", utilityCtrlService.GeneralQuery(type, aid, reason)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @PostMapping(path = "/cloud/upload")
    public ResponseEntity<Object> saveDocument(@RequestParam MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile);
        BufferedImage image = ImageIO.read(multipartFile.getInputStream());
        if (image == null){
            return new ResponseEntity(new MessagesDTO("Invalid image"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryUpload.upload(multipartFile);

//        TCCImagesModel tccImagesModel = new TCCImagesModel();
//
//        tccImagesModel.setImageId((String)result.get("public_id"));
//        tccImagesModel.setImageUrl((String)result.get("url"));
//        tccImagesModel.setName((String)result.get("original_filename"));
//
//        tccImageRepo.save(tccImagesModel);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/death/update")
    public ResponseEntity<?> DeathUpdate(@RequestParam String id) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", utilityCtrlService.DeathUpdate(id)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }
    @GetMapping("/marriage/update")
    public ResponseEntity<?> MarriageUpdate(@RequestParam String id) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", utilityCtrlService.MarriageUpdate(id)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

}
