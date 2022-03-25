package com.google.solution.user;

import com.google.solution.user.dto.LoginRequest;
import com.google.solution.user.dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import com.google.solution.user.OAuthProvider.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Value("${spring.google.oauth.client_id}")
    private String CLIENT_ID ;
    @Value("${spring.google.oauth.redirect_uri:http://localhost:8080/login/oauth2/google}")
    private String REDIRECT_URI;
    private static final String RESPONSE_TYPE = "code";
    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";
    private final OAuthProvider oAuthProvider;

    @PostMapping("")
    public ResponseEntity<Void> register(@RequestBody RegistrationRequest request){
        Long userId = userService.saveUser(request);
        return ResponseEntity.created(URI.create("/users/" + userId)).build();
    }

    @GetMapping("/login")
    public String login(@RequestBody LoginRequest request){
        String token = userService.signIn(request);
        return token;
    }
}
