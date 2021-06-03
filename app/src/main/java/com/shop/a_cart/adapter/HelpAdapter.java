package com.shop.a_cart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.a_cart.R;
import com.shop.a_cart.model.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.HelpView> {

    List<Query> queries = new ArrayList<>();

    public HelpAdapter(List<Query> queries) {
        this.queries = queries;
    }

    @NonNull
    @Override
    public HelpView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.help_query_item,parent,false);
        return new HelpView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpView holder, int position) {
        boolean isExpandable = queries.get(position).isExpandable();
        holder.anslayout.setVisibility(isExpandable ? View.VISIBLE :View.GONE);
    }

    @Override
    public int getItemCount() {
        return queries.size();
    }

    public class HelpView extends RecyclerView.ViewHolder {
        ImageView like,disklike, openans;
        TextView query,ans;
        ConstraintLayout queslayout,anslayout;
        public HelpView(@NonNull View itemView) {
            super(itemView);
            like = (ImageView)itemView.findViewById(R.id.qlike);
            disklike =(ImageView)itemView.findViewById(R.id.qdisike);
            openans = (ImageView)itemView.findViewById(R.id.openans);
            query = (TextView)itemView.findViewById(R.id.query);
            ans =(TextView)itemView.findViewById(R.id.answer);
            queslayout =(ConstraintLayout)itemView.findViewById(R.id.query_layout);
            anslayout =(ConstraintLayout)itemView.findViewById(R.id.expandable_layout_ans);

            openans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Query query = queries.get(getAdapterPosition());
                    query.setExpandable(!query.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
