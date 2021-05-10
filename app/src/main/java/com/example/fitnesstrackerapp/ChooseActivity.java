package com.example.fitnesstrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    Button runningBT,exerciseBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        runningBT=findViewById(R.id.runningBT);
        exerciseBT=findViewById(R.id.exerciseBT);

        runningBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        exerciseBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this,ExerciseActivity.class));
            }
        });
    }
}