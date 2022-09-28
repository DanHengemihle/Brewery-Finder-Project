package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JDBCBeerDAO implements BeerDAO {

    private final JdbcTemplate jdbcTemplate;

    public JDBCBeerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Beer getBeerById(int id) {
        String sql = "SELECT * FROM beer WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBeer(results);
        }
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

    private Review mapRowToReview(SqlRowSet results) {
        Review review = new Review();
        review.setReviewId(results.getInt("review_id"));
        review.setUserId(results.getInt("user_id"));
        review.setBeerId(results.getInt("beer_id"));
        review.setBeerName(results.getString("beer_name"));
        review.setBreweryName(results.getString("brewery_name"));
        review.setDescription(results.getString("description"));
        review.setRating(results.getInt("rating"));
        return review;
    }

    private Beer mapRowToBeer(SqlRowSet results) {
        Beer beer = new Beer();
        beer.setBeerId(results.getInt("beer_id"));
        beer.setBreweryId(results.getInt("brewery_id"));
        beer.setBeerName(results.getString("beer_name"));
        beer.setBeerDescription(results.getString("beer_description"));
        beer.setImage(results.getString("image"));
        beer.setAbv(results.getDouble("abv"));
        beer.setBeerType(results.getString("beer_type"));


        return beer;
    }
}
