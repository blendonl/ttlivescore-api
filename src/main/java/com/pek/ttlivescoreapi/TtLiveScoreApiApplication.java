package com.pek.ttlivescoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class TtLiveScoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtLiveScoreApiApplication.class, args);
    }

}
