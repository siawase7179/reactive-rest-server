package com.reactive.reactiverestserver.exceptions;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Order(-1)
@RequiredArgsConstructor
public class WebExceptionHandler implements ErrorWebExceptionHandler {


    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        log.error("remoteAddress:{}, uri:{}, method:{}, message:{}", 
                exchange.getRequest().getRemoteAddress().toString(),
                exchange.getRequest().getURI().getPath(),
                exchange.getRequest().getMethod().toString(),
                ex.getMessage());
        return Mono.error(ex);
    }
}
