package com.example.springredditclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
public class SpringredditcloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringredditcloneApplication.class, args);
	}

}
