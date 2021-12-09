package com.example.fitworkout.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WorkoutBDHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "fitworkoutdb", DB_TABLE = "workout";
    public static final int DB_VERSION = 1;

    private static final String ID = "id", NAME = "name", DATE = "date", CALORIES_BURNED = "caloriesBurned", PTID = "ptId";

    public static SQLiteDatabase db;

    public WorkoutBDHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableWorkout = "CREATE TABLE " + DB_TABLE + " ( " +
                ID + "INTEGER PRIMARY KEY, " +
                NAME + "TEXT NOT NULL, " +
                DATE + "TEXT, " +
                CALORIES_BURNED + "INTEGER NOT NULL, " +
                PTID + "INTEGER NOT NULL);";

        db.execSQL(createTableWorkout);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTableLivro = "DROP TABLE IF EXISTS " + DB_TABLE;

        db.execSQL(deleteTableLivro);

        this.onCreate(db);
    }

    //region Métodos CRUD

    /**
     * CREATE
     */
    public void addWorkout(Workout workout) {
        ContentValues values = new ContentValues();

        values.put(ID, workout.getId());
        values.put(NAME, workout.getName());
        values.put(DATE, workout.getDate());
        values.put(CALORIES_BURNED, workout.getCaloriesBurned());
        values.put(PTID, workout.getPtId());

        db.insert(DB_TABLE, null, values);
    }

    /**
     * READ
     */
    public ArrayList<Workout> getAllWorkout() {

        ArrayList<Workout> workoutArrayList = new ArrayList<>();

        Cursor cursor = db.query(DB_TABLE, new String[]{ID, NAME, DATE, CALORIES_BURNED, PTID}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                //TODO: Acabar o CRUD
                //Workout workout = new Workout(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            }
        }
    }

    /** UPDATE */

    /** DELETE */

    //endregion
}
