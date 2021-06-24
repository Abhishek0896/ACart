package com.shop.a_cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.shop.a_cart.model.Product;

public class ProductsActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        imageView = findViewById(R.id.mainprodimg);

        Product item =(Product)getIntent().getExtras().getSerializable("productObj");
        loadProdData(item);
    }

    private void loadProdData(Product item) {
        Glide.with(this).load(item.getUrl()).into(imageView);
    }
}