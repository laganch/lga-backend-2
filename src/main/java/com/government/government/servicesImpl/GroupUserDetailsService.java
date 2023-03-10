package com.government.government.servicesImpl;

import com.government.government.entity.Users;
import com.government.government.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsernameIgnoreCase(username);
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getGeneratedPassword(), new ArrayList<>());
//        return user.map(GroupUserDetails::new).orElseThrow(()->new UsernameNotFoundException(username + " Does not exists"));
    }
}
