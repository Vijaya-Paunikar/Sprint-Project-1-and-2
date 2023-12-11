import { TestBed } from '@angular/core/testing';

import { RatingReviewService } from './rating-review.service';

describe('RatingReviewService', () => {
  let service: RatingReviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RatingReviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
