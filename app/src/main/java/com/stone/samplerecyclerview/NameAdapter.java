package com.stone.samplerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {

 List<News>newsList;
 Context context;

    public NameAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.name,parent,false);

        NameViewHolder nameViewHolder=new NameViewHolder(view);

        return nameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        News news=newsList.get(position);
        //holder.nameTV.setText(name);
        holder.titleTV.setText(news.getTitle());
        holder.descTV.setText(news.getDescription());
        Glide.with(context).load(news.getImageUrl()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FullActivity.class);

                intent.putExtra("img",news.getImageUrl());
                intent.putExtra("title",news.getTitle());
                intent.putExtra("desc",news.getDescription());




                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
