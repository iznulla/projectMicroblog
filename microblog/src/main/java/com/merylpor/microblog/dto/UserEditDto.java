package com.merylpor.microblog.dto;

import com.merylpor.microblog.entity.Role;
import com.merylpor.microblog.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Component
public class UserEditDto {
    private String username;
    private String name;
    private Role role;
    private Instant createAt;
    private String password;

    public static UserEditDto fromEntity(UserEntity entity) {
       return UserEditDto.builder()
                .username(entity.getUsername())
                .name(entity.getName())
                .build();
    }

    public static UserEntity toEntity(UserEditDto userEditDto) {
        return UserEntity.builder()
                .username(userEditDto.getUsername())
                .name(userEditDto.getName())
                .role(Role.USER)
                .createDate(Instant.now())
                .password(userEditDto.getPassword())
                .build();
    }
}
