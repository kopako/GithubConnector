package com.greenfox.githubconnector.controller;

import com.greenfox.githubconnector.service.GitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GithubController {
    private final GitService gitService;

    public GithubController(GitService gitService) {
        this.gitService = gitService;
    }

    @GetMapping("/{path}")
    public ResponseEntity<String> getContent(@PathVariable String path) {
        return new ResponseEntity<>(gitService.getContentOfFile(path), HttpStatus.OK);
    }
}
