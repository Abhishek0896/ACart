package com.shop.a_cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.model.Popular;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.MyViewHolder> {
    Context context;
    List<Popular> popularprod ;

    public RecommendedAdapter(Context context, List<Popular> popularprod) {
        this.context = context;
        this.popularprod = popularprod;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exclusive_product_grid_row_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(popularprod.get(position).getUrl());
        holder.popname.setText(popularprod.get(position).getName());
        holder.popprice.setText(popularprod.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return popularprod.size();
    }

    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView popname,popprice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (itemView).findViewById(R.id.rec_img);
            popname =  (itemView).findViewById(R.id.rec_name);
            popprice =  (itemView).findViewById(R.id.rec_price);
        }
    }
}
