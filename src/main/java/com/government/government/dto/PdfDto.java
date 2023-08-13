package com.government.government.dto;

import com.government.government.entity.applications.DeathApplications;
import com.government.government.entity.applications.MarriageApplication;
import lombok.Data;

import java.util.Map;

@Data
public class PdfDto {
    private String templateName;
    private DeathApplications card;
    private MarriageApplication marriageCard;
    private Map<String, Object> extraParameter;
}
