package com.board.reactback.posts.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.reactback.posts.domain.Posts;
import com.board.reactback.posts.service.PostsService;

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

    @GetMapping("/helloworld")
    public String hellworld(){
        return "hello world";
    }

    @PostMapping("/api/posts")
    public Long insert(@RequestBody Posts posts) {
        return postsService.save(posts);
    }

    @GetMapping("/api/posts/{id}")
    public Posts findById(@PathVariable("id") Long id) {
        return postsService.findById(id);
    }

    @PatchMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody Posts posts) {
        return postsService.update(id, posts);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
