package com.example.roomwithrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.roomwithrxjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       final PostsAdapter adapter = new PostsAdapter();
        binding.RVItems.setAdapter(adapter);
        final   PostDatabase postDatabase = PostDatabase.getInstance(this);
        binding.InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("aboud", "onClick1: ");
                System.out.println("Aboud"+binding.EditTitle.getText().toString());
                Log.d("aboud", "onClick: ");
                postDatabase.postDao()
                        .insertPost(new Post(1,binding.EditTitle.getText().toString(),binding.Editboy.getText().toString()))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }
        });


        binding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDatabase.postDao().getPosts().subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<Post>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull List<Post> posts) {
                                adapter.setPosts((ArrayList<Post>) posts);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        });

    }
}