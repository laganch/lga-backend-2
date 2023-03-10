package com.government.government.service;

import com.government.government.dto.ModuleDto;
import com.government.government.dto.SettingsDto;

public interface SettingControllerService {
    Object saveSettingsApplication(SettingsDto dto);

    Object saveSettingsModules(ModuleDto dto);

    Object saveSettingsMedia(SettingsDto dto);
}
