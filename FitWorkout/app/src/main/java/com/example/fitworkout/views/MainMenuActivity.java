package com.example.fitworkout.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fitworkout.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Apresentar a página Home por defeito
        bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
    }

    //region App Bar Navigation

    //
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()) {
            case R.id.appbarItemAccSettings:
                intent = new Intent(this, ActivityAccountSettings.class);
                break;

            case R.id.appbarItemChangeAccount:
                createConfirmationDialog(); // TODO: Acabar a função
                break;

            case R.id.appbarItemOrders:
                intent = new Intent(this, ActivityOrders.class);
                break;

            case R.id.appbarItemExercises:
                intent = new Intent(this, ActivityExercises.class);
                break;

            case R.id.appbarItemChat:
                intent = new Intent(this, ActivityChat.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }

        return false;
    }

    //endregion

    //region Bottom Navigation

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

    //endregion

    public void createConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Alterar Modo de Conta?")
                .setMessage("Quer mesmo mudar para o modo Personal Trainer?")

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: Implementar funcionalidade (Mudar Modo de Conta)
                        Toast.makeText(getApplicationContext(), "Mudou Modo de Conta", Toast.LENGTH_SHORT).show();
                    }
                })

                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}