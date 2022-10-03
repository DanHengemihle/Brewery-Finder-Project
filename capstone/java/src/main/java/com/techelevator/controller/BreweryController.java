package com.techelevator.controller;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Brewery;
import com.techelevator.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class BreweryController {
    @Autowired
    private BreweryDAO breweryDAO;
    @Autowired
    BreweryService breweryService;

    @PreAuthorize("permitAll")
    @RequestMapping(value = "/breweries", method = RequestMethod.GET)
    public ResponseEntity<String> GetBreweriesList(){
        String url = "https://brianiswu-open-brewery-db-v1.p.rapidapi.com/breweries";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", "3a718e556cmsh7ad85a3df7327f8p1e9f3cjsn0f94a22217e1");
        headers.add("X-RapidAPI-Host", "brianiswu-open-brewery-db-v1.p.rapidapi.com");
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }

    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getById(@PathVariable int id){
        String url = "https://brianiswu-open-brewery-db-v1.p.rapidapi.com/breweries/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", "3a718e556cmsh7ad85a3df7327f8p1e9f3cjsn0f94a22217e1");
        headers.add("X-RapidAPI-Host", "brianiswu-open-brewery-db-v1.p.rapidapi.com");
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }

    @RequestMapping(path = "/breweries/{search}", method = RequestMethod.GET)
    public List<String> searchBreweries(@RequestParam String search) throws IOException, InterruptedException {
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create("https://brianiswu-open-brewery-db-v1.p.rapidapi.com/breweries/search?query=" + search))
                .header("X-RapidAPI-Key", "3a718e556cmsh7ad85a3df7327f8p1e9f3cjsn0f94a22217e1")
                .header("X-RapidAPI-Host", "brianiswu-open-brewery-db-v1.p.rapidapi.com")
                .method("GET", java.net.http.HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return Arrays.asList(response.body());
    }

    @RequestMapping(path = "/breweries/{name}", method = RequestMethod.GET)
    public Brewery getByName(@PathVariable String name){return breweryDAO.getBreweryByName(name);}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/breweries", method = RequestMethod.POST)
    public boolean addBrewery(@Valid @RequestBody Brewery brewery){
        return breweryDAO.createBrewery(brewery);
    }

    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.PUT)
    public void updateBrewery(@Valid @RequestBody Brewery brewery, @PathVariable int id){
        breweryDAO.updateBrewery(brewery, id);
    }
}
