package com.example.fitworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fitworkout.views.FragmentCalendar;
import com.example.fitworkout.views.FragmentHistory;
import com.example.fitworkout.views.FragmentHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();

        // Apresentar a página Home por defeito
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.bottom_nav_calendar:
                fragment = new FragmentCalendar();
                break;
            case R.id.bottom_nav_home:
                fragment = new FragmentHome();
                break;
            case R.id.bottom_nav_history:
                fragment = new FragmentHistory();
                break;
        }

        if (fragment != null)
            fragmentManager.beginTransaction().replace(R.id.flFragment, fragment).commit();

        return true;
    }
}