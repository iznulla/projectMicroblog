package com.merylpor.microblog.controllers;

import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired private UserService userService;


    @PostMapping
    public void addUser(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
    }

    @GetMapping
    public List<UserEntity> allUsers() {
        System.out.println(userService.allUsers());
        return userService.allUsers();
    }

    @GetMapping("{name}")
    public UserEntity getUserByName(@PathVariable String name) {
        return userService.getUserByUsername(name).orElse(null);
    }

}
