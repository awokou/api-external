package com.server.api.external.service;

import com.server.api.external.model.Post;
import com.server.api.external.repository.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    @Value("${client.baseUrl}")
    private String baseUrl;

    public PostService(PostRepository postRepository, RestTemplate restTemplate) {
        this.postRepository = postRepository;
        this.restTemplate = restTemplate;
    }

    public void fetchAndSavePosts() {
        Post[] posts = restTemplate.getForObject(baseUrl + "/posts", Post[].class);
        if (posts != null) {
            List<Post> postList = Arrays.asList(posts);
            for (Post post : postList) {
                Post existingPost = postRepository.findById(post.getId()).orElse(null);
                if (postRepository.findByUserIdAndTitle(post.getUserId(), post.getTitle()).isEmpty()) {
                    // Si l'enregistrement n'existe pas, l'ajouter
                    postRepository.save(post);
                } else {
                    // Si l'enregistrement existe, vérifier les modifications
                    if (!existingPost.getTitle().equals(post.getTitle()) || !existingPost.getBody().equals(post.getBody())) {
                        // Mettre à jour uniquement si le titre ou le contenu a changé
                        existingPost.setTitle(post.getTitle());
                        existingPost.setBody(post.getBody());
                        postRepository.save(existingPost); // Sauvegarde la mise à jour
                    }
                }
            }
        }
    }
}
