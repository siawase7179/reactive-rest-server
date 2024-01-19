package com.reactive.reactiverestserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.reactiverestserver.consts.HeaderConst;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/v1")
public class AuthContorller {

    @PostMapping(
        value = "/auth/token",        
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Mono<ResponseEntity<Object>> requestAuth(
        @RequestHeader(HeaderConst.CLIENT_ID) String clientId,
        @RequestHeader(HeaderConst.CLIENT_PASSWORD) String clinetPassword
        // @RequestHeader(HeaderConst.TRACE_ID) String traceId
    ){
        return Mono.defer(() -> {
            try{
                log.info("id:{}, password:{}", clientId, clinetPassword);
                return Mono.just(
                        ResponseEntity.ok().build()
                    );
            }catch(Exception e){
                return Mono.just(
                        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                    );
            }
        }).onErrorResume(Exception.class, e->{
            log.error("eror", e);
            return Mono.just(
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                );
        });
    }
    
}
