package com.merylpor.microblog.controllers;

import com.merylpor.microblog.dto.LoginUserDto;
import com.merylpor.microblog.processor.LoginProcessor;
import lombok.Builder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/login")
@Builder
@RequestScope
public class LoginController {

    private final LoginProcessor loginProcessor;

    @PostMapping
    public void login(@RequestBody LoginUserDto username) {
        System.out.println(loginProcessor.login(username.getUsername()));

    }

    @GetMapping("/logout")
    public void logout() {
        loginProcessor.logout();
    }
}
