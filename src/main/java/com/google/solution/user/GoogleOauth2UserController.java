package com.google.solution.user;

import com.google.solution.user.OAuthProvider.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GoogleOauth2UserController {

    private static final String ENDPOINT = "https://accounts.google.com/o/oauth2/v2/auth";

    @Value("${spring.google.oauth.client_id}")
    private String CLIENT_ID ;
    @Value("${spring.google.oauth.redirect_uri:http://localhost:8080/login/oauth2/google}")
    private String REDIRECT_URI;
    private static final String RESPONSE_TYPE = "code";
    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";
    private final OAuthProvider oAuthProvider;

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        String redirectURL = ENDPOINT + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI
                + "&response_type=" + RESPONSE_TYPE + "&scope=" + SCOPE;

        response.sendRedirect(redirectURL);
    }

    @GetMapping("/login2")
    public String login2(HttpServletResponse response) throws IOException {
        String redirectURL = ENDPOINT + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI
                + "&response_type=" + RESPONSE_TYPE + "&scope=" + SCOPE;

        return redirectURL;
    }

//    @GetMapping("/login/oauth2/google")
//    public String redirectLogin(@RequestParam(name = "code") String code) {
//    }


}
