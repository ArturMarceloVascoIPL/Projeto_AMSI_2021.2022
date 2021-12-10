package com.example.fitworkout.models;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class SingletonFitworkout {

    private static final String mUrlAPIWorkout = ""; // TODO: Meter link para a API

    private static SingletonFitworkout instance = null;
    private static RequestQueue volleyQueue = null;

    private ArrayList<Workout> workoutArrayList;
    private WorkoutBDHelper workoutBD = null;

    public SingletonFitworkout(Context context) {
        workoutArrayList = new ArrayList<>();
        workoutBD = new WorkoutBDHelper(context);

        generateTestData();
    }

    public static synchronized SingletonFitworkout getInstance(Context context) {
        if (instance != null) {
            instance = new SingletonFitworkout(context);
            volleyQueue = Volley.newRequestQueue(context);
        }
        return instance;
    }

    private Workout getWorkout(int id) {
        for (Workout workout : workoutArrayList) {
            if (workout.getId() == id) {
                return workout;
            }
        }

        return null;
    }

    /**
     * Acesso á BD Local
     */
    //region Acesso BD Local
    public ArrayList<Workout> getWorkoutsBD() {
        workoutArrayList = workoutBD.getAllWorkout();

        return workoutArrayList;
    }

    public void addWorkoutBD(Workout workout) {
        workoutBD.addWorkout(workout);
    }

    public void addWorkoutsBD(ArrayList<Workout> workoutArrayList) {
        // Apagar dados da tabela
        workoutBD.deleteAllWorkouts();

        // Adicionar novos dados na tabela
        for (Workout workout : workoutArrayList) {
            workoutBD.addWorkout(workout);
        }
    }

    public void editWorkout(Workout workout) {
        Workout workoutTemp = getWorkout(workout.getId());

        // Verificar se existe
        if (workoutTemp != null) {
            workoutBD.editWorkout(workout);
        }
    }

    public void deleteWorkoutBD(int id) {
        Workout workoutTemp = getWorkout(id);

        // Verificar se existe
        if (workoutTemp != null) {
            workoutBD.deleteWorkout(id);
        }
    }
    //endregion

    public void generateTestData() {
        Workout workout = new Workout(1, 300, 1, "Enche o Peito", null);
        Workout workout2 = new Workout(1, 255, 1, "Enche as Pernas", null);
        workoutBD.addWorkout(workout);
        workoutBD.addWorkout(workout2);
    }

    /**
     * Acesso á API
     */
    //region Acesso API
    //endregion
}
