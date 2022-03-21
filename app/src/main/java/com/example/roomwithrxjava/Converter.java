package com.example.roomwithrxjava;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class Converter {

    @TypeConverter
    public String toGsonString(User user) {
        return new Gson().toJson(user);
    }
    @TypeConverter
    public User toUser(String user) {
        return new Gson().fromJson(user, User.class);
    }

}
