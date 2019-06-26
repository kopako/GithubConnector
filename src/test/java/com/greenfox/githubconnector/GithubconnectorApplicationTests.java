package com.greenfox.githubconnector;

import com.greenfox.githubconnector.service.GitHubServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubconnectorApplicationTests {

    @Test
    public void contextLoads() {
    }
//
//    @Test
//    public void getContentTest() {
//        String content = new GitHubServiceImpl().getContentOfFile("README.md");
//        System.out.println(content);
//    }
//
//
//    @Test
//    public void test() {
//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl
//                = "http://ip.jsontest.com/";
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(fooResourceUrl, String.class);
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//    }

}
