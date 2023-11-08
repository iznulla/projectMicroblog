package com.merylpor.microblog.service;


import com.merylpor.microblog.entity.PostsEntity;
import com.merylpor.microblog.entity.UserEntity;
import com.merylpor.microblog.repository.PostsRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@Service
public class PostService {
    private final PostsRepository postRepository;
    private final LoggingManagerService loggingManagerService;


    public void postCreate(String posts) {
        PostsEntity postsEntity = PostsEntity.builder()
                .user(loggingManagerService.getUser())
                .body(posts)
                .timestamp(Instant.now()).build();
        postRepository.save(postsEntity);
    }

    public List<PostsEntity> findAllPosts() {
        return postRepository.findAll();
    }
}
