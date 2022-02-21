package com.google.solution;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

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
        return "Helloo!  " + name;
    }
}
