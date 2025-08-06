package com.dkim.ems.consumer.controller;

import com.dkim.ems.common.model.HealthResponse;
import com.dkim.ems.consumer.config.ApplicationProperties;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
public class healthController {

    @Resource
    ApplicationProperties applicationProperties;
    @GetMapping("/health")
    public Mono<HealthResponse> health() {
        var response = HealthResponse.builder()
            .applicationName(applicationProperties.getName())
            .status(HttpStatus.OK.toString())
            .checkingTime(Instant.now())
            .build();
        return Mono.just(response);
    }
}
