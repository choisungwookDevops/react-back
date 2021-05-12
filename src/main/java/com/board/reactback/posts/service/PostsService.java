package com.board.reactback.posts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.board.reactback.posts.domain.Posts;
import com.board.reactback.posts.repository.PostsRepository;

public class PostsService {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional(readOnly = true)
    public Posts findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return posts;
    }

    @Transactional(readOnly = true)
    public List<Posts> findAll() {
        return postsRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(Posts posts) {
        return postsRepository.save(posts).getId();
    }

    @Transactional
    public Long update(Long id, Posts posts) {
        Posts postsData = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postsData.update(posts.getTitle(), posts.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

}
