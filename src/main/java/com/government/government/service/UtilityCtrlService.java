package com.government.government.service;

import com.government.government.dto.ApplicationDto;
import com.government.government.dto.BirthDto;
import com.government.government.dto.MarriageDto;
import com.government.government.dto.ReportDto;
import com.government.government.entity.applications.BirthApplication;
import com.government.government.entity.applications.DeathApplications;
import com.government.government.entity.applications.MarriageApplication;

import java.util.List;

public interface UtilityCtrlService {
    List<ApplicationDto> getDeathApplicationSearch(List<DeathApplications> results);

    List<MarriageDto> getMarriageApplicationSearch(List<MarriageApplication> results);

    ReportDto ReportDashboard();

    DeathApplications getDeathApplication(String aid);

    Object GeneralApproval(String type, String aid);

    Object GeneralQuery(String type, String aid, String reason);

    Object DeathUpdate(String id);

    Object MarriageUpdate(String id);

    Object BirthUpdate(String id);

    List<BirthDto> getBirthApplicationSearch(List<BirthApplication> results);
}
