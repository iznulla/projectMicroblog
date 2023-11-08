package com.merylpor.microblog.controllers;


import com.merylpor.microblog.dto.PostCreateDto;
import com.merylpor.microblog.entity.PostsEntity;
import com.merylpor.microblog.service.LoggingManagerService;
import com.merylpor.microblog.service.PostService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired private PostService postService;

    @PostMapping("/create")
    public void createPost(@RequestBody String textBody) {
        postService.postCreate(textBody);
    }

    @GetMapping
    public List<PostsEntity> allPosts() {
        return postService.findAllPosts();
    }
}
