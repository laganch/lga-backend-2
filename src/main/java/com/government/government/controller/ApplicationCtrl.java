package com.government.government.controller;

import com.government.government.dto.MarriageDto;
import com.government.government.entity.applications.BirthApplication;
import com.government.government.entity.applications.DeathApplications;
import com.government.government.entity.applications.MarriageApplication;
import com.government.government.response.JsonResponse;
import com.government.government.service.ApplicationServiceCtrl;
import com.government.government.service.UtilityCtrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api")
public class ApplicationCtrl {

    @Autowired
    private ApplicationServiceCtrl applicationServiceCtrl;

    @PostMapping("/save/birth/application")
    public ResponseEntity<?> saveBirthApplication(@RequestBody BirthApplication dto) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", applicationServiceCtrl.saveBirthApplication(dto)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @PostMapping("/save/death/application")
    public ResponseEntity<?> saveDeathApplication(@RequestBody DeathApplications dto) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", applicationServiceCtrl.saveDeathApplication(dto)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @PostMapping("/save/marriage/application")
    public ResponseEntity<?> saveMarriageApplication(@RequestBody MarriageApplication dto) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", applicationServiceCtrl.saveMarriageApplication(dto)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

}
