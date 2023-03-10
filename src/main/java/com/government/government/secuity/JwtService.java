package com.government.government.secuity;

import com.government.government.entity.Users;
import com.government.government.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;


@Service
public class JwtService {

    @Autowired
    private UserRepository repository;

    public Users getLoggedInUser(){
        return repository.findByUsernameIgnoreCase(Principal.class.getName());
    }
}
