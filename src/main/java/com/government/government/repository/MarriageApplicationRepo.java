package com.government.government.repository;

import com.government.government.entity.applications.MarriageApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarriageApplicationRepo extends JpaRepository<MarriageApplication, Long> {
}
