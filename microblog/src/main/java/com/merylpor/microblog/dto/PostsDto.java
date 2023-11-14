package com.merylpor.microblog.dto;

import com.merylpor.microblog.entity.PostsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
public class PostsDto {
    private Long id;
    private String body;
    private Long userId;
    private Instant createAt;

    public static PostsDto fromEntity(PostsEntity entity) {
        return PostsDto.builder()
                .id(entity.getId())
                .body(entity.getBody())
                .userId(entity.getUser().getId())
                .createAt(entity.getTimestamp())
                .build();
    }
}
