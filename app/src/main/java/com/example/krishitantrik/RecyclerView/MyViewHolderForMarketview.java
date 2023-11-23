package com.example.krishitantrik.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krishitantrik.R;

public class MyViewHolderForMarketview  extends RecyclerView.ViewHolder {

    public ImageView increaseIcon;
    public TextView itemName;
    public TextView itemLocation;
    public TextView itemDate;
    public TextView itemPrice;


    public MyViewHolderForMarketview(@NonNull View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.itemName);
        itemLocation = itemView.findViewById(R.id.itemLocation);
        itemDate = itemView.findViewById(R.id.itemDate);
        increaseIcon = itemView.findViewById(R.id.incrementIcon);
        itemPrice = itemView.findViewById(R.id.itemPrice);


    }
}
