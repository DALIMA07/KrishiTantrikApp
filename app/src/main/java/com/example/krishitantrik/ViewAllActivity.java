package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishitantrik.Adapter.MyAdapterForMarkertView;
import com.example.krishitantrik.Class.Item;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    ImageView backIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView title = findViewById(R.id.actionbar_title);
        title.setText("MARKET VIEW");

        backIcon = findViewById(R.id.backIcon);
        backIcon.setOnClickListener((v -> {
            finish();
        }));

        //items for testing
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Soya Bean","Janki Nagar 5 KM","6 Sept 2023","₹ 120/Kg"));
        items.add(new Item("Tomato","Janki Nagar 5 KM","6 oct 2023","₹ 40/Kg"));
        items.add(new Item("Potato","Janki Nagar 5 KM","16 oct 2023","₹ 80/Kg"));
        items.add(new Item("Rice","Janki Nagar 5 KM","26 Jan 2022","₹ 210/Kg"));
        items.add(new Item("Wheat","Janki Nagar 5 KM","13 July 2023","₹ 110/Kg"));
        items.add(new Item("Sugar Cane","Janki Nagar 5 KM","22 Dec 2023","₹ 220/Kg"));
        items.add(new Item("Bajra","Janki Nagar 5 KM","30 oct 2023","₹ 140/Kg"));
        items.add(new Item("Jowar","Janki Nagar 5 KM","05 June 2023","₹ 150/Kg"));
        items.add(new Item("Corn","Janki Nagar 5 KM","26 oct 2023","₹ 220/Kg"));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMarketItems2);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapterForMarkertView(getApplicationContext(),items));
    }
}