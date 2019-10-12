package com.faisal.e_notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.cardInput)
    void clickInput(View v){
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
        Intent i = new Intent(MainActivity.this, InputDataBarang.class);
        startActivity(i);
    }

    @OnClick(R.id.cardLihatData)
    void clickLihat(View v){
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
        Intent i = new Intent(MainActivity.this, LihatDataBarang.class);
        startActivity(i);
    }

    @OnClick(R.id.cardAbout)
    void clickAbout(View v){
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
//        Intent i = new Intent(MainActivity.this, LihatDataBarang.class);
//        startActivity(i);
    }

    @OnClick(R.id.cardLogout)
    void clickLogout(View v){
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }
}
