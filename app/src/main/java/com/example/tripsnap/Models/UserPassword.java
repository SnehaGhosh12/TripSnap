package com.example.tripsnap.Models;

public class UserPassword {
    Long userId;
    String userPassword;

    public UserPassword(Long userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
