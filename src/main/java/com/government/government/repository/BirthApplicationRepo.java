package com.government.government.repository;

import com.government.government.entity.applications.BirthApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthApplicationRepo extends JpaRepository<BirthApplication, Long> {
    BirthApplication findByApplicationId(String id);
}
