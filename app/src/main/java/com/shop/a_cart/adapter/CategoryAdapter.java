package com.shop.a_cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.shop.a_cart.R;
import com.shop.a_cart.model.Product;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends BaseAdapter {
  List<Product> products = new ArrayList<>();
  Context context;

    public CategoryAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
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
        View view = layoutInflater.inflate(R.layout.categories_row_item,null);
        ImageView image = (ImageView)view.findViewById(R.id.maincatimg);
        TextView name = (TextView)view.findViewById(R.id.maincatname);
        CardView cardView = (CardView)view.findViewById(R.id.maincatitem);
        image.setImageResource(products.get(position).getUrl());
        name.setText(products.get(position).getName());

        if (position % 7 == 0) {
            cardView.setBackgroundColor(ContextCompat.getColor(context,R.color.cat1));
        } else if (position % 7 == 1) {
            cardView.setBackgroundColor(ContextCompat.getColor(context,R.color.cat2));
        } else if (position % 7 == 2) {
            cardView.setBackgroundColor(ContextCompat.getColor(context,R.color.cat3));
        } else if (position % 7 == 3) {
            cardView.setBackgroundColor(ContextCompat.getColor(context,R.color.cat4));
        } else if (position % 7 == 4) {
            cardView.setBackgroundColor(ContextCompat.getColor(context,R.color.cat5));
        } else if (position % 7 == 5) {
            cardView.setBackgroundColor(ContextCompat.getColor(context,R.color.cat6));
        } else if (position % 7 == 6) {
            cardView.setBackgroundColor(ContextCompat.getColor(context,R.color.cat7));
        }
        return view;
    }
}
