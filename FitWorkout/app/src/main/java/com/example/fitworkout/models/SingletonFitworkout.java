package com.example.fitworkout.models;

import android.content.Context;

public class SingletonFitworkout {

    private static SingletonFitworkout instance = null;

    public SingletonFitworkout(Context context) {

    }

    public static synchronized SingletonFitworkout getInstance(Context context) {
        if (instance != null) {
            instance = new SingletonFitworkout(context);
        }
        return instance;
    }
}
