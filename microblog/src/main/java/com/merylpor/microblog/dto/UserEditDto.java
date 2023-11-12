package com.merylpor.microblog.dto;

import com.merylpor.microblog.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Component
public class UserEditDto {
    private String username;
    private String name;

    public static UserEditDto fromEntity(UserEntity entity) {
       return UserEditDto.builder()
                .username(entity.getUsername())
                .name(entity.getName())
                .build();
    }
}
