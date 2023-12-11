package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class RatingReview 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stars;
    private String comment;
    private LocalDate date;

    // Additional attributes from Review
    private String text;

    // Additional attributes from Rating
    private int ratingStars;

    public RatingReview() {
        // Default constructor
    }

    // Constructor for combining Rating and Review
    public RatingReview(Long id, int stars, String comment, LocalDate date, String text, int ratingStars) {
        this.id = id;
        this.stars = stars;
        this.comment = comment;
        this.date = date;
        this.text = text;
        this.ratingStars = ratingStars;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(int ratingStars) {
        this.ratingStars = ratingStars;
    }
    
}
