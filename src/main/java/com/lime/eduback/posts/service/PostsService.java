package com.lime.eduback.posts.service;

import com.lime.eduback.posts.domain.Posts;
import com.lime.eduback.posts.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class PostsService {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public Posts findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return posts;
    };

    @Transactional(readOnly = true)
    public List<Posts> findAll() {
        return postsRepository.findAll().stream()
                .collect(Collectors.toList());
    };

    public Long save(Posts posts) {
        return postsRepository.save(posts).getId();
    }
}
