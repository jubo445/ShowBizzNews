package com.stone.samplerecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    TextView titleTV,descTV;
    ImageView imageView;


    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTV=itemView.findViewById(R.id.titleTV);
        descTV=itemView.findViewById(R.id.descTV);
        imageView=itemView.findViewById(R.id.image);
    }


}
