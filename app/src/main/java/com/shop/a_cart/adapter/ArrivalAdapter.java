package com.shop.a_cart.adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.model.Product;
import com.shop.a_cart.model.ProductCallback;

import java.util.ArrayList;
import java.util.List;

public class ArrivalAdapter extends RecyclerView.Adapter<ArrivalAdapter.ViewHolder> {
    Context context;
    List<Product> productList = new ArrayList<>();
    ProductCallback callback;

    public ArrivalAdapter(Context context, List<Product> productList, ProductCallback callback) {
        this.context = context;
        this.productList = productList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ArrivalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exclusive_product_grid_row_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrivalAdapter.ViewHolder holder, int position) {
        boolean isFavourite = productList.get(position).isFav();
        holder.favimg.setColorFilter(ContextCompat.getColor(context, isFavourite ? R.color.activefav : R.color.inactivefav), android.graphics.PorterDuff.Mode.MULTIPLY);

        holder.img.setImageResource(productList.get(position).getUrl());
        holder.tvname.setText(productList.get(position).getName());
        holder.tvprice.setText(productList.get(position).getPrice());
        final StrikethroughSpan STRIKE_THROUGH_SPAN = new StrikethroughSpan();
        holder.tvoriginalprice.setText(productList.get(position).getOrginalprice(), TextView.BufferType.SPANNABLE);
        Spannable spannable = (Spannable) holder.tvoriginalprice.getText();
        spannable.setSpan(STRIKE_THROUGH_SPAN, 0, productList.get(position).getOrginalprice().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvprice,tvoriginalprice;
        ImageView img,favimg;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.primg);
            favimg = (ImageView) itemView.findViewById(R.id.prfavimg);
            tvname = (TextView) itemView.findViewById(R.id.prname);
            tvprice = (TextView) itemView.findViewById(R.id.discprice);
            tvoriginalprice = (TextView) itemView.findViewById(R.id.orgprice);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.prfav);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onProductItemClick(getAdapterPosition(),
                           img, favimg,tvname,tvprice);
                }
            });

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Product product = productList.get(getAdapterPosition());
                    product.setFav(!product.isFav());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
