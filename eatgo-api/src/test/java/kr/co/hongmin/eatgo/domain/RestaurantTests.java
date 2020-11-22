package kr.co.hongmin.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(),is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }
}