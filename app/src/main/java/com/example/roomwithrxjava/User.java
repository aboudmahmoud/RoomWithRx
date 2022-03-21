package com.example.roomwithrxjava;

public class User {
    private int userId;
    private String UserName;

    public User(int userId, String userName) {
        this.userId = userId;
        UserName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }


}
