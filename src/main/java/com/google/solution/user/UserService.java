package com.google.solution.user;

import com.google.solution.auth.JWTProvider;
import com.google.solution.user.dto.LoginRequest;
import com.google.solution.user.dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;

    public Long saveUser(RegistrationRequest request) {
        User user = userRepository.save(new User(request.getUsername(), passwordEncoder.encode(request.getPassword()), request.getEmail(), request.getPhoneNumber()));
        return user.getId();
    }

    public String signIn(LoginRequest request){
        String accessToken = jwtProvider.createAccessToken(request.getUsername());
        return accessToken;
    }




}
