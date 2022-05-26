package com.example.CareFoMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splash_actitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actitvity);

        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run() {
                startActivity(new Intent(splash_actitvity.this, MainPage.class));


            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,5000);
    }
    }

