package com.government.government.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String otherNames;
    private String phoneNumber;
    private String address;
    private String photo;
    private String email;
    private Long lga;
    private Long area;
    private Long state;
    private String nin;
    private String password;
    private String role;
    private String gender;
    private Date dob;
}
