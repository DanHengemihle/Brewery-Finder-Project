package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.model.Review;

import java.util.List;

public class JDBCBeerDAO implements BeerDAO {
    @Override
    public Beer getBeerById(int id) {
        return null;
    }

    @Override
    public int getBeerIdByName(String name) {
        return 0;
    }

    @Override
    public boolean createNewBeer(Beer beer) {
        return false;
    }

    @Override
    public boolean addReview(Review review) {
        return false;
    }

    @Override
    public List<Beer> getAllBeers() {
        return null;
    }

    @Override
    public List<Beer> getBeersByBreweryId(int id) {
        return null;
    }

    @Override
    public List<Beer> getAllBeersByBeerId(int id) {
        return null;
    }
}
