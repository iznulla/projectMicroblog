package com.merylpor.microblog.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.merylpor.microblog.entity.Role;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@Data
@Builder
public class JwtIssuer {

    private final JwtProperties properties;

    public String issue(Long userId, String username, Role role){
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS)))
                .withClaim("u", username)
                .withClaim("a", role.getAuthority())
                .sign(Algorithm.HMAC256(properties.getSecretKey()));
    }
}
