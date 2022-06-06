package com.stone.samplerecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity {

    EditText title,description,imageUrl;
    Button postBtn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        databaseReference= FirebaseDatabase.getInstance().getReference("News");

        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        imageUrl=findViewById(R.id.imageUrl);
        postBtn=findViewById(R.id.postBtn);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleStr=title.getText().toString().trim();
                String descriptionStr=description.getText().toString().trim();
                String imageUrlStr=imageUrl.getText().toString().trim();

                News news=new News(imageUrlStr,titleStr,descriptionStr);
                databaseReference.push().setValue(news).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        if(task.isSuccessful()){
                            title.setText("");
                            description.setText("");
                            imageUrl.setText("");

                            Intent intent=new Intent(PostActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                            Toast.makeText(PostActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        }else{
                            postBtn.setText("Try Again");
                            Toast.makeText(PostActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}