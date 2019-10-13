package com.faisal.e_notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputDataBarang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_barang);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_submit)
    void clickSubmit(View v){
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
        Toast.makeText(this,"Berhasil Input Data", Toast.LENGTH_SHORT).show();
    }
}
