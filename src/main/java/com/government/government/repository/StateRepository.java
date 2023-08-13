package com.government.government.repository;

import com.government.government.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findByNameIgnoreCase(String name);
}
