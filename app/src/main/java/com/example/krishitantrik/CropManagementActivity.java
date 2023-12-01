package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CropManagementActivity extends AppCompatActivity {

    TextView addEvent;
    ImageView backIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_management);

        TextView title = findViewById(R.id.actionbar_title);
        title.setText("Crop Management Screen");

        backIcon = findViewById(R.id.backIcon);
        backIcon.setOnClickListener((v -> {
            finish();
        }));

        addEvent = findViewById(R.id.addEvent);
        addEvent.setOnClickListener(v -> {
            Intent intent = new Intent(this,AddEventActivity.class);
            startActivity(intent);
        });
    }
}