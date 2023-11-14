package com.merylpor.microblog.controllers;


import com.merylpor.microblog.dto.PostCreateUpdateDto;
import com.merylpor.microblog.dto.PostsDto;
import com.merylpor.microblog.entity.PostsEntity;
import com.merylpor.microblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired private PostService postService;

    @PostMapping
    public void createPost(@RequestBody PostCreateUpdateDto textBody) {
        postService.postCreate(textBody.getBodyText());
    }

    @GetMapping
    public List<?> allPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostsDto viewPostDto(@PathVariable Long id) {
        PostsEntity post = postService.findPostById(id);
        return PostsDto.fromEntity(post);
    }

    @PatchMapping("/{id}")
    public PostsDto updatePost(@PathVariable Long id, @RequestBody PostsDto postsDto) {
        postService.postUpdate(id, postsDto);
        return postsDto;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
