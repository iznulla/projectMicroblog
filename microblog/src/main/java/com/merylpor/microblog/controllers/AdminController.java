package com.merylpor.microblog.controllers;

import com.merylpor.microblog.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "Hi " + principal.getUsername();
    }
}
