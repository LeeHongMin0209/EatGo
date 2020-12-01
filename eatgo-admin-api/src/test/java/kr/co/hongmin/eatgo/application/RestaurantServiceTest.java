package kr.co.hongmin.eatgo.application;

import kr.co.hongmin.eatgo.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    //테스트 실행전에 실행시킴
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);

        mockRestaurantRepository();
        restaurantService = new RestaurantService(restaurantRepository );
    }

    private void mockMenuItemRepository() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(MenuItem.builder()
        .name("Kimchi")
        .build());
    }

    private void mockRestaurantRepository() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        restaurants.add(restaurant);
        given(restaurantRepository.findAll()).willReturn(restaurants);

        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));

    }

    private void mockReviewRepository() {
        List<Review> reviews = new ArrayList<>();
        reviews.add(Review.builder()
            .name("BeRyong")
            .score(1)
            .description("Bad")
            .build());
    }

    @Test
    public void getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();


        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId(), is(1004L));
    }

    @Test
    public void getRestaurantWithExisted(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);
        assertThat(restaurant.getId(), is(1004L));
    }

    @Test
    public void getRestaurantWithNotExisted(){
        RestaurantNotFoundException exception = assertThrows(RestaurantNotFoundException.class, () ->
                restaurantService.getRestaurant(404L));
                String message = exception.getMessage();
                assertEquals("Could Not Find Restaurant " + 404, message);
    }

    @Test
    public void addRestaurant(){
        given(restaurantRepository.save(any())).will(invocation -> {
            Restaurant restaurant = invocation.getArgument(0);
            restaurant.setId(1234L);
            return restaurant;
        });

        Restaurant restaurant = Restaurant.builder()
                .name("BeRyong")
                .address("Busan")
                .build();

        Restaurant created = restaurantService.addRestaurants(restaurant);

        assertThat(created.getId(),is(1234L));
    }

    @Test
    public void updateRestaurant(){
        Restaurant restaurant = Restaurant.builder()
                .id(1004L)
                .name("Bob zip")
                .address("Seoul")
                .build();
        given(restaurantRepository.findById(1004L)).willReturn(Optional.of(restaurant));

        restaurantService.updateRestaurant(1004L, "Sool zip", "Busan");

        assertThat(restaurant.getName(), is("Sool zip"));
        assertThat(restaurant.getAddress(), is("Busan"));
    }
}