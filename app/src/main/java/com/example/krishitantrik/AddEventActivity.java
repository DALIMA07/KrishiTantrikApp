package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class AddEventActivity extends AppCompatActivity {

    ImageView backIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        TextView title = findViewById(R.id.actionbar_title);
        title.setText("Add Event");

        backIcon = findViewById(R.id.backIcon);
        backIcon.setOnClickListener((v -> {
            finish();
        }));

        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });
    }
}