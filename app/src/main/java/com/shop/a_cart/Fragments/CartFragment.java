package com.shop.a_cart.Fragments;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.shop.a_cart.R;
import com.shop.a_cart.adapter.CartAdapter;
import com.shop.a_cart.model.Product;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class CartFragment extends Fragment {
    RecyclerView cartRecyler;
    CartAdapter cartAdapter;
    ViewGroup root;
    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    List<Product> recommendProd = new ArrayList<>();
    Product product;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.cart_frag, container, false);
        bottomAppBar = getActivity().findViewById(R.id.bottomAppBar2);
        floatingActionButton = getActivity().findViewById(R.id.floatingActionButton2);
        cartRecyler = (RecyclerView) root.findViewById(R.id.cartRecyler);
        setCartAdapter();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(cartRecyler);
        floatingActionButton.hide();
        bottomAppBar.performHide();
        return root;
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            product = recommendProd.get(position);
            recommendProd.remove(position);
            cartAdapter.notifyItemRemoved(position);
            Snackbar.make(cartRecyler,product.getName(),
                    BaseTransientBottomBar.LENGTH_LONG)
                    .setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            recommendProd.add(position,product);
                            cartAdapter.notifyItemInserted(position);
                        }
                    }).show();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(getContext(), R.color.recyler_delete))
                    .addActionIcon(R.drawable.delete)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    private void setCartAdapter() {

        cartRecyler = root.findViewById(R.id.cartRecyler);
        recommendProd.add(new Product("Diamong Ring", "$190.75", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe", "$19.15", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap", "$11.05", R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans", "$21.50", R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans", "$34.75", R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers", "$28.13", R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring", "$190.75", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe", "$19.15", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap", "$11.05", R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans", "$21.50", R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans", "$34.75", R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers", "$28.13", R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring", "$190.75", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe", "$19.15", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap", "$11.05", R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans", "$21.50", R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans", "$34.75", R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers", "$28.13", R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring", "$190.75", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe", "$19.15", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap", "$11.05", R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans", "$21.50", R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans", "$34.75", R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers", "$28.13", R.drawable.womanshoe_5));
        cartAdapter = new CartAdapter(recommendProd, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        cartRecyler.setLayoutManager(linearLayoutManager);
        cartRecyler.setAdapter(cartAdapter);
    }

}