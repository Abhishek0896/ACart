package com.shop.a_cart.model;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public interface ProductCallback {
    void onProductItemClick(int pos,
                            ImageView prodimg,
                            ImageView favprod,
                            TextView prodname,
                            TextView prodprice);
}
