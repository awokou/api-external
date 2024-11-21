package com.server.api.external.controller;

import com.server.api.external.client.PostRestClient;
import com.server.api.external.dto.reponse.AirlineResponse;
import com.server.api.external.service.PostService;
import com.server.api.external.service.WebToolsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final WebToolsService apiClient;
    private final PostRestClient postClient;
    private final PostService postService;

    public ApiController(WebToolsService apiClient, PostRestClient postClient, PostService postService) {
        this.apiClient = apiClient;
        this.postClient = postClient;
        this.postService = postService;
    }

    @GetMapping("/import")
    public String importPosts() {
        postService.fetchAndSavePosts();
        return "Données importées avec succès !";
    }

    @GetMapping("/post")
    public String getAllPost() {
        return postClient.getPostById(1);
    }

    @GetMapping("/airline")
    public ResponseEntity<List<AirlineResponse>> readAirlineData () {
        return ResponseEntity.ok(apiClient.readAirlineData());
    }

    @GetMapping("/airlines/{airlineId}")
    public ResponseEntity<AirlineResponse> readAirLineById (@PathVariable("airlineId") String airlineId) {
        return ResponseEntity.ok(apiClient.readAirLineById(airlineId));
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<String> getPostEntity(int id) {
        return ResponseEntity.ok(postService.getPost(id));
    }
}
