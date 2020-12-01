package kr.co.hongmin.eatgo.interfaces;

import kr.co.hongmin.eatgo.application.RestaurantService;
import kr.co.hongmin.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    //파라미터 삽입
    public Restaurant detail(@PathVariable("id") Long id){

        Restaurant restaurant = restaurantService.getRestaurant(id);
        //기본 정보 + 메뉴 정보
        return restaurant;

    }
}
