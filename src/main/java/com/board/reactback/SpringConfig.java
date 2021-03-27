package com.board.reactback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.board.reactback.posts.repository.PostsRepository;
import com.board.reactback.posts.service.PostsService;

@Configuration
public class SpringConfig {

    @Bean PostsService postsService(PostsRepository postsRepository) {
        return new PostsService(postsRepository);
    }
}
