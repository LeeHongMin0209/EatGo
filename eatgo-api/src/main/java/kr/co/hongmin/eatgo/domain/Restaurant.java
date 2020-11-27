package kr.co.hongmin.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private Long id;
    private String address;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant(String name) {

    }

    public Restaurant(Long id, String name, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public Long getId(){
        return id;
    }


    public String getName() {
        return name;
    }

    public String getAddress(){
        return address;

    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }
}
