package com.merylpor.microblog.service;

import com.merylpor.microblog.entity.Posts;
import com.merylpor.microblog.entity.User;
import com.merylpor.microblog.repository.PostsRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Data
@Builder
@Service
public class PostService {
    private final PostsRepository postRepository;


    public void addPost(Posts posts, Long id) {

        posts.setTimestamp(Instant.now());
        postRepository.save(posts);
    }
}
