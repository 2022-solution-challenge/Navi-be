package com.google.solution.accident.application;

import com.google.solution.accident.domain.AccidentRegion;
import com.google.solution.accident.domain.AccidentRegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentRegionService {

    private final AccidentRegionRepository accidentRegionRepository;

    public List<AccidentRegion> retrieveAccidentRegions() {
        return accidentRegionRepository.findAll();
    }

    public List<AccidentRegion> retrieveAccidentRegionsByLimit() {
        return accidentRegionRepository.findTop30ByOrderById();
    }

    public AccidentRegion retrieveAccidentRegionsById(Long id) {
        return accidentRegionRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }


}
