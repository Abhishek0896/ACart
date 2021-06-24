package com.shop.a_cart.model;

public class LoginRequest {
    String email;
    String pin;
    String device_uid;

    public LoginRequest(String email, String pin, String device_uid) {
        this.email = email;
        this.pin = pin;
        this.device_uid = device_uid;
    }
}
