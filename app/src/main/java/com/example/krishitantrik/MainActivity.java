package com.example.krishitantrik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.krishitantrik.Fragment.BasketFragment;
import com.example.krishitantrik.Fragment.HandPlantingFragment;
import com.example.krishitantrik.Fragment.HomeFragment;
import com.example.krishitantrik.Fragment.MessageBotFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    BasketFragment basketFragment = new BasketFragment();
    HandPlantingFragment handPlantingFragment = new HandPlantingFragment();
    MessageBotFragment messageBotFragment = new MessageBotFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView  = findViewById(R.id.btnBottomView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.nav_basket:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, basketFragment).commit();
                        return true;
                    case R.id.nav_handPlanting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, handPlantingFragment).commit();
                        return true;
                    case R.id.nav_messageBot:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, messageBotFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}