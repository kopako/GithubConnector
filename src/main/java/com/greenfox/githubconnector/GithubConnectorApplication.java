package com.greenfox.githubconnector;

import com.greenfox.githubconnector.property.GithubProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties.class)
public class GithubConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GithubConnectorApplication.class, args);
    }

}