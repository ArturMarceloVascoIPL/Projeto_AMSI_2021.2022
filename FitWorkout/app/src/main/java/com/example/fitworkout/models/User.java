package com.example.fitworkout.models;

public class User {
    private int id;
    private String username, email, auth_key, password_hash;

    public User(int id, String username, String email, String auth_key, String password_hash) {
        this.id = id;
        this.username = username;
        this.auth_key = auth_key;
        this.email = email;
        this.password_hash = password_hash;
    }

    //ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //password hash
    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }
}
