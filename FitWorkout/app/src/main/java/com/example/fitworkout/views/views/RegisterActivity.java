package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class RegisterActivity extends AppCompatActivity {

    private final Integer PASSWORD_LENGHT = 8;
    private EditText etEmail, etUsername, etPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
    }

    /**
     * Validações do Email, Username, Password e Confirmação
     */

    /* Verifica se o Email é válido */
    private boolean isEmailValido(String email) {
        // TODO: Complementar melhor a verificacao do email
        if (email == null)
            return false;

        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /* Verifica se o Username é válido */
    private boolean isUsernameValido(String username) {
        // TODO: Complementar melhor a verificacao do username
        if (username == null)
            return true;

        return false;
    }

    /* Verifica se a Password é válida */
    private boolean isPasswordValida(String password) {
        // TODO: Complementar melhor a verificacao da password
        if (password == null)
            return false;

        return (password.length() >= PASSWORD_LENGHT);
    }

    /* Verifica se a Password é válida */
    private boolean isConfirmacaoValida(String confirmacao, String password) {
        // TODO: Complementar melhor a verificacao da confirmação de password
        if (confirmacao == null)
            return false;

        return (confirmacao.equals(password));
    }

    /**
     * Funções de Click
     */

    /* Função de Click no Registo */
    public void onClickRegister(View view) {
        String email = etEmail.getText().toString();
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        if (!isEmailValido(email)) {
            etEmail.setError("Email Inválido!");
            return;
        }

        if (!isUsernameValido(username)) {
            etUsername.setError("Username Inválido!");
            return;
        }

        if (!isPasswordValida(password)) {
            etPassword.setError("Password Inválida! Minimo de " + PASSWORD_LENGHT + " carateres.");
            return;
        }

        if (!isConfirmacaoValida(confirmPassword, password)) {
            etConfirmPassword.setError("Passwords não são iguais!");
            return;
        }

        // Prepara a atividade
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EMAIL", email);

        // Inicia a atividade e fecha esta
        startActivity(intent);
        finish();
    }

    /* Função de Click no Login */
    public void onClickLogin(View view) {
        // Prepara a atividade
        Intent intent = new Intent(this, LoginActivity.class);

        // Inicia a atividade e fecha esta
        startActivity(intent);
        finish();
    }
}