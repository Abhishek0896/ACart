package com.shop.a_cart.Fragments;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shop.a_cart.Login;
import com.shop.a_cart.R;
import com.shop.a_cart.WebService.Api;
import com.shop.a_cart.model.LoginRequest;
import com.shop.a_cart.model.LoginResponse;
import com.shop.a_cart.utils.Const;
import com.shop.a_cart.utils.ICD;
import com.shop.a_cart.utils.MyPref;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Signin extends Fragment {
    RelativeLayout imagelayout;
    ConstraintLayout form;
    ViewGroup root;
    EditText uname,pass;
    Button login;
    TextView signup,forgotpassword;
    Fragment temp ;
    Context mcontext;
    ICD icd;
    MyPref pref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = (ViewGroup) inflater.inflate(R.layout.fragment_signin, container, false);
        showScreen();
        mcontext = getActivity();
        uname = (EditText)root.findViewById(R.id.edemail);
        pass = (EditText)root.findViewById(R.id.sppass);
        login = (Button)root.findViewById(R.id.btsignin);
        signup = (TextView)root.findViewById(R.id.tvregister);
        forgotpassword =(TextView)root.findViewById(R.id.tvforgotpass);
        icd = new ICD(mcontext);
        pref = new MyPref(mcontext);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = new SignUp();
                nextpage(temp);
            }});

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = new ForgotPassword();
                nextpage(temp);
            }});
        return root;
    }

    private void userLogin() {
        if(!icd.isInternetConnected()) {
            icd.showInternetSettingAlert();
        }else{
            LoginRequest request = new LoginRequest("rathourabhishek00@gmail.com", "123456", Settings.Secure.getString(getActivity().getContentResolver(),
                    Settings.Secure.ANDROID_ID));
            Api api = Api.retrofit.create(Api.class);
            Call<LoginResponse> call = api.LoginUser(request);
//        Call<LoginResponse> call = api.LoginUser(request, "Bearer"+"eyJhbGciOiJIUzI1NiJ9.eyJtb2JpbGVfdXNlcl9pZCI6MSwiZGV2aWNlX3VpZCI6IjFkZXd2YXJiZ2ZyZSJ9.aeglSa8dunMpZL0PznKzr7HiaTzliojvFMR53wBf5EY");
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        LoginResponse loginResponse = response.body();
                        moveToDashboard(loginResponse);
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getActivity(), "Cant't logged in Error:"+t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void moveToDashboard(LoginResponse response) {
        if(response.getResponse().getData().getAuthToken() != null) {
            pref.putString(Const.USER_AUTH_TOKEN, response.getResponse().getData().getAuthToken());
            Toast.makeText(getActivity(), "Succesfully logged in...!!!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getActivity(), "Error: "+response.getResponse().getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void nextpage(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.contain, fragment).commit();
    }

    private void showScreen() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        imagelayout = (RelativeLayout)root.findViewById(R.id.imagelayout);
        form = (ConstraintLayout) root.findViewById(R.id.form);
        imagelayout.requestLayout();
        imagelayout.getLayoutParams().height = height/3;
        imagelayout.getLayoutParams().height = width /3;
    }
}