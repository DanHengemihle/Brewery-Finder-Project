package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDAO {

    List<Brewery> listAllBreweries();

    Brewery getBreweryById(int breweryId);

    Brewery getBreweryByName(String name);

    void createBrewery(int brewerId, Brewery brewery);

    void updateBrewery(Brewery brewery);

    void deleteBrewery(int breweryId, int brewerId);
}
