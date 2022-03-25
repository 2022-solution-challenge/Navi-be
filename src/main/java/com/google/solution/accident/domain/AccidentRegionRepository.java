package com.google.solution.accident.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccidentRegionRepository extends JpaRepository<AccidentRegion, Long> {

    List<AccidentRegion> findTop30ByOrderById();

}
