package com.shop.a_cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shop.a_cart.R;
import com.shop.a_cart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ExclusiveGridAdapter extends BaseAdapter {

    List<Product> RecommendedProduct = new ArrayList<>();
    Context context;

    public ExclusiveGridAdapter(List<Product> recommendedProduct, Context context) {
        RecommendedProduct = recommendedProduct;
        this.context = context;
    }

    @Override
    public int getCount() {
        return RecommendedProduct.size();
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
        View view = layoutInflater.inflate(R.layout.exclusive_product_grid_row_item, null);
        ImageView img = (ImageView)view.findViewById(R.id.rec_img);
        TextView tvname = (TextView)view.findViewById(R.id.rec_name);
        TextView tvprice =(TextView)view.findViewById(R.id.rec_price);
        img.setImageResource(RecommendedProduct.get(position).getUrl());
        tvname.setText(RecommendedProduct.get(position).getName());
        tvprice.setText(RecommendedProduct.get(position).getPrice());
        return view;
    }
}
