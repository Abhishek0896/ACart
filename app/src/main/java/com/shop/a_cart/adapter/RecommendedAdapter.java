package com.shop.a_cart.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.ProductsActivity;
import com.shop.a_cart.R;
import com.shop.a_cart.model.Product;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.MyViewHolder> {
    Context context;
    List<Product> popularprod ;

    public RecommendedAdapter(Context context, List<Product> popularprod) {
        this.context = context;
        this.popularprod = popularprod;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exclusive_product_grid_row_item, parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.popelement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(v.getContext(),"Position "+viewHolder.getAdapterPosition(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ProductsActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        return viewHolder;
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
        CardView popelement;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (itemView).findViewById(R.id.rec_img);
            popname =  (itemView).findViewById(R.id.rec_name);
            popprice =  (itemView).findViewById(R.id.rec_price);
            popelement = (CardView) itemView.findViewById(R.id.popelement);
        }
    }

}
