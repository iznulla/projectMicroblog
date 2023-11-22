package com.merylpor.microblog.service;

import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.model.LoginResponse;
import com.merylpor.microblog.security.JwtIssuer;
import com.merylpor.microblog.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoggingManagerService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtIssuer jwtIssuer;

    public LoginResponse attemptLogin(String username, String password) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();
        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        System.out.println(roles);
        UserEntity user = userService.getUserByUsername(username).orElseThrow();
        var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername(), roles);
        return LoginResponse.builder().accessToken(token).build();
    }
}
