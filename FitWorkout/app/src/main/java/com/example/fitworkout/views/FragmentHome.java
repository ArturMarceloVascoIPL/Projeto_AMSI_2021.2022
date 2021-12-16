package com.example.fitworkout.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.fitworkout.R;
import com.example.fitworkout.adapters.AdapterWorkoutList;
import com.example.fitworkout.models.SingletonFitworkout;
import com.example.fitworkout.models.Workout;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private ListView lvTreinos;
    private ArrayList<Workout> listaWorkouts;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listaWorkouts = SingletonFitworkout.getInstance(getContext()).getWorkoutsBD();

        lvTreinos = view.findViewById(R.id.lvWorkoutList);

        if (listaWorkouts != null)
            lvTreinos.setAdapter(new AdapterWorkoutList(getContext(), listaWorkouts));

        lvTreinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // TODO: Implementar função para quando seleciona um treino
            }
        });

        return view;
    }
}