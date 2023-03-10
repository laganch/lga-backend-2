package com.government.government.dto;

import lombok.Data;
import java.util.Date;

@Data
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
