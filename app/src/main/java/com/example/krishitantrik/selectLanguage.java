package com.example.krishitantrik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class selectLanguage extends AppCompatActivity {
    TextView englishTV ;
    TextView banglaTV ;
    TextView hindiTV ;
    TextView malayalamTV ;
    TextView tamilTV ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        englishTV = findViewById(R.id.englishTV);
        banglaTV = findViewById(R.id.banglaTV);
        hindiTV = findViewById(R.id.hindiTV);
        malayalamTV = findViewById(R.id.malayalamTV);
        tamilTV = findViewById(R.id.tamilTV);

        englishTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selectLanguage.this,onboarding1.class));
            }
        });
    }
}