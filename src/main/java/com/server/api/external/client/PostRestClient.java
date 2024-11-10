package com.server.api.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "postRestClient", url = "${client.baseUrl}")
public interface PostRestClient {

    @GetMapping("/posts/{id}")
    String getPostById(@PathVariable("id") int id);
}
