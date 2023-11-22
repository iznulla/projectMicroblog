package com.merylpor.microblog.controllers;


import com.merylpor.microblog.dto.LoginUserDto;
import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.model.LoginResponse;
import com.merylpor.microblog.security.JwtIssuer;
import com.merylpor.microblog.security.UserPrincipal;
import com.merylpor.microblog.service.LoggingManagerService;
import com.merylpor.microblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth/login")
@RequiredArgsConstructor
public class AuthController {

    private final LoggingManagerService loggingManagerService;

    @PostMapping
    public LoginResponse login(@RequestBody @Validated LoginUserDto request) {
        return loggingManagerService.attemptLogin(request.getUsername(), request.getPassword());
    }
}
