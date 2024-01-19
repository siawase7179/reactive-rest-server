package com.reactive.reactiverestserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;


@EnableWebFlux
@SpringBootApplication
public class ReactiveRestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRestServerApplication.class, args);
	}

}
