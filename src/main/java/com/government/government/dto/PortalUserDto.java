package com.government.government.dto;

import com.government.government.Enum.GenericStatusConstant;
import lombok.Data;

@Data
public class PortalUserDto {
    private Long id;
    private String name;
    private String email;
    private String dateCreated;
    private String role;
    private GenericStatusConstant status;
}
