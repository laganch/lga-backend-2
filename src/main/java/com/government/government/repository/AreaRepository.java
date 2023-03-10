package com.government.government.repository;

import com.government.government.entity.Area;
import com.government.government.entity.Lga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findAllByLga(Lga lga);
}
