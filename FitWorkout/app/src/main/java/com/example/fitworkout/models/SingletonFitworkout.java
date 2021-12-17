package com.example.fitworkout.models;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fitworkout.listeners.LoginListener;
import com.example.fitworkout.utils.UserJsonParser;
import com.example.fitworkout.views.LoginActivity;

import java.util.HashMap;
import java.util.Map;

public class SingletonFitworkout {

    private static SingletonFitworkout instance = null;
    private static RequestQueue volleyQueue = null;
    private static final String mUrlAPIFitWorkout = "http://10.20.246.148:8080/";
    private LoginListener loginListener;

    public SingletonFitworkout(Context context) {

    }

    public static synchronized SingletonFitworkout getInstance(Context context) {
        if (instance == null) {
            instance = new SingletonFitworkout(context);
            volleyQueue = Volley.newRequestQueue(context);
        }
        return instance;
    }

    public void setLoginListener(LoginActivity loginActivity) {
        this.loginListener = loginActivity;
    }

    public void loginAPI(final String username, final String password, final Context context) {
        String mUrlAPILogin = mUrlAPIFitWorkout + "v1/auth/login";

        if (!UserJsonParser.isConnectionInternet(context))
            Toast.makeText(context, "Sem ligação á Internet", Toast.LENGTH_SHORT).show();
        else {
            StringRequest request = new StringRequest(Request.Method.POST, mUrlAPILogin, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    String token = UserJsonParser.parserJsonLogin(response);
                    //Toast.makeText(context, username, Toast.LENGTH_SHORT).show();

                    if (loginListener != null)
                        loginListener.onValidateLogin(token, username, context);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    params.put("username", username);
                    params.put("password", password);

                    return params;
                }
            };
            volleyQueue.add(request);
        }
    }
}