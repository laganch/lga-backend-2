package com.government.government.servicesImpl;

import com.government.government.entity.Menu;
import com.government.government.repository.MenuRepository;
import com.government.government.service.MenuControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpli implements MenuControllerService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getMenu(String role) {
        return menuRepository.findAllByRole(role);
    }

    @Override
    public Boolean checkMenuPermission(String role, String menu) {
        Menu menu1 = menuRepository.findByRoleAndLink(role, menu);
        if(menu1 != null){
            return true;
        }
        return false;
    }
}
