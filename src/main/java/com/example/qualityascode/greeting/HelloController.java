package com.example.qualityascode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
  @RequestMapping("/hello")
  public String hello() {
    return "Hello world";
  }

  @RequestMapping("/create-sonar-project")
  public String callRestfulAPI() {
    RestTemplate restTemplate = new RestTemplate();
    String uri = "https://sonarcloud.io/web_api/" + "/api/projects/create";

    HttpHeader headers = new HttpHeaders();
    // headers.setBearerAuth(token);
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("name", "test_name");
    requestBody.put("organization", "imbao");
    requestBody.put("project", "imb_project");

    HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

    ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,Object.class);

    return response;
  }
}
