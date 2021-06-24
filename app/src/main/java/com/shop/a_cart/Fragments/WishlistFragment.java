package com.shop.a_cart.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.adapter.WishlistAdapter;
import com.shop.a_cart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class WishlistFragment extends Fragment {

    GridView gridView;
    WishlistAdapter adapter;
    List<Product> products;
    ViewGroup root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.wishlist_frag,container,false);
        setWishListgridView();
        return root;
    }

    private void setWishListgridView() {
        products = new ArrayList<>();
        gridView = root.findViewById(R.id.wishlistgrid);
        products.add(new Product("HeadPhone","$21.15",R.drawable.headphone_5));
        products.add(new Product("HeadPhone","$21.15",R.drawable.headphone_5));
        products.add(new Product("HeadPhone","$21.15",R.drawable.headphone_5));
        products.add(new Product("HeadPhone","$21.15",R.drawable.headphone_5));
        products.add(new Product("HeadPhone","$21.15",R.drawable.headphone_5));
        products.add(new Product("HeadPhone","$21.15",R.drawable.headphone_5));
        adapter = new WishlistAdapter(products,root.getContext());
        gridView.setAdapter(adapter);

    }
}
