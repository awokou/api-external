package com.server.api.external.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AlbumService.class);

    private final RestTemplate restTemplate;

    @Value("${client.baseUrl}")
    private String baseURL;

    public AlbumService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getAllAlbums() {
        try {
            return this.restTemplate.getForObject(baseURL + "/albums/", Object.class);
        } catch (Exception e) {
            LOGGER.error("Exception album {} ", e.getMessage());
            return null;
        }
    }
}
