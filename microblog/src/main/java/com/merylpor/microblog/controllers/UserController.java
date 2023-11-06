package com.merylpor.microblog.controllers;

import com.merylpor.microblog.entity.User;
import com.merylpor.microblog.repository.UserRepository;
import com.merylpor.microblog.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping
    public List<User> allUsers() {
        return userService.allUsers();
    }

    @GetMapping("{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

}
