package com.government.government.service;

import com.government.government.entity.Menu;

import java.util.List;

public interface MenuControllerService {
    List<Menu> getMenu(String role);

    Boolean checkMenuPermission(String role, String menu);
}
