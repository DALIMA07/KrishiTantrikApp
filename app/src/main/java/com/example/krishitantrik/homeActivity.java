package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishitantrik.Adapter.MyAdapterForMarkertView;
import com.example.krishitantrik.Class.Item;
import com.example.krishitantrik.util.AndroidUtil;
import com.google.protobuf.Internal;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //for action bar
        ImageView leftIcon = findViewById(R.id.left_icon);
        ImageView rightIcon = findViewById(R.id.right_icon);
        TextView title = findViewById(R.id.actionbar_title);

        leftIcon.setOnClickListener(v -> AndroidUtil.showToast(getApplicationContext(),"You clicked in left icon"));
        rightIcon.setOnClickListener(v -> AndroidUtil.showToast(getApplicationContext(),"You clicked in right icon"));
        title.setText("HOME");

        //items for testing
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Soya Bean","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Tomato","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Potato","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Rice","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Wheat","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Sugar Cane","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Bajra","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Jowar","Janki Nagar 5 KM","6 oct 2023"));
        items.add(new Item("Corn","Janki Nagar 5 KM","6 oct 2023"));

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMarketItems);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapterForMarkertView(getApplicationContext(),items));

    }
}