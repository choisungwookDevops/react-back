package com.board.reactback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class reactBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(reactBackApplication.class, args);
    }

}
