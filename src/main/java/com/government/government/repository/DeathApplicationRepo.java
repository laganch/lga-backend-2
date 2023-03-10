package com.government.government.repository;

import com.government.government.entity.applications.DeathApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathApplicationRepo extends JpaRepository<DeathApplications, Long> {
    DeathApplications findByApplicationId(String aid);
}
