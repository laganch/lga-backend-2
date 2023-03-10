package com.government.government.controller;

import com.government.government.dto.UserDto;
import com.government.government.entity.Menu;
import com.government.government.entity.Users;
import com.government.government.service.MenuControllerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api")
public class MenuController {


    @Autowired
    private MenuControllerService menuControllerService;

    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> getMenu(@RequestParam String role) {
        return ResponseEntity.ok(menuControllerService.getMenu(role));
    }

    @GetMapping("/verify-access")
    public Boolean getMenu(@RequestParam String role, @RequestParam String menu) {
        return menuControllerService.checkMenuPermission(role, menu);
    }

}
