package com.fan.che.kafkatemplate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KafkatemplateApplication extends SpringBootServletInitializer {
    public static Logger logger = LoggerFactory.getLogger(KafkatemplateApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(KafkatemplateApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(KafkatemplateApplication.class);
}
}
