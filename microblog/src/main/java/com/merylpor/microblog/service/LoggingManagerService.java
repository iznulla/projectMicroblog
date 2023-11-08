package com.merylpor.microblog.service;

import com.merylpor.microblog.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class LoggingManagerService {

    @Autowired private UserService userService;

    public LoggingManagerService() {
        this.user = new UserEntity();
    }
    private UserEntity user;

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return this.user;
    }
}
