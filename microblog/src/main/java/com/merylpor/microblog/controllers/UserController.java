package com.merylpor.microblog.controllers;

import com.merylpor.microblog.dto.UserEditDto;
import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired private UserService userService;


    @PostMapping
    public UserEditDto addUser(@RequestBody UserEditDto userEditDto) {
        userService.saveUser(UserEditDto.toEntity(userEditDto));
        return userEditDto;
    }

    @GetMapping
    public List<UserEntity> allUsers() {
        return userService.allUsers();
    }


    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public UserEditDto userEdit(@PathVariable Long id, @RequestBody UserEditDto userEditDto) {
        userService.updateUser(id, userEditDto);
        return userEditDto;
    }

    @DeleteMapping("/{id}")
    public void userDelete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
