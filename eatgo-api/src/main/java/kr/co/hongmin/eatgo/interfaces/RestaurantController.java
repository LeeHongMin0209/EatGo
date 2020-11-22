package kr.co.hongmin.eatgo.interfaces;

import kr.co.hongmin.eatgo.domain.Restaurant;
import kr.co.hongmin.eatgo.domain.RestaurantRepository;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantRepository respository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = respository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    //파라미터 삽입
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = respository.findByid(id);

        return restaurant;
    }

}
