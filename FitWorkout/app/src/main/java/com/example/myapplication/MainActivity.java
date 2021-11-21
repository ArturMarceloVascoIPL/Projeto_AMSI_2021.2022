package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.vistas.FragmentCalendar;
import com.example.myapplication.vistas.FragmentHistory;
import com.example.myapplication.vistas.FragmentHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    /**
     * Instanciar os Fragmentos
     */
    FragmentHome fragmentHome = new FragmentHome();
    FragmentCalendar fragmentCalendar = new FragmentCalendar();
    FragmentHistory fragmentHistory = new FragmentHistory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.bottom_nav_calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentCalendar).commit();
                return true;

            case R.id.bottom_nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
                return true;

            case R.id.bottom_nav_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHistory).commit();
                return true;
        }
        return false;
    }
}