package com.example.springredditclone;

import com.example.springredditclone.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
@Import(OpenAPIConfiguration.class)
public class SpringredditcloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringredditcloneApplication.class, args);
	}

}
