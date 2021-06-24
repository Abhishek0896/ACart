package com.shop.a_cart.model;

import java.io.Serializable;

public class Product implements Serializable {
    String name;
    String price;
    String orginalprice;
    boolean fav ;
    Integer url;

    public Product(String name, Integer url) {
        this.name = name;
        this.url = url;
    }

    public Product(String name, String price, Integer url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public Product(String name, String price, String orginalprice, Integer url) {
        this.name = name;
        this.price = price;
        this.orginalprice = orginalprice;
        this.url = url;
        fav =false;
    }

    public String getOrginalprice() {
        return orginalprice;
    }

    public void setOrginalprice(String orginalprice) {
        this.orginalprice = orginalprice;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }
}
