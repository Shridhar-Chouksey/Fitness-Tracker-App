package com.example.fitnesstrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseActivity extends AppCompatActivity {

    private Button yogaPracticeBT;
    private Button calenderBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        yogaPracticeBT=findViewById(R.id.yogaPracticeBT);
//        calenderBT=findViewById(R.id.calenderBT);


        yogaPracticeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExerciseActivity.this,YogaActivity.class));
                
            }
        });




    }
}