package com.techelevator.controller;


import com.techelevator.dao.BeerDAO;
import com.techelevator.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RequestMapping("/")
@RestController
@CrossOrigin
public class BeerController {
    @Autowired
    private BeerDAO beerDAO;

    @PostMapping("/beers")
    public void create(@RequestBody @Valid Beer beer) {
        beerDAO.addNewBeer(beer);
    }

    @GetMapping("/beers")
    public List<Beer> getAllBeers() {
        return beerDAO.getAllBeers();
    }

    @GetMapping("/beers/{id}")
    public Beer getBeerById(@PathVariable int id) {
        return beerDAO.getBeerById(id);
    }

    @GetMapping("/beers/{name}")
    public int getBeerIdByName(@PathVariable String name) {
        return beerDAO.getBeerIdByName(name);
    }

    @GetMapping("/breweries/{breweryId}")
    public List<Beer> getBreweriesById(@PathVariable int id) {
        return beerDAO.getBeersByBreweryId(id);
    }


    @DeleteMapping ("/delete-beer/{id}")
    public void deleteBeer(@PathVariable int id) {
        beerDAO.deleteBeer(id);
    }

}
