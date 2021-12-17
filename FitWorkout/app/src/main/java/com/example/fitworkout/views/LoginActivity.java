package com.example.fitworkout.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitworkout.listeners.LoginListener;
import com.example.fitworkout.models.SingletonFitworkout;
import com.example.fitworkout.views.client.MainMenuActivity;
import com.example.fitworkout.R;

public class LoginActivity extends AppCompatActivity implements LoginListener {

    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        SingletonFitworkout.getInstance(getApplicationContext()).setLoginListener(this);

    }

    /**
     * Validações do Username e Password
     */

    /* Verifica se o username é valido */
    private boolean isUsernameValida(String username) {
        return !TextUtils.isEmpty(username);
    }

    /* Verifica se a Password é válida */
    private boolean isPasswordValida(String password) {
        if (TextUtils.isEmpty(password))
            return false;

        return password.length() >= 8;
    }

    /**
     * Funções de Click
     */
    /* Função de Click no Login */
    public void onClickLogin(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (!isUsernameValida(username)) {
            etUsername.setError("Username Inválido!");
            return;
        }

        if (!isPasswordValida(password)) {
            etPassword.setError("Password Inválida!");
            return;
        }
        SingletonFitworkout.getInstance(getApplicationContext()).loginAPI(username, password, getApplicationContext());
    }

    /* Função de Click no Registo */

    public void onClickRegister(View view) {
        // Prepara a atividade
        Intent intent = new Intent(this, RegisterActivity.class);

        // Inicia a atividade e fecha esta
        startActivity(intent);
        finish();
    }

    @Override
    public void onValidateLogin(String token, String username, Context context) {

        if (token != null) {
            guardarInfoSharedPref(token,username);

            Intent intent = new Intent(this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Login inválido", Toast.LENGTH_SHORT).show();
        }
    }

    private void guardarInfoSharedPref(String token, String username) {
        SharedPreferences sharedPrefeUser = getSharedPreferences(MainMenuActivity., Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefeUser.edit();

        editor.putString(MainMenuActivity.USERNAME, username);
        editor.putString(MainMenuActivity.TOKEN, token);
        editor.apply();
    }
}
