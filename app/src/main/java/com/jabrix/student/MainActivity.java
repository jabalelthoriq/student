package com.jabrix.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    FourFragment fourFragment = new FourFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.dashboard) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
            return true;
        } else if (itemId == R.id.order) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
            return true;
        } else if (itemId == R.id.overview) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
            return true;
        } else if (itemId == R.id.settings) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fourFragment).commit();
            return true;
        }

        return false;
    }
}