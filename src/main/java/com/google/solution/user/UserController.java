package com.google.solution.user;

import com.google.solution.user.dto.LoginRequest;
import com.google.solution.user.dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

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
