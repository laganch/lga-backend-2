package com.government.government.service;

import com.government.government.dto.MarriageDto;
import com.government.government.entity.applications.BirthApplication;
import com.government.government.entity.applications.DeathApplications;
import com.government.government.entity.applications.MarriageApplication;

public interface ApplicationServiceCtrl {
    DeathApplications saveDeathApplication(DeathApplications dto);

    MarriageApplication saveMarriageApplication(MarriageApplication dto);

    BirthApplication saveBirthApplication(BirthApplication dto);
}
