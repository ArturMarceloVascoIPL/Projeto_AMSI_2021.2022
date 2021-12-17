package com.example.fitworkout.listeners;

import android.content.Context;

public interface LoginListener {
    void onValidateLogin(final String username, final String password, final Context context);
}
