package com.merylpor.microblog.service;

import com.merylpor.microblog.dto.PostsDto;
import com.merylpor.microblog.entity.PostsEntity;
import com.merylpor.microblog.repository.PostsRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@Service
public class PostService {
    private final PostsRepository postRepository;
    private final LoggingManagerService loggingManagerService;


//    public void postCreate(String posts) {
//        PostsEntity postsEntity = PostsEntity.builder()
//                .user(loggingManagerService.getUser())
//                .body(posts)
//                .timestamp(Instant.now()).build();
//        postRepository.save(postsEntity);
//    }

    public void postUpdate(Long id, PostsDto postsDto) {
            PostsEntity post = postRepository.findById(id).orElse(null);
            assert post != null;
            post.setBody(postsDto.getBody());
            postRepository.save(post);
    }

    public PostsEntity findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

//    public void deletePost(Long id) {
//        PostsEntity posts = findPostById(id);
//        if (posts.getUser().getId().equals(loggingManagerService.getUser().getId()))
//            postRepository.delete(posts);
//    }

    public List<PostsDto> findAllPosts() {
        return postRepository.findAll().stream()
                .map(PostsDto::fromEntity)
                .collect(Collectors.toList());
    }
}
