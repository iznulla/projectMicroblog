package com.merylpor.microblog.processor;

import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.service.LoggingManagerService;
import com.merylpor.microblog.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Builder
@AllArgsConstructor
public class LoginProcessor {

    private LoggingManagerService loggingManagerService;
    private UserService userService;

    public boolean login(String username) {
        UserEntity userEntity = userService.getUserByUsername(username).orElse(null);
        if (userEntity != null) {
            loggingManagerService.setUser(userEntity);
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        if (loggingManagerService.getUser()!= null)
            loggingManagerService.setUser(null);
    }
}
