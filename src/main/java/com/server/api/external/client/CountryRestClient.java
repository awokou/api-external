package com.server.api.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "countryRestClient",url = "${client.countryUrl}")
public interface CountryRestClient {
    @GetMapping
    Object allCountry();
}
