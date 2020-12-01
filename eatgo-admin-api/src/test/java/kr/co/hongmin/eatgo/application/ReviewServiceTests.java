package kr.co.hongmin.eatgo.application;

import kr.co.hongmin.eatgo.domain.Review;
import kr.co.hongmin.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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
    public void getReviews(){
        List<Review> mockreviews = new ArrayList<>();
        mockreviews.add(Review.builder().description("Cool").build());
        given(reviewRepository.findAll()).willReturn(mockreviews);

        List<Review> reviews = reviewService.getReviews();

        Review review = reviews.get(0);

        assertThat(review.getDescription(), is("Cool"));
    }
}