package com.server.api.external.service;

import com.server.api.external.dto.reponse.CodeReponse;
import com.server.api.external.entity.Post;
import com.server.api.external.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class PostService {

    public static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    @Value("${client.baseUrl}")
    private String baseUrl;

    public PostService(PostRepository postRepository, RestTemplate restTemplate) {
        this.postRepository = postRepository;
        this.restTemplate = restTemplate;
    }

    public CodeReponse fetchAndSavePosts() {
        var code = new CodeReponse();
        try {
            Post[] posts = restTemplate.getForObject(baseUrl + "/posts", Post[].class);
            if (posts != null) {
                List<Post> postList = Arrays.asList(posts);
                for (Post post : postList) {
                    Post existingPost = postRepository.findById(post.getId()).orElse(null);
                    if (postRepository.findByUserIdAndTitle(post.getUserId(), post.getTitle()).isEmpty()) {
                        postRepository.save(post);
                    } else {
                        existingPost.setTitle(post.getTitle());
                        existingPost.setBody(post.getBody());
                        existingPost.setUserId(post.getUserId());
                        postRepository.save(existingPost);

                        LOGGER.info("Demarrage de la mise à jour des données de la base {}");
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error de recuperation des donnees");
            code.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            code.setLibelle("KO");
        }
        LOGGER.info("Fin du demarrage {}");
        return code;
    }

    public String getPost(int id) {
        String url = baseUrl + "/posts/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    public void deletePost(int id) {
        String url = baseUrl + "/posts/" + id;
        restTemplate.delete(url);
    }
}
