package com.reactive.reactiverestserver.filter;

import java.util.UUID;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.reactive.reactiverestserver.consts.HeaderConst;

import reactor.core.publisher.Mono;

@Component
public class GlobalFilter implements WebFilter{
    

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String traceId = UUID.randomUUID().toString();

        ServerHttpRequest request = exchange.getRequest().mutate()
                .header(HeaderConst.TRACE_ID, traceId)
                .build();

        return chain.filter(
            exchange.mutate().request(request).build()
        );
    }
    
}