package com.shop.a_cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends BaseAdapter {
    List<Product> productList = new ArrayList<>();
    Context context;

    public WishlistAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return productList.size();
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
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.wishlist_item,null);
//        ImageView imageView =(ImageView)view.findViewById(R.id.wishimg);
//        ImageView rmv =(ImageView)view.findViewById(R.id.wishrmv);
//        TextView name = (TextView)view.findViewById(R.id.wishname);
//        TextView price = (TextView)view.findViewById(R.id.wishprice);
//        TextView buy = (TextView) view.findViewById(R.id.wishbuy);
//        imageView.setImageResource(productList.get(position).getUrl());
//        name.setText(productList.get(position).getName());
//        price.setText(productList.get(position).getPrice());
        return view;
    }
}
