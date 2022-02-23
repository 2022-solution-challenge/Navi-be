package com.google.solution.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    private static final String ENDPOINT = "https://accounts.google.com/o/oauth2/v2/auth";

    @Value("spring.google.oauth.client_id")
    private String CLIENT_ID ;
    private static final String REDIRECT_URI = "https://localhost:8080/home";
    private static final String RESPONSE_TYPE = "code";
    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";


    @GetMapping("/login")
    public String login() {
        return "redirect:" + ENDPOINT + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI
                + "&response_type=" + RESPONSE_TYPE + "&scope=" + SCOPE;
    }
}
