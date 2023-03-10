package com.government.government.controller;

import com.government.government.entity.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestCtrl {

    @GetMapping("/")
    public String getMenu() {
        return "Reached here for test";
    }
}
