package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.RatingReview;
import com.example.repository.RatingReviewRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/rating-reviews")
public class RatingReviewController {

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @GetMapping
    public List<RatingReview> getAllRatingReviews() {
        return ratingReviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingReview> getRatingReviewById(@PathVariable Long id) {
        RatingReview ratingReview = ratingReviewRepository.findById(id).orElse(null);
        if (ratingReview != null) {
            return ResponseEntity.ok(ratingReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RatingReview> createRatingReview(@RequestBody RatingReview ratingReview) {
        try {
            RatingReview savedRatingReview = ratingReviewRepository.save(ratingReview);
            return ResponseEntity.ok(savedRatingReview);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingReview> updateRatingReview(@PathVariable Long id, @RequestBody RatingReview updatedRatingReview) {
        try {
            return ratingReviewRepository.findById(id)
                    .map(ratingReview -> {
                        ratingReview.setStars(updatedRatingReview.getStars());
                        ratingReview.setComment(updatedRatingReview.getComment());
                        ratingReview.setDate(updatedRatingReview.getDate());
                        ratingReview.setText(updatedRatingReview.getText());
                        ratingReview.setRatingStars(updatedRatingReview.getRatingStars());
                        RatingReview savedRatingReview = ratingReviewRepository.save(ratingReview);
                        return ResponseEntity.ok(savedRatingReview);
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRatingReview(@PathVariable Long id) {
        try {
            ratingReviewRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
