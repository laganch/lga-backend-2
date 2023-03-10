package com.government.government.repository;

import com.government.government.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByRole(String role);

    Menu findByRoleAndLink(String role, String menu);
}
