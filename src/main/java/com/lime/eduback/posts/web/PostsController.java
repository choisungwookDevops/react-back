package com.lime.eduback.posts.web;

import com.lime.eduback.posts.domain.Posts;
import com.lime.eduback.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/api/postsList")
    public List<Posts> findAll() {
        return postsService.findAll();
    }
    
    @PostMapping("/api/posts")
    public Long insert(@RequestBody Posts posts) {
        return postsService.save(posts);
    }

    @GetMapping("/api/posts/{id}")
    public Posts findById(@PathVariable("id") Long id) {
        return postsService.findById(id);
    }
}
