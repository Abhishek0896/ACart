package com.shop.a_cart.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shop.a_cart.ProductsActivity;
import com.shop.a_cart.R;
import com.shop.a_cart.adapter.ArrivalAdapter;
import com.shop.a_cart.adapter.HomeCategoryAdapter;
import com.shop.a_cart.model.HomeCategory;
import com.shop.a_cart.model.Product;
import com.shop.a_cart.model.ProductCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Home extends Fragment implements ProductCallback {

    int myLastVisiblePos = 0;
    RecyclerView catlist,newrecyler;
    HomeCategoryAdapter homeCategoryAdapter;
    ArrivalAdapter adapter;
    ViewGroup root;
    TextView uname;
    FloatingActionButton floatingActionButton;
    List<Product> recommendProd = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.home_frag, container, false);
        floatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.floatingActionButton2);
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        uname = root.findViewById(R.id.uname);
        uname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductsActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment frag = new CartFragment();
                ft.replace(R.id.container, frag);
                ft.commit();
            }
        });
        //Call  popular products
        setPopularRecyler();
        setRecommendedGrid();
        showandHideBottomAppBar();

        return root;
    }


    private void setPopularRecyler()
    {
        List<HomeCategory> categories  = new ArrayList<>();
        categories.add(new HomeCategory("T-Shirt", R.drawable.buy_1));
        categories.add(new HomeCategory("Electronics", R.drawable.headphone_5));
        categories.add(new HomeCategory("Jewellery", R.drawable.ring_2));
        categories.add(new HomeCategory("Jeans", R.drawable.jeans_2));
        categories.add(new HomeCategory("Shoes", R.drawable.shoeman_3));
        categories.add(new HomeCategory("T-Shirt", R.drawable.buy_1));
        categories.add(new HomeCategory("T-Shirt", R.drawable.buy_1));
        categories.add(new HomeCategory("T-Shirt", R.drawable.buy_1));
        Collections.reverse(categories);
        catlist = (RecyclerView)root.findViewById(R.id.homerecyler);
        catlist.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, true));
        homeCategoryAdapter = new HomeCategoryAdapter(root.getContext(),categories);
        catlist.setAdapter(homeCategoryAdapter);

    }

    private void setRecommendedGrid()
    {

        recommendProd.add(new Product("Diamong Ring","$190.75","$5000.00", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15","$5000.00", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05","$5000.00", R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans","$21.50","$5000.00", R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans","$34.75","$5000.00", R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers","$28.13", "$5000.00", R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring","$190.75","$5000.00", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15","$5000.00", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05", "$5000.00",R.drawable.cap_6));
        recommendProd.add(new Product("Diamong Ring","$190.75","$5000.00", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15","$5000.00", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05","$5000.00", R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans","$21.50","$5000.00", R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans","$34.75","$5000.00", R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers","$28.13", "$5000.00", R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring","$190.75","$5000.00", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15","$5000.00", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05", "$5000.00",R.drawable.cap_6));
        recommendProd.add(new Product("Diamong Ring","$190.75","$5000.00", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15","$5000.00", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05","$5000.00", R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans","$21.50","$5000.00", R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans","$34.75","$5000.00", R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers","$28.13", "$5000.00", R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring","$190.75","$5000.00", R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15","$5000.00", R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05", "$5000.00",R.drawable.cap_6));
        newrecyler = (RecyclerView)root.findViewById(R.id.newrecyler);
        newrecyler.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        adapter = new ArrivalAdapter(root.getContext(), recommendProd, this);
        newrecyler.setAdapter(adapter);
    }

    private void showandHideBottomAppBar()
    {


        FloatingActionButton fab = getActivity().findViewById(R.id.floatingActionButton2);
        BottomAppBar mBottomAppBar = getActivity().findViewById(R.id.bottomAppBar2);

//        newrecyler.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                int currentFirstVisPos = view.getFirstVisiblePosition();
//                if(currentFirstVisPos > myLastVisiblePos) {
//                    //scroll down
//                    mBottomAppBar.performHide();
//                    fab.hide();
//                }
//                if(currentFirstVisPos < myLastVisiblePos) {
//                    //scroll up
//                    mBottomAppBar.performShow();
//                    fab.show();
//                }
//                myLastVisiblePos = currentFirstVisPos;
//            }
//        });

//        scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
////                Toast.makeText(getContext(),""+scrollX +"\n"+scrollY+"\n"+oldScrollX+"\n"+oldScrollY,Toast.LENGTH_LONG).show();
//
//                if (scrollY > oldScrollY) {
//                   mBottomAppBar.performHide();
//                   fab.hide();
//                }
//                else{
//                    mBottomAppBar.performShow();
//                    fab.show();
//                }
//
////                if(oldScrollY > 0)
////                {
////                    mBottomAppBar.performHide();
////                }
////                if (oldScrollY<0)
////                {
////                    mBottomAppBar.performShow();
////                }
//
//            }
//        });
    }


    @Override
    public void onProductItemClick(int pos, ImageView prodimg, ImageView favprod, TextView prodname, TextView prodprice) {
        Intent intent = new Intent(root.getContext(), ProductsActivity.class);
        intent.putExtra("productObj", recommendProd.get(pos));

        Pair<View, String> p1 = Pair.create((View)prodimg, "ProductTN");
        Pair<View, String> p2 = Pair.create((View)favprod, "favTN");
        Pair<View, String> p3 = Pair.create((View)prodname, "nameTN");
        Pair<View, String> p4 = Pair.create((View)prodprice, "priceTN");

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this.getActivity(), p1,p2,p3,p4);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            root.getContext().startActivity(intent, optionsCompat.toBundle());
        }else
            root.getContext().startActivity(intent);

    }
}
