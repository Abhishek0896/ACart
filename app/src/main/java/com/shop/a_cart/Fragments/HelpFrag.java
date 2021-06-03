package com.shop.a_cart.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.adapter.HelpAdapter;
import com.shop.a_cart.model.Query;

import java.util.ArrayList;
import java.util.List;

public class HelpFrag extends Fragment {
ViewGroup root;
RecyclerView recyclerView;
List<Query> queries = new ArrayList<>();
HelpAdapter adapter;
CoordinatorLayout layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.help_frag,container,false);
        recyclerView = (RecyclerView)root.findViewById(R.id.helprecyler);
        initdata();
        setrecylerview();
        layout = (CoordinatorLayout) getActivity().findViewById(R.id.bootommenucontainer);
        layout.setVisibility(View.GONE);
        return root;
    }

    private void setrecylerview() {
        HelpAdapter adapter = new HelpAdapter(queries);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initdata() {
        queries.add(new Query(getResources().getString(R.string.query_1), getResources().getString(R.string.ans_1)));
        queries.add(new Query(getResources().getString(R.string.query_2), getResources().getString(R.string.ans_2)));
        queries.add(new Query(getResources().getString(R.string.query_3), getResources().getString(R.string.ans_3)));
        queries.add(new Query(getResources().getString(R.string.query_4), getResources().getString(R.string.ans_4)));
        queries.add(new Query(getResources().getString(R.string.query_5), getResources().getString(R.string.ans_5)));
        queries.add(new Query(getResources().getString(R.string.query_6), getResources().getString(R.string.ans_6)));
        queries.add(new Query(getResources().getString(R.string.query_7), getResources().getString(R.string.ans_7)));
    }
}
