package com.government.government.repository;

import com.government.government.entity.Area;
import com.government.government.entity.Lga;
import com.government.government.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findAllByLga(Lga lga);

    Optional<Area> findByNameIgnoreCase(String name);
}
