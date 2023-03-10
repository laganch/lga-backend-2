package com.government.government.controller;

import com.government.government.dto.AuthRequest;
import com.government.government.dto.LoginResponse;
import com.government.government.dto.PortalUserDto;
import com.government.government.dto.UserDto;
import com.government.government.entity.Area;
import com.government.government.entity.Lga;
import com.government.government.entity.State;
import com.government.government.entity.Users;
import com.government.government.response.JsonResponse;
import com.government.government.service.UserManagementService;
import com.government.government.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userManagementService.CreateUser(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest dto) throws Exception {
        LoginResponse response = userManagementService.authenticateUser(dto);
        return ResponseEntity.ok(new JsonResponse("done", response));
    }


    @GetMapping("/state")
    public ResponseEntity<?> getState(){
        List<State> state = userManagementService.getStates();
        return ResponseEntity.ok(new JsonResponse("Found", state));
    }


    @GetMapping("/lga")
    public ResponseEntity<?> getLga(@RequestParam Long id){
        List<Lga> lga = userManagementService.getLga(id);
        return ResponseEntity.ok(new JsonResponse("Found", lga));
    }

    @GetMapping("/area")
    public ResponseEntity<?> getArea(@RequestParam Long id){
        List<Area> area = userManagementService.getArea(id);
        return ResponseEntity.ok(new JsonResponse("Found", area));
    }
}
