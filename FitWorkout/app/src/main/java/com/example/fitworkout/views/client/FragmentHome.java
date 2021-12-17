package com.example.fitworkout.views.client;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fitworkout.R;

public class FragmentHome extends Fragment {

    private String username;
    private TextView textView;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Intent intent = this.getActivity().getIntent();
        String username = intent.getStringExtra("USERNAME");

        textView = view.findViewById(R.id.tvPlaceholder2);
        textView.setText("Bem vindo " + username);

        SharedPreferences sharedPreferencesInfoUser = this.getActivity().getSharedPreferences("USERNAME", Context.MODE_PRIVATE);

        return view;
    }
}