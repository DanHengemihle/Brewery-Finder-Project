package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDAO {

    List<Brewery> listAllBreweries();

    Brewery getBreweryById(int breweryId);

    Brewery getBreweryByName(String name);

    boolean createBrewery(Brewery brewery);

    void updateBrewery(Brewery brewery, int breweryId);

    void deleteBrewery(int breweryId);
}
