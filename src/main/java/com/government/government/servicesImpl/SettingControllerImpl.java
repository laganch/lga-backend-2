package com.government.government.servicesImpl;

import com.government.government.Enum.GenericStatusConstant;
import com.government.government.dto.ModuleDto;
import com.government.government.dto.SettingsDto;
import com.government.government.entity.AppModules;
import com.government.government.entity.Lga;
import com.government.government.entity.Users;
import com.government.government.filter.JwtFilter;
import com.government.government.repository.AppModuleRepo;
import com.government.government.repository.LgaRepository;
import com.government.government.service.SettingControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SettingControllerImpl implements SettingControllerService {

    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private LgaRepository lgaRepository;
    @Autowired
    private AppModuleRepo appModuleRepo;

    @Override
    public Object saveSettingsApplication(SettingsDto dto) {

        Users user = jwtFilter.user;
        Lga lga = lgaRepository.findById(user.getLga().getId()).get();
        lga.setLgaSlogan(dto.getLgaSlogan());
        lga.setAppName(dto.getAppName());
        lga.setAlternate(dto.getAlternate());
        lga.setBanner(dto.getBanner());
        lga.setContact(dto.getContact());
        lga.setWebsite(dto.getWebsite());
        lga.setColor(dto.getColor());
        lga.setBanner(dto.getBanner());
        lga.setLogo(dto.getLogo());

        return lgaRepository.save(lga);
    }

    @Override
    public Object saveSettingsModules(ModuleDto dto) {

        AppModules modules = appModuleRepo.findFirstByName(dto.getName());
        if (modules != null){
            modules.setModuleStatus(dto.getModuleStatus());
            modules.setIcon(dto.getIcon());
            modules.setUri(dto.getUri());

            return appModuleRepo.save(modules);
        }

        AppModules appModules = new AppModules();
        appModules.setUri(dto.getUri());
        appModules.setName(dto.getName());
        appModules.setIcon(dto.getIcon());
        appModules.setStatus(GenericStatusConstant.ACTIVE);
        appModules.setCreatedAt(LocalDateTime.now());
        appModules.setCreatedBy(jwtFilter.user);

        return appModuleRepo.save(appModules);
    }

    @Override
    public Object saveSettingsMedia(SettingsDto dto) {
        return null;
    }
}
