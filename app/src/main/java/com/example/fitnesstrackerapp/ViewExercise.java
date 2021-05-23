package com.example.fitnesstrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.util.Locale;

public class ViewExercise extends AppCompatActivity {

    Button btnStartPause,btnReset;
    TextView  timer,title;
    int image_id;
    String name;
    ImageView detail_image;
    CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS =600000;
    private long TimeLeftInMillis = START_TIME_IN_MILLIS;
    boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        timer = (TextView) findViewById(R.id.timer);
        title = (TextView) findViewById(R.id.title);
        detail_image = (ImageView) findViewById(R.id.detail_image);

        btnStartPause = (Button) findViewById(R.id.btnStartPause);
        btnReset=(Button) findViewById(R.id.btnReset);



         detail_image.setImageResource(getIntent().getIntExtra("image_id",0));
         title.setText(getIntent().getStringExtra("name"));


        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isRunning)
                {
                    pauseTimer();
                }else {
                    startTimer();
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   resetTimer();
            }
        });

        updateCountDownText();



    }



    private void startTimer() {
        countDownTimer = new CountDownTimer(TimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            TimeLeftInMillis=millisUntilFinished;
            updateCountDownText();
            }

            @Override
            public void onFinish() {

                isRunning=false;
                btnStartPause.setText("START");
                btnReset.setVisibility(View.INVISIBLE);
            }
        }.start();

    isRunning=true;
    btnStartPause.setText("PAUSE");
    btnReset.setVisibility(View.INVISIBLE);

    }

    private void updateCountDownText() {
      int seconds=(int) (TimeLeftInMillis/1000) % 60;
       String TimeLeftFormat=String.format(Locale.getDefault(),"%2d",seconds);
       timer.setText(TimeLeftFormat);
    }

    private void pauseTimer() {
     countDownTimer.cancel();
     isRunning=false;
     btnStartPause.setText("START");
     btnReset.setVisibility(View.VISIBLE);

    }

    private void resetTimer() {
         TimeLeftInMillis=START_TIME_IN_MILLIS;
         updateCountDownText();
         btnReset.setVisibility(View.INVISIBLE);

    }



}