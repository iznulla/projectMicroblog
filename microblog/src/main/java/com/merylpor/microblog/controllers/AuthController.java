package com.merylpor.microblog.controllers;


import com.merylpor.microblog.dto.LoginUserDto;
import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.model.LoginResponse;
import com.merylpor.microblog.security.JwtIssuer;
import com.merylpor.microblog.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/login")
public class AuthController {

//    private final LoginProcessor loginProcessor;

    private final UserService userService;
    private final JwtIssuer jwtIssuer;


    public AuthController(UserService userService, JwtIssuer jwtIssuer) {
        this.userService = userService;
        this.jwtIssuer = jwtIssuer;
    }

    @PostMapping
    public LoginResponse login(@RequestBody @Validated LoginUserDto request) {
        System.out.println(request.getUsername());
        UserEntity user = userService.getUserByUsername(request.getUsername()).orElse(null);
        assert user != null;
        var token = jwtIssuer.issue(user.getId(), user.getUsername(), user.getRole());
        return LoginResponse.builder().accessToken(token).build();
    }
}
