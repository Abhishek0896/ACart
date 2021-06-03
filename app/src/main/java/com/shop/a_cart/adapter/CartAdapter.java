package com.shop.a_cart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.model.Product;

import java.util.List;
//FFFFCDD2
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    List<Product> products;
    Context context;
    int i =0;
    public CartAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item_product_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.cartimg.setImageResource(products.get(position).getUrl());
        holder.cartprice.setText(products.get(position).getPrice());
        holder.cartname.setText(products.get(position).getName());
        holder.additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                holder.cartqty.setText(""+i);
            }
        });
        holder.subitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i > 0)
                {
                    i--;
                    holder.cartqty.setText("" +i);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView cartimg,additem;
        TextView cartname,cartprice,cartqty;
        View subitem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cartimg = (ImageView)itemView.findViewById(R.id.cartimg);
            additem = (ImageView)itemView.findViewById(R.id.additem);
            subitem = (View)itemView.findViewById(R.id.subitem);
            cartname = (TextView)itemView.findViewById(R.id.cartname);
            cartprice = (TextView)itemView.findViewById(R.id.cartprice);
            cartqty = (TextView)itemView.findViewById(R.id.cartqty);
        }
    }
}
