package com.techelevator.controller;


import com.techelevator.dao.ReviewDAO;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewDAO reviewDAO;

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping("/beer/reviews")
    public void addReview(@RequestBody Review review) {
        reviewDAO.addReview(review);
    }

    @GetMapping("/beer/{id}/reviews")
    public List<Review> getReviewsByBeerId(@PathVariable int id) {
        return reviewDAO.getReviewsByBeerId(id);
    }
}
