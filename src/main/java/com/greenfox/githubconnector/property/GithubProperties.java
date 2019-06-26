package com.greenfox.githubconnector.property;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(value = "github")

public class GithubProperties {
    private String owner;
    private String repo;
    private String token;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
