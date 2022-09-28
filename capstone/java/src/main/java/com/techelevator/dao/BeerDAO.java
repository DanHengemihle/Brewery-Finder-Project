package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;

import java.util.List;

public interface BeerDAO {
    Beer getBeerById(int id);

    int getBeerIdByName(String name);

    boolean createNewBeer(Beer beer);

    boolean addReview(Review review);

    List<Beer> getAllBeers();

    List<Beer> getBeersByBreweryId(int id);

}
