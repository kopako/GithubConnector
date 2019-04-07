package com.greenfox.githubconnector.service;


import com.greenfox.githubconnector.property.GithubProperties;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@Service
public class GitHubServiceImpl implements GitService {

    private static final String CONTENT_URL = "https://api.github.com/repos/{owner}/{repo}/contents/{path}";
    private final RestTemplate restTemplate;
    private final GithubProperties properties;

    public GitHubServiceImpl(RestTemplateBuilder restTemplateBuilder, GithubProperties properties) {
        this.restTemplate = restTemplateBuilder
                .additionalInterceptors(new GithubAppTokenInterceptor(properties.getToken()))
                .build();
        this.properties = properties;
    }

    @Override
    public String getContentOfFile(String path) {
        ResponseEntity<Map> response = restTemplate.getForEntity(CONTENT_URL, Map.class
                , properties.getOwner()
                , properties.getRepo()
                , path);
        String contentBase64 = (String) Objects.requireNonNull(response.getBody()).get("content");
        return base64Decode(contentBase64);
    }

    private String base64Decode(String contentBase64) {
        byte[] decodedArray = Base64.decodeBase64(contentBase64.getBytes(StandardCharsets.UTF_8));
        return new String(decodedArray);
    }

    private static class GithubAppTokenInterceptor implements ClientHttpRequestInterceptor {

        private final String token;

        GithubAppTokenInterceptor(String token) {
            this.token = token;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                            ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
            if (StringUtils.hasText(this.token)) {
                byte[] basicAuthValue = this.token.getBytes(StandardCharsets.UTF_8);
                httpRequest.getHeaders().set(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString(basicAuthValue));
            }
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        }

    }


}
