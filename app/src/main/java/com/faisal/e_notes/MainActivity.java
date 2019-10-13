package com.faisal.e_notes;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
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

                    String[] TO = {"famfir_@hotmail.com"};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:" + TO));
                    emailIntent.setType("text/plain");


                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "New Opportunity");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        finish();
                        Toast.makeText(MainActivity.this,"Sending Email...", Toast.LENGTH_SHORT).show();
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this,
                                "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
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
}
