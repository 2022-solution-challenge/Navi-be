package com.google.solution.user;

import com.google.solution.user.OAuthProvider.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {

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
        System.out.println(CLIENT_ID + REDIRECT_URI);
        String redirectURL = ENDPOINT + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI
                + "&response_type=" + RESPONSE_TYPE + "&scope=" + SCOPE;
        System.out.println(redirectURL);
        response.sendRedirect(redirectURL);
    }

    @GetMapping("/login/oauth2/google")
    public UserInfo redirectLogin(@RequestParam(name = "code") String code) {
        UserInfo userInfo = oAuthProvider.getUserInfoByApi(code);
        return userInfo;
        // send redirect to Client with data
    }
}
