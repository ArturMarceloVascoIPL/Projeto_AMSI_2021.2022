package com.example.fitworkout.models;

import java.util.Date;

public class Workout {
    private int id, caloriesBurned, ptId;
    private String name, date;

    public Workout(int id, int caloriesBurned, int ptId, String name, String date) {
        this.id = id;
        this.caloriesBurned = caloriesBurned;
        this.ptId = ptId;
        this.name = name;
        this.date = date;
    }

    // ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // CALORIES BURNED
    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    // NAME
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // DATE
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // PERSONAL TRAINER ID
    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }
}
