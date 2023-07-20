package com.government.government.repository;

import com.government.government.Enum.GenericStatusConstant;
import com.government.government.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsernameIgnoreCase(String username);

    Users findByEmailIgnoreCase(String email);
}
