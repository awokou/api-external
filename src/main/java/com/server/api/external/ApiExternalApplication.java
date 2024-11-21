package com.server.api.external;

import com.server.api.external.client.CountryRestClient;
import com.server.api.external.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ApiExternalApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiExternalApplication.class, args);
	}

	@Autowired
	PostService postRestClient;

	@Autowired
	CountryRestClient countryRestClient;

	@Bean
	public CommandLineRunner run() {
		return args -> {
			// GET ALL
			//Object response = countryRestClient.allCountry();
			//System.out.println("Response from API using Feign:");
			//System.out.println(response);
             // INSERT
			var codeReponse = postRestClient.fetchAndSavePosts();
			System.out.println(codeReponse);
		};
	}
}
