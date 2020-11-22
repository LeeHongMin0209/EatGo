package kr.co.hongmin.eatgo.interfaces;

import kr.co.hongmin.eatgo.application.RestaurantService;
import kr.co.hongmin.eatgo.domain.MenuItem;
import kr.co.hongmin.eatgo.domain.MenuItemRepository;
import kr.co.hongmin.eatgo.domain.Restaurant;
import kr.co.hongmin.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
