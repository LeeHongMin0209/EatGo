package kr.co.hongmin.eatgo.application;

import kr.co.hongmin.eatgo.domain.Review;
import kr.co.hongmin.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReviewServiceTests {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void addReview(){

        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("good")
                .build();

        reviewService.addReview(1004L,review);

        verify(reviewRepository).save(any());
    }
}