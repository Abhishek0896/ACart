package com.shop.a_cart.adapter.Drawer;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.model.Drawer.DrawerItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    public List<DrawerItem> item;
    public Map<Class<? extends DrawerItem>, Integer > viewTypes;
    public SparseArray<DrawerItem> holderFactories;

    public OnItemSelectedListener listener;

    public DrawerAdapter(List<DrawerItem> items){
        this.item = items;
        this.viewTypes = new HashMap<>();
        this.holderFactories = new SparseArray<>();
        processViewTypes();
    }

    public void processViewTypes() {
        int type =0;
        for(DrawerItem items : item){
            if(!viewTypes.containsKey(items.getClass())){
                viewTypes.put(items.getClass(), type);
                holderFactories.put(type, items);
                type ++;
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = holderFactories.get(viewType).createViewHolder(parent);
        holder.adapter = this;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item.get(position).bindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes.get(item.get(position).getClass());
    }

    public void setSelected(int positon)
    {
        DrawerItem newChecked = item.get(positon);
        if(!newChecked.isSelectable()){
            return;
        }
        for(int i=0; i<item.size(); i++){
            DrawerItem items = item.get(i);
            if(items.isChecked()){
                items.setChecked(false);
                notifyItemChanged(i);
                break;
            }
        }

        newChecked.setChecked(true);
        notifyItemChanged(positon);

        if(listener != null){
            listener.onItemSelected(positon);
        }
    }

    public void setListener(OnItemSelectedListener listener){
        this.listener = listener;
    }

    public interface OnItemSelectedListener{
        void onItemSelected(int positon);
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private DrawerAdapter adapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            adapter.setSelected(getAdapterPosition());
        }
    }
}
