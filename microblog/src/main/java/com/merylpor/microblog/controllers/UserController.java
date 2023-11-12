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
    public void addUser(@RequestBody UserEditDto userEntity) {
        userService.saveUser(UserEntity.builder()
                        .username(userEntity.getUsername())
                        .name(userEntity.getName())
                        .createDate(Instant.now())
                .build());
    }

    @GetMapping
    public List<UserEntity> allUsers() {
        return userService.allUsers();
    }

//    @GetMapping("/{name}")
//    public UserEntity getUserByName(@PathVariable String name) {
//        return userService.getUserByUsername(name).orElse(null);
//    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public void userEdit(@PathVariable Long id, @RequestBody UserEditDto editInfo) {
        UserEntity user = userService.getUserById(id).orElse(null);
        assert user != null;
        user.setUsername(editInfo.getUsername());
        user.setName(editInfo.getName());
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void userDelete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
