package com.server.api.external.service;

import com.server.api.external.client.WebToolsRestClient;
import com.server.api.external.dto.reponse.AirlineResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebToolsService {

    private final WebToolsRestClient apiClient;

    public WebToolsService(WebToolsRestClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<AirlineResponse> readAirlineData () {
       return apiClient.readAirLines();
    }

    public AirlineResponse readAirLineById (String airlineId) {
        return apiClient.readAirLineById(airlineId);
    }
}
