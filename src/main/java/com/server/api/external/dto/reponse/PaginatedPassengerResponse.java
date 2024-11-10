package com.server.api.external.dto.reponse;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedPassengerResponse {
    private Long totalPassengers;
    private Long totalPages;
    private List<PassengerResponse> data;
}
