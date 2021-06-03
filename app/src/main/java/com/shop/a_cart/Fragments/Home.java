package com.shop.a_cart.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.linyuzai.expandablegridview.adapter.SimpleExpandableGridAdapter;
import com.shop.a_cart.LayoutManager.CenterZoomLayoutManager;
import com.shop.a_cart.ProductsActivity;
import com.shop.a_cart.R;
import com.shop.a_cart.adapter.ExclusiveGridAdapter;
import com.shop.a_cart.adapter.PopularAdapter;
import com.shop.a_cart.adapter.RecommendedAdapter;
import com.shop.a_cart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    int myLastVisiblePos = 0;
    RecyclerView poplist;
    PopularAdapter popularAdapter;
    RecommendedAdapter adapter;
    ViewGroup root;
    ExclusiveGridAdapter gridAdapter;
    GridView exclusiveproductgridview;
    TextView uname;
    FloatingActionButton floatingActionButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.home_frag, container, false);
        exclusiveproductgridview =(GridView) root.findViewById(R.id.exclusiveproductgrid);
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
        List<Product> popularprod = new ArrayList<>();
        popularprod.add(new Product("Red T-Shirt","$7.05",R.drawable.buy_1));
        popularprod.add(new Product("Hand Bag","$10.95",R.drawable.bag_3));
        popularprod.add(new Product("Hand Bag","$5.05",R.drawable.bag_4));
        popularprod.add(new Product("HeadPhone","$21.15",R.drawable.headphone_5));
        popularprod.add(new Product("HeadPhone","$15.43",R.drawable.headphone_6));
        popularprod.add(new Product("Roadster Watch","$19.08",R.drawable.product9));
        popularprod.add(new Product("Fossil Watch","$18.75",R.drawable.product8));
        poplist = (RecyclerView) root.findViewById(R.id.poplist);
        CenterZoomLayoutManager layoutManager = new CenterZoomLayoutManager(getActivity(), 0,false);
        poplist.setLayoutManager(layoutManager);
        popularAdapter = new PopularAdapter(getActivity(),popularprod);
        poplist.setAdapter(popularAdapter);
    }

    private void setRecommendedGrid()
    {
        SimpleExpandableGridAdapter<String> expandableGridAdapter;
        List<List<String>> strings = new ArrayList<>();
        List<Product> recommendProd = new ArrayList<>();
        recommendProd.add(new Product("Diamong Ring","$190.75",R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15",R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05",R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans","$21.50",R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans","$34.75",R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers","$28.13",R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring","$190.75",R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15",R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05",R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans","$21.50",R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans","$34.75",R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers","$28.13",R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring","$190.75",R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15",R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05",R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans","$21.50",R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans","$34.75",R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers","$28.13",R.drawable.womanshoe_5));
        recommendProd.add(new Product("Diamong Ring","$190.75",R.drawable.ring_2));
        recommendProd.add(new Product("Official Shoe","$19.15",R.drawable.shoeman_3));
        recommendProd.add(new Product("Black Cap","$11.05",R.drawable.cap_6));
        recommendProd.add(new Product("Denim Jeans","$21.50",R.drawable.jeans_1));
        recommendProd.add(new Product("Black Jeans","$34.75",R.drawable.jeans_2));
        recommendProd.add(new Product("High Top Sneakers","$28.13",R.drawable.womanshoe_5));

        gridAdapter = new ExclusiveGridAdapter(recommendProd,getActivity());
        exclusiveproductgridview.setAdapter(gridAdapter);
//        rec_products = (RecyclerView) root.findViewById(R.id.rec_products);
//        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        rec_products.setHasFixedSize(true);
//        rec_products.setLayoutManager(layoutManager);
//        adapter = new RecommendedAdapter(getActivity(), recommendProd);
//        rec_products.setAdapter(adapter);

    }

    private void showandHideBottomAppBar()
    {

        NestedScrollView scroll = root.findViewById(R.id.scroll);
        FloatingActionButton fab = getActivity().findViewById(R.id.floatingActionButton2);
        BottomAppBar mBottomAppBar = getActivity().findViewById(R.id.bottomAppBar2);

        exclusiveproductgridview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int currentFirstVisPos = view.getFirstVisiblePosition();
                if(currentFirstVisPos > myLastVisiblePos) {
                    //scroll down
                    mBottomAppBar.performHide();
                    fab.hide();
                }
                if(currentFirstVisPos < myLastVisiblePos) {
                    //scroll up
                    mBottomAppBar.performShow();
                    fab.show();
                }
                myLastVisiblePos = currentFirstVisPos;
            }
        });

        scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

//                Toast.makeText(getContext(),""+scrollX +"\n"+scrollY+"\n"+oldScrollX+"\n"+oldScrollY,Toast.LENGTH_LONG).show();

                if (scrollY > oldScrollY) {
                   mBottomAppBar.performHide();
                   fab.hide();
                }
                else{
                    mBottomAppBar.performShow();
                    fab.show();
                }

//                if(oldScrollY > 0)
//                {
//                    mBottomAppBar.performHide();
//                }
//                if (oldScrollY<0)
//                {
//                    mBottomAppBar.performShow();
//                }

            }
        });
    }



}
