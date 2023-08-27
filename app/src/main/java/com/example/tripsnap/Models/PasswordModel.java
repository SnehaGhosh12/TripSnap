package com.example.tripsnap.Models;

public class PasswordModel {
    String userPassword;

    public PasswordModel() {
    }

    public PasswordModel(String password) {
        this.userPassword = password;
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }
}
