package com.example.krishitantrik.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishitantrik.Class.Item;
import com.example.krishitantrik.R;
import com.example.krishitantrik.RecyclerView.MyViewHolderForMarketview;

import java.util.List;

public class MyAdapterForMarkertView extends RecyclerView.Adapter<MyViewHolderForMarketview> {

    Context context;
    List<Item> items;

    public MyAdapterForMarkertView(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public MyViewHolderForMarketview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderForMarketview(LayoutInflater.from(context).inflate(R.layout.market_view_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderForMarketview holder, int position) {

        holder.itemName.setText(items.get(position).getItemName());
        holder.itemLocation.setText(items.get(position).getItemLocation());
        holder.itemDate.setText(items.get(position).getDate());
        holder.itemPrice.setText(items.get(position).getPrice());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
