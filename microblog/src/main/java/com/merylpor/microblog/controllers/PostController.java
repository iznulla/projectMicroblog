package com.merylpor.microblog.controllers;


import com.merylpor.microblog.dto.PostCreateUpdateDto;
import com.merylpor.microblog.dto.PostsAllDto;
import com.merylpor.microblog.dto.ViewPostDto;
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
    public List<PostsAllDto> allPosts() {

        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public ViewPostDto viewPostDto(@PathVariable Long id) {
        PostsEntity post = postService.findPostById(id);
        return ViewPostDto.builder()
                .id(post.getId())
                .author(post.getUser().getUsername())
                .post(post.getBody())
                .createAt(post.getTimestamp())
                .build();
    }

    @PatchMapping("/{id}")
    public ViewPostDto updatePost(@PathVariable Long id, @RequestBody PostCreateUpdateDto updateRequest) {
        PostsEntity post = postService.findPostById(id);
        post.setBody(updateRequest.getBodyText());
        postService.postUpdate(post);
        return ViewPostDto.builder()
                .id(post.getId())
                .author(post.getUser().getUsername())
                .post(post.getBody())
                .createAt(post.getTimestamp())
                .build();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
