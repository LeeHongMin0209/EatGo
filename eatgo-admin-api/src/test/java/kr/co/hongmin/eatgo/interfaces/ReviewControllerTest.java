package kr.co.hongmin.eatgo.interfaces;

import kr.co.hongmin.eatgo.application.ReviewService;
import kr.co.hongmin.eatgo.domain.Review;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void list() throws Exception {
        List<Review> reviews = new ArrayList<>();
        reviews.add(Review.builder().description("Cool").build());

        given(reviewService.getReviews()).willReturn(reviews);

        mvc.perform(get("/reviews"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cool")));
    }
}