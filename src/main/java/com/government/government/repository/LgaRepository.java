package com.government.government.repository;

import com.government.government.entity.Lga;
import com.government.government.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LgaRepository extends JpaRepository<Lga, Long> {
    List<Lga> findAllByState(State state);

    Optional<Lga> findByNameIgnoreCase(String name);
}
