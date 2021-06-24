package com.shop.a_cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.model.HomeCategory;
import com.shop.a_cart.model.Product;

import java.util.List;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.PopularViewHolder> {
Context context;
List<HomeCategory>categories;

    public HomeCategoryAdapter(Context context, List<HomeCategory> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_chip_item, parent,false);
        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        holder.imageView.setImageResource(categories.get(position).getUrl());
        holder.catname.setText(categories.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class PopularViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView catname;
        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (itemView).findViewById(R.id.homecatimg);
            catname = (itemView).findViewById(R.id.homecatname);



//            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) {
//                    if (hasFocus) {
//                        // run scale animation and make it bigger
//                        Animation anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_in_tv);
//                        itemView.startAnimation(anim);
//                        anim.setFillAfter(true);
//                    } else {
//                        // run scale animation and make it smaller
//                        Animation anim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_out_tv);
//                        itemView.startAnimation(anim);
//                        anim.setFillAfter(true);
//                    }
//                }
//            });

        }
    }
}
