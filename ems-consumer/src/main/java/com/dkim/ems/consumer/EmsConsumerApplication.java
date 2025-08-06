package com.dkim.ems.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.dkim.ems.consumer",
    "com.dkim.ems.common"
})
public class EmsConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmsConsumerApplication.class, args);
    }
}
