package kr.co.hongmin.eatgo.domain;

public class Restaurant {

    private final String name;
    private final Long id;
    private final String address;

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
}
