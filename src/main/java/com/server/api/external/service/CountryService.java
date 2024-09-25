package com.server.api.external.service;

import com.server.api.external.model.AirlineModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${country.api.uri}")
    private String countryURI;

    @Value("${country.api.uriCreate}")
    private String uriCreate;

    public Object getAllCountry() {
        try {
            return restTemplate.getForObject(countryURI, Object.class);
        } catch (Exception e) {
            LOGGER.error("Exception pour recuperer les pays", e.getMessage());
            return  null;
        }
    }

    public Object createAirlineRest(AirlineModel body) {
        try {
            return restTemplate.postForEntity(uriCreate, body, Object.class);
        }catch (Exception e){
           return null;
        }
    }
}
