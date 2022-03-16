package com.google.solution.accident.presentation;

import com.google.solution.accident.domain.AccidentRegion;
import com.google.solution.accident.domain.AccidentRegionRepository;
import com.google.solution.accident.utils.AccidentDataParser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserAccidentRegionController {

    private final AccidentRegionRepository accidentRegionRepository;
    private final AccidentDataParser accidentDataParser;


    @PostMapping("/regions")
    public void createRegion(){
        return;
    }

    @GetMapping("/regions/users")
    public List<AccidentRegion> getUserRegions(){
        return accidentRegionRepository.findTop30ByOrderById();
    }

    @GetMapping("/regions/users/me")
    public List<AccidentRegion> getMyRegions(){
        return accidentRegionRepository.findTop30ByOrderById();
    }

}
