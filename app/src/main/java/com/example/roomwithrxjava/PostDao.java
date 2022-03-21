package com.example.roomwithrxjava;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface PostDao {
    @Insert
    Completable insertPost(Post post);
    @Query("select * from PostTable")
   Observable< List<Post>> getPosts();
}
