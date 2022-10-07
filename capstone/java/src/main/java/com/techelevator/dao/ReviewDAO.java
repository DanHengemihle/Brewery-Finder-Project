package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDAO {

   void addReview(Review review);

   List<Review> getReviewsByBeerId(int id);
}
