package com.barogo.api.config.secuirity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

@Component
public class AuthTokenProvider {

    Algorithm algorithmHS;
    private String secretKey = "dlghgus";
    private long tokenValidTime = 3 * 60 * 1000L;

    @PostConstruct
    public void init() {
        algorithmHS = Algorithm.HMAC256(Base64.getEncoder().encodeToString(secretKey.getBytes()));
    }

    public String valiToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithmHS)
                    .acceptExpiresAt(tokenValidTime)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            String memberId = jwt.getClaim("memberId").asString();
            return memberId;
        } catch (JWTVerificationException e) {
            throw  new RuntimeException("토큰이 잘못 되었습니다");
        }
    }

    public String createToken(String memberId) {
        Date now = new Date();
        try {
            return JWT.create()
                    .withExpiresAt(new Date(new Date().getTime() + tokenValidTime))
                    .withClaim("memberId", memberId)
                    .sign(algorithmHS);
        } catch (JWTCreationException e) {
            throw  new RuntimeException("토큰을 생성하지 못했습니다.");
        }
    }
}
