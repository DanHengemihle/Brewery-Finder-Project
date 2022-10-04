package com.techelevator.controller;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    private UserDao userDao;

    @PreAuthorize("permitAll")
    @RequestMapping(value = "/breweries", method = RequestMethod.GET)
    public List<Brewery> breweries(){
        return breweryDAO.listAllBreweries();
//    public ResponseEntity<String> GetBreweriesList(){
//        String url = "https://brianiswu-open-brewery-db-v1.p.rapidapi.com/breweries";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-RapidAPI-Key", "3a718e556cmsh7ad85a3df7327f8p1e9f3cjsn0f94a22217e1");
//        headers.add("X-RapidAPI-Host", "brianiswu-open-brewery-db-v1.p.rapidapi.com");
//        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        return response;


    }

    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.GET)
    public Brewery breweryById(@PathVariable int id){
        return breweryDAO.getBreweryById(id);
//    public ResponseEntity<String> getById(@PathVariable int id){
//        String url = "https://brianiswu-open-brewery-db-v1.p.rapidapi.com/breweries/" + id;
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-RapidAPI-Key", "3a718e556cmsh7ad85a3df7327f8p1e9f3cjsn0f94a22217e1");
//        headers.add("X-RapidAPI-Host", "brianiswu-open-brewery-db-v1.p.rapidapi.com");
//        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        return response;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/breweries/search", method = RequestMethod.GET)
    public ResponseEntity<String> searchBreweries(@RequestParam String query) {
        String url = "https://brianiswu-open-brewery-db-v1.p.rapidapi.com/breweries/search?query=" + query;
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", "3a718e556cmsh7ad85a3df7327f8p1e9f3cjsn0f94a22217e1");
        headers.add("X-RapidAPI-Host", "brianiswu-open-brewery-db-v1.p.rapidapi.com");
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }

    @RequestMapping(path = "/breweries/{name}", method = RequestMethod.GET)
    public Brewery getByName(@PathVariable String name){return breweryDAO.getBreweryByName(name);}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/breweries", method = RequestMethod.POST)
    public void addBrewery(Principal principal, @Valid @RequestBody Brewery brewery){
        int brewerId = userDao.findIdByUsername(principal.getName());
        breweryDAO.createBrewery(brewerId,brewery);
    }

    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.PUT)
    public void updateBrewery(@Valid @RequestBody Brewery brewery, @PathVariable int id, Principal principal){
        int brewerId = userDao.findIdByUsername(principal.getName());
        breweryDAO.updateBrewery(brewery, id, brewerId);
    }

    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.DELETE)
    public void deleteBrewery(@PathVariable int id, Principal principal){
        int brewerId = userDao.findIdByUsername(principal.getName());
        breweryDAO.deleteBrewery(id, brewerId);}
}
