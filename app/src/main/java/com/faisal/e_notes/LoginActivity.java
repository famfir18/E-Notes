package com.faisal.e_notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText username;
    @BindView(R.id.et_password)
    EditText password;
    @BindView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_login)
    void clickInput(View v){
        String txtUsername = username.getText().toString();
        String txtPassword = password.getText().toString();

        if (txtUsername.equals("FAMFIR") & txtPassword.equals("faisalamirul")|
            txtUsername.equals("FAISAL" ) & txtPassword.equals("faisalfirdaus")|
            txtUsername.equals("AMIRUL") & txtPassword.equals("amirulfirdaus")|
            txtUsername.equals("FIRDAUS") & txtPassword.equals("firdausfaisal")|
            txtUsername.equals("FAISAL18") & txtPassword.equals("firdaus18")){
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.putExtra("username", txtUsername);
                    i.putExtra("password", txtPassword);
                    startActivity(i);
        } else if (txtUsername.equals("")){
            Toast.makeText(LoginActivity.this, "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (txtPassword.equals("")){
            Toast.makeText(LoginActivity.this, "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(LoginActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
        }
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
    }
}
