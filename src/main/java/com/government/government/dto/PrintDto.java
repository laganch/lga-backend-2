package com.government.government.dto;

import com.government.government.Enum.CardTypeConstant;
import lombok.Data;

@Data
public class PrintDto {
    private Long id;
    private CardTypeConstant type;
    private String applicationId;
}
