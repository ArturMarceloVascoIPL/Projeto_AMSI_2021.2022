package com.example.fitworkout.models;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.fitworkout.listeners.WorkoutsListener;

import java.util.ArrayList;

public class SingletonFitworkout {

    private static final String mUrlAPIWorkout = ""; // TODO: Meter link para a API

    private static SingletonFitworkout instance = null;
    private static RequestQueue volleyQueue = null;

    private ArrayList<Workout> workoutArrayList;
    private WorkoutBDHelper workoutBD = null;
    private WorkoutsListener workoutsListener;

    public SingletonFitworkout(Context context) {
        workoutArrayList = new ArrayList<>();
        workoutBD = new WorkoutBDHelper(context);

        generateTestData();
    }

    public static synchronized SingletonFitworkout getInstance(Context context) {
        if (instance == null) {
            instance = new SingletonFitworkout(context);
            volleyQueue = Volley.newRequestQueue(context);
        }
        return instance;
    }

    public void setWorkoutsListener(WorkoutsListener workoutsListener) {
        this.workoutsListener = workoutsListener;
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
        ArrayList<Workout> workouts = new ArrayList<>();

        workouts.add(new Workout(1, "Treina o Peito", null, 300, 1));
        workouts.add(new Workout(2, "Treina as Pernas", null, 255, 1));
        workouts.add(new Workout(3, "Aquecimentos", null, 100, 1));
        workouts.add(new Workout(4, "Alongamentos", null, 200, 1));

        addWorkoutsBD(workouts);
    }

    /**
     * Acesso á API
     */
    //region Acesso API
    public void getAllWorkoutsAPI(final Context context){

    }
    //endregion
}
