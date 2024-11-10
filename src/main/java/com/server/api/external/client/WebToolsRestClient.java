package com.server.api.external.client;

import com.server.api.external.dto.reponse.AirlineResponse;
import com.server.api.external.dto.reponse.PaginatedPassengerResponse;
import com.server.api.external.dto.request.AirlineCreateRequest;
import com.server.api.external.dto.request.PassengerUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "webToolsRestClient", url = "${client.airlinesUrl}")
public interface WebToolsRestClient {

    @PostMapping("/airlines")
    AirlineResponse createAirline(@RequestBody AirlineCreateRequest airlineCreateRequest);

    @GetMapping("/airlines")
    List<AirlineResponse> readAirLines();

    @GetMapping("/airlines/{airlineId}")
    AirlineResponse readAirLineById(@PathVariable("airlineId") String airlineId);

    @GetMapping("/passenger")
    PaginatedPassengerResponse readPassengers(@RequestParam("size") Long size, @RequestParam("page") Long page);

    @PutMapping("/passenger/{passengerId}")
    String updatePassenger(@PathVariable("passengerId") String passengerId, @RequestBody PassengerUpdateRequest request);

    @DeleteMapping("/passenger/{passengerId}")
    String deletePassenger(@PathVariable("passengerId") String passengerId);
}
