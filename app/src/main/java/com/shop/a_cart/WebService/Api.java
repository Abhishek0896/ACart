package com.shop.a_cart.WebService;

import com.shop.a_cart.model.LoginRequest;
import com.shop.a_cart.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import static com.shop.a_cart.utils.Const.GET_BASE_URL;


public interface Api {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GET_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @POST("/api/mobile_user/authenticate")
    Call<LoginResponse> LoginUser(@Body LoginRequest request);
//    Call<LoginResponse> LoginUser(@Body LoginRequest request, @Header("Authorization")String auth);


}
