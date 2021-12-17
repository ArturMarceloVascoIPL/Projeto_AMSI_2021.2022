package com.example.fitworkout.listeners;

import com.example.fitworkout.models.Workout;

import java.util.ArrayList;

public interface WorkoutsListener {
    void onRefreshListWorkouts(ArrayList<Workout> workoutArrayList);
}
