package com.faisal.e_notes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    Dialog popUpAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        popUpAbout = new Dialog(this);
    }

    @OnClick(R.id.cardInput)
    void clickInput(View v){
        String txtUsername = getIntent().getStringExtra("username");
        String txtPassword = getIntent().getStringExtra("password");

        if (txtUsername.equals("FAMFIR") & txtPassword.equals("faisalamirul")){
            Intent i = new Intent(MainActivity.this, InputDataBarang.class);
            startActivity(i);
        }else{
            Toast.makeText(MainActivity.this, "Anda tidak dapat menginput data", Toast.LENGTH_SHORT).show();
        }

        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);

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
        popUpAbout.setContentView(R.layout.pop_up_about);
        LinearLayout layoutWhatsapp = popUpAbout.findViewById(R.id.layout_whatsapp);
        LinearLayout layoutInstagram = popUpAbout.findViewById(R.id.layout_instagram);
        LinearLayout layoutMail = popUpAbout.findViewById(R.id.layout_mail);
        layoutWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact = "+6281808917074"; // use country code with your phone number
                String url = "https://api.whatsapp.com/send?phone=" + contact;
                try {
                    PackageManager pm = getApplicationContext().getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        layoutInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/famfir_");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/famfir_")));
                }
            }
        });
        layoutMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Email : famfir_@hotmail.com", Toast.LENGTH_LONG).show();
            }
        });
        popUpAbout.show();
    }

    @OnClick(R.id.cardLogout)
    void clickLogout(View v){
        Animation animScalein = AnimationUtils.loadAnimation(this, R.anim.anim_scale_in);
        v.startAnimation(animScalein);
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.icon)
                .setTitle("Exit")
                .setMessage("Anda ingin keluar aplikasi?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
