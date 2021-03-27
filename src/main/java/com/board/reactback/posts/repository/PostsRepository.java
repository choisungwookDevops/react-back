package com.board.reactback.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.reactback.posts.domain.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
