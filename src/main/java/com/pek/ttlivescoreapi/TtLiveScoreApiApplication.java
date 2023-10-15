package com.pek.ttlivescoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class})
public class TtLiveScoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtLiveScoreApiApplication.class, args);
    }

}
