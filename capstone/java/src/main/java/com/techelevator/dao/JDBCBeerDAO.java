package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCBeerDAO implements BeerDAO {

    private final JdbcTemplate jdbcTemplate;

    public JDBCBeerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Beer getBeerById(int id) {
        String sql = "SELECT * FROM beer WHERE beer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBeer(results);
        }
        return null;
    }



    @Override
    public int getBeerIdByName(String name) {
        String sql = "SELECT beer_id FROM beer WHERE name = ?";
        int beerId = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return beerId;
    }

    @Override
    public boolean addNewBeer(Beer beer) {
        String sql = "INSERT INTO beer (brewery_id, beer_name, beer_description, image, beer_type, abv) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, beer.getBreweryId(), beer.getBeerName(), beer.getBeerDescription(), beer.getImage(),
                beer.getBeerType(), beer.getAbv());

        return true;
    }

    @Override
    public boolean addReview(Review review) {
        String sql = "INSERT INTO review (user_id, beer_id, beer_name, brewery_name, description, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING review_id";
        Integer reviewId = jdbcTemplate.queryForObject(sql, Integer.class, review.getUserId(),
                review.getBeerId(), review.getBeerName(), review.getBreweryName(), review.getDescription(), review.getRating());
        if (reviewId == null) return false;
        review.setReviewId(reviewId);
        return true;
    }

    @Override
    public List<Beer> getAllBeers() {
        List<Beer> allBeers = new ArrayList<Beer>();
        String sql = "SELECT * FROM beer";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            allBeers.add(beer);
        }
        return allBeers;
    }

    @Override
    public List<Beer> getBeersByBreweryId(int id) {
        List<Beer> allBeers = new ArrayList<>();
        String sql = "SELECT * FROM beer WHERE brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            Beer beer = mapRowToBeer(results);
            allBeers.add(beer);
        }
        return allBeers;
    }

    @Override
    public List<Review> getReviewsByBeerId(int id) {
        return null;
    }

    @Override
    public void deleteBeer(int id) {
        String beerSql = "DELETE FROM reviews WHERE beer_id = ?";
        jdbcTemplate.update(beerSql, id);
        String deleteBeer = "DELETE FROM beer WHERE beer_id = ?";
        jdbcTemplate.update(deleteBeer, id);
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
