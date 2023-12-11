import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RatingReview } from './RatingReview.model';

@Injectable({
  providedIn: 'root',
})
export class RatingReviewService {
  private apiUrl = 'http://localhost:8000/rating-reviews';

  constructor(private http: HttpClient) {}

  getAllRatingReviews(): Observable<RatingReview[]> {
    return this.http.get<RatingReview[]>(this.apiUrl);
  }

  getRatingReviewById(id: number): Observable<RatingReview> {
    return this.http.get<RatingReview>(`${this.apiUrl}/${id}`);
  }

  createRatingReview(ratingReview: RatingReview): Observable<RatingReview> {
    return this.http.post<RatingReview>(this.apiUrl, ratingReview);
  }

  updateRatingReview(id: number, ratingReview: RatingReview): Observable<RatingReview> {
    return this.http.put<RatingReview>(`${this.apiUrl}/${id}`, ratingReview);
  }

  deleteRatingReview(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
