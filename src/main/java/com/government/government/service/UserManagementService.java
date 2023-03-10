package com.government.government.service;

import com.government.government.dto.AuthRequest;
import com.government.government.dto.LoginResponse;
import com.government.government.dto.UserDto;
import com.government.government.entity.Area;
import com.government.government.entity.Lga;
import com.government.government.entity.State;
import com.government.government.entity.Users;

import java.util.List;

public interface UserManagementService {
    Users CreateUser(UserDto user);

    LoginResponse authenticateUser(AuthRequest dto) throws Exception;

    List<State> getStates();
    List<Lga> getLga(Long id);
    List<Area> getArea(Long id);
}
