package com.google.solution.accident.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccidentRegionRepository extends JpaRepository<UserAccidentRegion, Long> {

}
