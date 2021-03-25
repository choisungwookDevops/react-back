package com.lime.eduback.posts.web;

import com.lime.eduback.posts.domain.Posts;
import com.lime.eduback.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/api/postList")
    public List<Posts> findAll() {
        return postsService.findAll();
    }
    
    @PostMapping("/api/posts")
    public Posts insert(@RequestBody Posts posts) {
        System.out.println("posts.toString() = " + posts.toString());
        return posts;
    }
}
