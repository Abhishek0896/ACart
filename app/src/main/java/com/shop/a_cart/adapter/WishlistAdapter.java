package com.shop.a_cart.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends BaseAdapter {
    List<Product> productList = new ArrayList<>();

    public WishlistAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
