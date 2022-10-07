package com.techelevator.dao;


import com.techelevator.model.Brewery;
import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDAO implements ReviewDAO{

    private final JdbcTemplate jdbcTemplate;

    private Review review;

    public JdbcReviewDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addReview(Review review) {
        String sql = "INSERT INTO reviews (user_id, beer_id, beer_name, brewery_name, description, rating) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, review.getUserId(), review.getBeerId(), review.getBeerName(), review.getBreweryName(), review.getDescription(), review.getRating());

    }

    @Override
    public List<Review> getReviewsByBeerId(int id) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE beer_id = ?";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
       while (results.next()) {
           Review review = mapRowToReview(results);
           reviews.add(review);
       }
        return reviews;
    }


    private Review mapRowToReview(SqlRowSet results) {
        Review review = new Review();
        review.setUserId(results.getInt("user_id"));
        review.setBeerId(results.getInt("beer_id"));
        review.setBeerName(results.getString("beer_name"));
        review.setBreweryName(results.getString("brewery_name"));
        review.setDescription(results.getString("description"));
        review.setRating(results.getInt("rating"));


        return review;
    }


}
