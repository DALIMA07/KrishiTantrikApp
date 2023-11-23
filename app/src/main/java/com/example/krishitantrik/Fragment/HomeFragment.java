package com.example.krishitantrik.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.krishitantrik.Adapter.MyAdapterForMarkertView;
import com.example.krishitantrik.Class.Item;
import com.example.krishitantrik.R;
import com.google.android.gms.common.internal.Constants;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private String param1;
    private String param2;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString("param1");
            param2 = getArguments().getString("param2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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


        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewMarketItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapterForMarkertView(getActivity().getApplicationContext(),items));

    }

}