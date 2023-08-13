package com.government.government.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LgaDto {

    private String name;
    private Long stateId;
    private String code;
    private String logo;
    private String website;
}
