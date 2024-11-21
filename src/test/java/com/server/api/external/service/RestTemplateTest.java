package com.server.api.external.service;

import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestTemplateTest {

    @Test
    void testRestTemplate() {
        String url ="https://countriesnow.space/api/v0.1/countries/population/cities";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        assertNotNull(result);
    }

    @Test
    void getRequest_ReturnsContent() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", String.class);
        assertNotNull(response);
    }
}
