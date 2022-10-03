package com.techelevator.services;

import com.techelevator.model.Brewery;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class RestBreweryService implements BreweryService{

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<String> searchBreweries(@RequestParam String search) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://brianiswu-open-brewery-db-v1.p.rapidapi.com/breweries/search?query={search}"))
                .header("X-RapidAPI-Key", "3a718e556cmsh7ad85a3df7327f8p1e9f3cjsn0f94a22217e1")
                .header("X-RapidAPI-Host", "brianiswu-open-brewery-db-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return Arrays.asList(response.body());
    }
}
