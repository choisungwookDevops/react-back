package com.lime.eduback.posts.repository;

import com.lime.eduback.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
