package com.government.government.service;

import com.government.government.dto.PrintDto;
import org.springframework.core.io.Resource;

import java.util.List;

public interface PrintService {
    Resource printCard(List<PrintDto> dtos) throws Exception;

    Resource printMarriage(List<PrintDto> dtos) throws Exception;
}
