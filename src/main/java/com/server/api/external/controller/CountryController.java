package com.server.api.external.controller;

import com.server.api.external.model.AirlineModel;
import com.server.api.external.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public ResponseEntity<Object> getCountrys() {
        try {
            Object result = this.countryService.getAllCountry();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/airline")
    public ResponseEntity<Object> createAirlineRest(@RequestBody AirlineModel body) {
        try {
            Object result = this.countryService.createAirlineRest(body);
            return new ResponseEntity<>( result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
