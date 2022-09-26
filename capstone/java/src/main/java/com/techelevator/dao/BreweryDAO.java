package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDAO {

    List<Brewery> listAllBreweries();

    Brewery getBreweryById(int breweryId);

    Brewery getBreweryByName(String name);

    boolean createBrewery(String name, String street, String city, String state, String postalCode,
                          String country, String website, String hoursOfOperation);
}
