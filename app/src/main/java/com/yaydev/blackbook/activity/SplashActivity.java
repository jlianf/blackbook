package com.yaydev.blackbook.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yaydev.blackbook.Configs;
import com.yaydev.blackbook.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Configs configs = new Configs(this);

        getWindow().setStatusBarColor(getResources().getColor(configs.getColor()));

        RelativeLayout splash = findViewById(R.id.splash);
        ImageView image = findViewById(R.id.splash_image);

        splash.setBackgroundColor(getResources().getColor(configs.getColor()));
        image.setImageResource(configs.getSplashIcon());

        Handler handler = new Handler();
        Runnable runnable = () -> {
            Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
            startActivity(intent);
            finish();
        };

        handler.postDelayed(runnable, 3000);
    }
}