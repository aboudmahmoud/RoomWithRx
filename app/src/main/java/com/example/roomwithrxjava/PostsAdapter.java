package com.example.roomwithrxjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomwithrxjava.databinding.PostItemBinding;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostHolder> {
    ArrayList<Post>posts= new ArrayList<>();

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item,parent,false)) ;

    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Post postModel = posts.get(position);
        holder.bind(postModel);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class  PostHolder extends RecyclerView.ViewHolder{
        PostItemBinding binding;
       // Post postModel;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            binding=PostItemBinding.bind(itemView);
        }
        void bind(Post postModel)
        {
            binding.TitleTv.setText(postModel.getTitle());
            binding.bodyTitle.setText(postModel.getBody());


        }
    }
}
