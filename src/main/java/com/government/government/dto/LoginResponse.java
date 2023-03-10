package com.government.government.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String name;
    private String image;
    private String token;
    private String role;
    private String lga;
    private String state;
}
