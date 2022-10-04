package com.techelevator.controller;


import com.techelevator.dao.BeerDAO;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class ReviewController {

    @Autowired
    private BeerDAO beerDAO;

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping("/beer/reviews")
    public void addReview(@RequestBody Review review) {
        beerDAO.addReview(review);
    }

//    @GetMapping("/beer/{id}/reviews")
//    public List<Review> getReviews
}
