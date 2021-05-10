package com.example.fitnesstrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView appheadingTV,quoteTV;
    ImageView imgpage;
     Animation appnameheading,imagepage,quoteanim_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         appheadingTV=findViewById(R.id.appheadingTV);
         quoteTV=findViewById(R.id.quoteTV);
         imgpage=findViewById(R.id.imgpage);

         appnameheading=AnimationUtils.loadAnimation(this,R.anim.appnameheading);
         imagepage= AnimationUtils.loadAnimation(this,R.anim.imagepage);
         quoteanim_tv=AnimationUtils.loadAnimation(this,R.anim.quoteanim_tv);

         appheadingTV.startAnimation(appnameheading);
         imgpage.startAnimation(imagepage);
         quoteTV.startAnimation(quoteanim_tv);

        Handler handler =new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,ChooseActivity.class));
            }
        },1500);

    }
}