package com.shop.a_cart.model;

public class HomeCategory {
    String name;
    Integer url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }

    public HomeCategory(String name, Integer url) {
        this.name = name;
        this.url = url;
    }
}
