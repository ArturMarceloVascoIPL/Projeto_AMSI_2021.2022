package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String username = getIntent().getStringExtra("USERNAME").toString();

        /* Placeholder (para remover) */
        TextView tvPlaceholder = findViewById(R.id.tvPlaceholder);
        tvPlaceholder.setText(username);
    }
}