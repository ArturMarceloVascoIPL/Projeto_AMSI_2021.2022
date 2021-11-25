package com.example.fitworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.navigationDrawer);
        navigationView = findViewById(R.id.navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close);
        
        toggle.syncState();
        
        drawerLayout.addDrawerListener(toggle);
        carregarCabecalho();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Apresentar a página Home por defeito
        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
    }

    private void carregarCabecalho() {
        //TODO: Fazer método(ver na ficha da aula)
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