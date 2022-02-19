package com.google.solution.auth;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTProvider {

    private String secretKey = "secret_temp";

    private long accessTokenDurationTime = 1000L;

    private Algorithm algorithm = Algorithm.HMAC256(secretKey);

}
