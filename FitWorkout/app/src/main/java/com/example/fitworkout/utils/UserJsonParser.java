package com.example.fitworkout.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.fitworkout.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserJsonParser {

    //Get all Users
    public static ArrayList<User> parserJsonUsers(JSONArray response) {
        ArrayList<User> users = new ArrayList<>();

        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject user = (JSONObject) response.get(i);

                int id = user.getInt("id");
                String username = user.getString("username");
                String email = user.getString("email");
                String auth_key = user.getString("auth_key");
                String password_hash = user.getString("password_hash");

                User auxUser = new User(id, username, email, auth_key, password_hash);

                users.add(auxUser);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Get an single User
    public static User parserJsonUser(String response) {

        User auxUser = null;

        try {
            JSONObject user = new JSONObject(response);
            int id = user.getInt("id");
            String username = user.getString("username");
            String email = user.getString("email");
            String auth_key = user.getString("auth_key");
            String password_hash = user.getString("password_hash");

            auxUser = new User(id, username, email, auth_key, password_hash);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return auxUser;
    }

    private static String token;

    public static String parserJsonLogin(String response) {
        token = null;

        try {
            JSONObject login = new JSONObject(response);

            if (login.getBoolean("success"))
                token = login.getString("auth_key");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return token;
    }

    public static boolean isConnectionInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
