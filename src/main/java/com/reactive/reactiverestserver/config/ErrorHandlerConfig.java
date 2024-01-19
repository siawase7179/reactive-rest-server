package com.reactive.reactiverestserver.config;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.reactive.reactiverestserver.exceptions.WebExceptionHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ErrorHandlerConfig {
    @Bean
    public ErrorWebExceptionHandler errorWebExceptionHandler() {
        return new WebExceptionHandler();
    }
}
