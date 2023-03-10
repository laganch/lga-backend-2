package com.government.government.controller;

import com.government.government.dto.MessagesDTO;
import com.government.government.dto.ModuleDto;
import com.government.government.dto.SettingsDto;
import com.government.government.repository.app.AppRepository;
import com.government.government.repository.app.PredicateExtractor;
import com.government.government.response.JsonResponse;
import com.government.government.service.SettingControllerService;
import com.government.government.utils.CloudinaryUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/settings")
public class SettingCtrl {

    @Autowired
    private SettingControllerService settingControllerService;
    @Autowired
    private AppRepository appRepository;
    @Autowired
    private PredicateExtractor predicateExtractor;
    @Autowired
    private CloudinaryUpload cloudinaryUpload;

    @PostMapping("/save/applications")
    public ResponseEntity<?> saveApplication(@RequestBody SettingsDto dto) {
        System.out.println("***********************************************");
        try {
            return ResponseEntity.ok(new JsonResponse("done", settingControllerService.saveSettingsApplication(dto)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @PostMapping("/save/module")
    public ResponseEntity<?> saveModules(@RequestBody ModuleDto dto) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", settingControllerService.saveSettingsModules(dto)));
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    @PostMapping("/save/media")
    public ResponseEntity<?> saveMedia(@RequestBody SettingsDto dto) {
        try {
            return ResponseEntity.ok(new JsonResponse("done", settingControllerService.saveSettingsMedia(dto)));
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
}
