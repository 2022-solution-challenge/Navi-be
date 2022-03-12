package com.google.solution.accident.presentation;

import com.google.solution.accident.domain.AccidentRegion;
import com.google.solution.accident.domain.AccidentRegionRepository;
import com.google.solution.accident.utils.AccidentDataParser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccidentRegionController {

    private final AccidentRegionRepository accidentRegionRepository;
    private final AccidentDataParser accidentDataParser;


    @GetMapping("/regions")
    public List<AccidentRegion> getRegion(){
        return accidentRegionRepository.findAll();
    }

    @GetMapping("/regions/limit")
    public List<AccidentRegion> getRegionLimit(){
        return accidentRegionRepository.findTop30ByOrderById();
    }

    @GetMapping("/load")
    public String loadData() throws IOException {
        accidentRegionRepository.deleteAll();
        List<AccidentRegion> accidentRegions = accidentDataParser.parseCaliforniaData();
        accidentRegionRepository.saveAll(accidentRegions);
        return "sucess";
    }

}
