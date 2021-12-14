package com.example.fitworkout.views;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitworkout.R;
import com.example.fitworkout.views.client.MainMenuActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    /**
     * Validações do Username e Password
     */
    //region Validações

    /* Verifica se o username é valido */
    private boolean isUsernameValida(String username) {
        // TODO: Implementar verificacao do username
        return !TextUtils.isEmpty(username);
    }

    /* Verifica se a Password é válida */
    private boolean isPasswordValida(String password) {
        if (TextUtils.isEmpty(password))
            return false;

        return password.length() >= 8;
    }

    //endregion

    /**
     * Funções de Click
     */
    //region Funções Click

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

        // Prepara a atividade
        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra("USERNAME", username);

        // Inicia a atividade e fecha esta
        startActivity(intent);
        finish();
    }

    /* Função de Click no Registo */
    public void onClickRegister(View view) {
        // Prepara a atividade
        Intent intent = new Intent(this, RegisterActivity.class);

        // Inicia a atividade e fecha esta
        startActivity(intent);
        finish();
    }

    //endregion
}