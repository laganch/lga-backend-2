package com.government.government.repository;

import com.government.government.dto.SettingsDto;
import com.government.government.entity.AppModules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppModuleRepo extends JpaRepository<AppModules, Long> {
    AppModules findFirstByName(String dto);
}
