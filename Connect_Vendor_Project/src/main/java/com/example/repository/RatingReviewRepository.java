package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.RatingReview;

public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> 
{
	
}

