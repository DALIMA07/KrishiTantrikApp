package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class onboarding1 extends AppCompatActivity {
    LinearLayout forward_onboardingLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);

        forward_onboardingLL = findViewById(R.id.forward_onboardingLL);
        forward_onboardingLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), onboarding2.class);
                startActivity(intent);
            }
        });
    }
}