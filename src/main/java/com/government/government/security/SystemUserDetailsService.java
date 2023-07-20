package com.government.government.security;

import com.government.government.entity.Users;
import com.government.government.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SystemUserDetailsService implements UserDetailsService {

  private final UserRepository portalUserRepository;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<Users> user = portalUserRepository.findByUsernameIgnoreCase(username);
    if (!user.isPresent()) {
      throw new UsernameNotFoundException("Could not find user");
    }

    return new IVASUserDetails(user.get());

  }
}
