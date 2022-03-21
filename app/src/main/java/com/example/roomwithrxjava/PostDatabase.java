package com.example.roomwithrxjava;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = Post.class,version = 1)
@TypeConverters(Converter.class)
public abstract class PostDatabase extends RoomDatabase {
    private static PostDatabase Instance;
    public abstract PostDao postDao();

    public static synchronized PostDatabase getInstance(Context context)
    {
        if (Instance == null)
        {
            Instance= Room.databaseBuilder(context.getApplicationContext(),PostDatabase.class,"PostTable")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return Instance;
    }
}
