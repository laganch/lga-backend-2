package com.government.government.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaDto {

    private String name;
    private Long lgaId;
    private String code;
    private String logo;
    private String website;
}
