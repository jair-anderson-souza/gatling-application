package io.github.jass2125.gatling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GatlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatlingApplication.class, args);
	}

}
