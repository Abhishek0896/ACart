package com.shop.a_cart.Fragments;

import android.graphics.Point;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shop.a_cart.R;


public class ForgotPassword extends Fragment {
ViewGroup root;
RelativeLayout imagelayout;
ConstraintLayout form;
EditText email;
Button forgot;
TextView login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = (ViewGroup) inflater.inflate(R.layout.fragment_forgot_password, container, false);
        email = (EditText)root.findViewById(R.id.fpemail);
        forgot = (Button)root.findViewById(R.id.btnforgotpass);
        login = (TextView)root.findViewById(R.id.fplogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.contain, new Signin()).commit();
            }
        });
        return root;
    }
    private void showScreen() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        imagelayout = (RelativeLayout)root.findViewById(R.id.imagelayout);
        form = (ConstraintLayout) root.findViewById(R.id.form_fp);
        imagelayout.requestLayout();
        imagelayout.getLayoutParams().height = height/3;
        imagelayout.getLayoutParams().height = width /3;
    }
}