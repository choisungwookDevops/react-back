package com.lime.eduback;

import com.lime.eduback.posts.repository.PostsRepository;
import com.lime.eduback.posts.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean PostsService postsService(PostsRepository postsRepository) {
        return new PostsService(postsRepository);
    }
}
