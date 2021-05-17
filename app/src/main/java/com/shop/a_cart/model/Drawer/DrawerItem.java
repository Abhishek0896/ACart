package com.shop.a_cart.model.Drawer;

import android.view.ViewGroup;

import com.shop.a_cart.adapter.Drawer.DrawerAdapter;

public abstract class DrawerItem<T extends DrawerAdapter.ViewHolder> {

    protected boolean isChecked;
    public abstract T createViewHolder(ViewGroup parent);

    public abstract void bindViewHolder(T holder);

    public DrawerItem<T>setChecked(boolean isChecked){
        this.isChecked = isChecked;
        return this;
    }
    public boolean isChecked(){
        return isChecked;
    }

    public boolean isSelectable(){
        return true;
    }
}
