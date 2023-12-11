import { Component, OnInit } from '@angular/core';
import { RatingReview } from '../RatingReview.model';
import { RatingReviewService } from '../rating-review.service';

@Component({
  selector: 'app-rating-review',
  templateUrl: './rating-review.component.html',
  styleUrls: ['./rating-review.component.css']
})
export class RatingReviewComponent implements OnInit {
  ratingReviews: RatingReview[] = [];
  selectedRatingReview: RatingReview = new RatingReview();
  isNewRatingReview: boolean = false;

  constructor(private ratingReviewService: RatingReviewService) {}

  ngOnInit(): void {
    this.loadRatingReviews();
  }

  loadRatingReviews(): void {
    this.ratingReviewService.getAllRatingReviews().subscribe((ratingReviews) => {
      this.ratingReviews = ratingReviews;
    });
  }

  editRatingReview(ratingReview: RatingReview): void {
    this.selectedRatingReview = { ...ratingReview };
    this.isNewRatingReview = true;
    this.openModal();
  }

  createRatingReview(): void {
    this.isNewRatingReview = true;
    this.selectedRatingReview = new RatingReview();
    this.openModal();
  }

  saveRatingReview(): void {
    if (this.isNewRatingReview) {
      this.ratingReviewService.createRatingReview(this.selectedRatingReview).subscribe(() => {
        this.loadRatingReviews();
        this.cancelEdit();
      });
    } else {
      this.ratingReviewService.updateRatingReview(this.selectedRatingReview.id, this.selectedRatingReview).subscribe(() => {
        this.loadRatingReviews();
        this.cancelEdit();
      });
    }
  }

  deleteRatingReview(id: number): void {
    this.ratingReviewService.deleteRatingReview(id).subscribe(() => {
      this.loadRatingReviews();
      this.cancelEdit();
    });
  }

  cancelEdit(): void {
    this.selectedRatingReview = new RatingReview();
    this.isNewRatingReview = false;
    this.closeModal();
  }

  // Additional methods for modal handling
  openModal(): void {
    const modal = document.getElementById('ratingReviewModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal(): void {
    const modal = document.getElementById('ratingReviewModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }
}
