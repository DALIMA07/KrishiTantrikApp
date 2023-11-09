package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishitantrik.util.AndroidUtil;

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

    }
}