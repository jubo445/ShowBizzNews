package com.stone.samplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FullActivity extends AppCompatActivity {
    Intent intent;

    TextView titleTV,descTV;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        intent=getIntent();
        String title=intent.getStringExtra("title");
        String image=intent.getStringExtra("img");
        String desc=intent.getStringExtra("desc");

        titleTV=findViewById(R.id.titleTV);
        descTV=findViewById(R.id.descTV);
        imageView=findViewById(R.id.image);

        titleTV.setText(title);
        descTV.setText(desc);
        Glide.with(FullActivity.this).load(image).into(imageView);





    }
}