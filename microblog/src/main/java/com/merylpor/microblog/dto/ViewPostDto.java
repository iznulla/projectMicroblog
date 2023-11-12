package com.merylpor.microblog.dto;

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
public class ViewPostDto {
    private Long id;
    private String author;
    private String post;
    private Instant createAt;
}
