package com.google.solution.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTProvider {

    private String secretKey = "secret_temp";

    private long accessTokenDurationTime = 1000L;

    private final Algorithm algorithm = Algorithm.HMAC256(secretKey);

    public String createAccessToken(String email) {
        return createJWT(email, accessTokenDurationTime);
    }

    private String createJWT(String email, long tokenDurationTime) {
        Date now = new Date();
        Date expirationTime = new Date(now.getTime() + tokenDurationTime);

        return JWT.create()
                .withSubject(email)
                .withIssuedAt(now)
                .withExpiresAt(expirationTime)
                .sign(algorithm);
    }

    public DecodedJWT verifyAndDecodeJwt(String token) throws JWTVerificationException {
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT;
    }

}
