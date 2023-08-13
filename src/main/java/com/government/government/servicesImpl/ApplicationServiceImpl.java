package com.government.government.servicesImpl;

import com.government.government.dto.MarriageDto;
import com.government.government.entity.applications.DeathApplications;
import com.government.government.entity.applications.MarriageApplication;
import com.government.government.repository.DeathApplicationRepo;
import com.government.government.repository.MarriageApplicationRepo;
import com.government.government.security.JwtService;
import com.government.government.service.ApplicationServiceCtrl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationServiceCtrl {

    private final DeathApplicationRepo deathApplicationRepo;
    private final MarriageApplicationRepo marriageApplicationRepo;
    private final JwtService jwtUserDetailsService;

    @Override
    public DeathApplications saveDeathApplication(DeathApplications dto) {
        DeathApplications applications =  deathApplicationRepo.save(dto);
        return applications;
    }

    @Override
    public MarriageApplication saveMarriageApplication(MarriageApplication dto) {

        if (jwtUserDetailsService.user.getRoles().equalsIgnoreCase("USER")){
            dto.setGroom(jwtUserDetailsService.user);
        }

        dto.setCreatedBy(jwtUserDetailsService.user);

        MarriageApplication application = marriageApplicationRepo.save(dto);
        return application;
    }
}
