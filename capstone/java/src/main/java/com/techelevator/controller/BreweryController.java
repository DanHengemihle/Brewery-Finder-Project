package com.techelevator.controller;

import com.techelevator.dao.BreweryDAO;
import com.techelevator.model.Brewery;
import com.techelevator.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BreweryController {
    @Autowired
    private BreweryDAO breweryDAO;
    @Autowired
    BreweryService breweryService;

//    @PreAuthorize("permitAll")
//    @RequestMapping(value = "/breweries", method = RequestMethod.GET)
//    public List<Brewery> breweries(){ return breweryDAO.listAllBreweries();}

    @PreAuthorize("permitAll")
    @RequestMapping(value = "/breweries", method = RequestMethod.GET)
    public List<String> getAllBreweries() throws IOException, InterruptedException {
    return breweryService.getAllBreweries();
    }

    @RequestMapping(path = "/breweries/{id}", method = RequestMethod.GET)
    public Brewery getById(@PathVariable int id){return breweryDAO.getBreweryById(id);}

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
