package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class SettingActivity extends AppCompatActivity {

    ImageView backIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        TextView title = findViewById(R.id.actionbar_title);
        title.setText("SETTING");

        backIcon = findViewById(R.id.backIcon);
        backIcon.setOnClickListener((v -> {
            finish();
        }));

    }
}