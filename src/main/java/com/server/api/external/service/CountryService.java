package com.server.api.external.service;

import com.server.api.external.client.CountryRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    public static final String ERROR =  "Exception pour recuperate les pays {}";

    private final RestTemplate restTemplate;
    private final CountryRestClient countryRestClient;

    @Value("${client.countryUrl}")
    private String countryUrl;

    @Value("${client.airlinesUrl}")
    private String airlinesUrl;

    public CountryService(RestTemplate restTemplate, CountryRestClient countryRestClient) {
        this.restTemplate = restTemplate;
        this.countryRestClient = countryRestClient;
    }

    public Object getAllCountry() {
        try {
            return this.restTemplate.getForObject(countryUrl, Object.class);
        } catch (Exception e) {
            LOGGER.error(ERROR, e.getMessage());
            return null;
        }
    }

    public Object allCountry() {
        try {
            return countryRestClient.allCountry();
        } catch (Exception e) {
            return null;
        }
    }
}
