package com.google.solution;

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
public class TestController {

    private final AccidentRegionRepository accidentRegionRepository;
    private final AccidentDataParser accidentDataParser;


    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "Hello!, " + request.getRequestURL();
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/user/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello!  " + name;
    }

}
