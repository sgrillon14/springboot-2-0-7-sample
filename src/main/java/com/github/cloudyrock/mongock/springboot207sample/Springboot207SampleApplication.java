package com.github.cloudyrock.mongock.springboot207sample;

import com.github.cloudyrock.mongock.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Springboot207SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot207SampleApplication.class, args);
    }

    @Bean
    ClientController clientController() {
        return new ClientController();
    }

    @Bean
    public Mongock mongock() {
        MongoClient mongoclient = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));
        return new SpringMongockBuilder(mongoclient,
                "mongock_db_springboot_207",
                "com.github.cloudyrock.mongock.springboot207sample.changesets")
                .setLockQuickConfig()
                .build();
    }

}

