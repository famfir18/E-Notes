package com.faisal.e_notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_login)
    void clickInput(View v){
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }
}
