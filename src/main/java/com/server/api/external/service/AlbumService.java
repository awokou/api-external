package com.server.api.external.service;

import com.server.api.external.model.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AlbumService.class);

    private final RestTemplate restTemplate;

    @Value("${api.uriAlbum}")
    private String uriAlbum;

    public AlbumService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getAllAlbums() {
        try {
            return this.restTemplate.getForObject(uriAlbum, Object.class);
        } catch (Exception e) {
            LOGGER.error("Exception album {} ", e.getMessage());
            return  null;
        }
    }

    public Object createAlbum(Album body) {
        try {
            return this.restTemplate.postForEntity(uriAlbum, body, Object.class);
        }catch (Exception e){
            return null;
        }
    }
}
