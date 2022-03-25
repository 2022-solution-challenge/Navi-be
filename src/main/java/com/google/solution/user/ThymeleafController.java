package com.google.solution.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    @GetMapping("/login/oauth2/google")
    public String redirectLogin(@RequestParam(name = "code") String code) {
        return "logins";
    }
}
