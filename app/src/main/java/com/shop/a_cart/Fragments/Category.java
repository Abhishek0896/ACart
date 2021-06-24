package com.shop.a_cart.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.shop.a_cart.R;
import com.shop.a_cart.adapter.CategoryAdapter;
import com.shop.a_cart.model.Product;

import java.util.ArrayList;
import java.util.List;


public class Category extends Fragment {
    GridView gridView;
    CategoryAdapter adapter;
    List<Product>products;
    ViewGroup root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        root = (ViewGroup) inflater.inflate(R.layout.fragment_category,container,false);
        setCategorygridView();
        return root;
    }

    private void setCategorygridView() {
        products = new ArrayList<>();
        gridView = root.findViewById(R.id.catgrid);
        products.add(new Product("Electronics",R.drawable.headphone_5));
        products.add(new Product("Fashion",R.drawable.headphone_5));
        products.add(new Product("Mobiles",R.drawable.headphone_5));
        products.add(new Product("Home",R.drawable.headphone_5));
        products.add(new Product("Grocery",R.drawable.headphone_5));
        products.add(new Product("Appliances",R.drawable.headphone_5));
        products.add(new Product("Beauty Products",R.drawable.headphone_5));
        adapter = new CategoryAdapter(products,root.getContext());
        gridView.setAdapter(adapter);


    }
}