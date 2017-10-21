package com.juan.arrivedrivers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_DELAY=3000;
    int inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        SharedPreferences prefs = getSharedPreferences("Preferences1",0);
        SharedPreferences.Editor editor= prefs.edit();
        inicio= prefs.getInt("inicio1",inicio);


        TimerTask task= new TimerTask() {
            @Override
            public void run() {
                if(inicio==1) {
                    Intent intent= new Intent(SplashActivity.this,BaseActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(inicio==0){
                    Intent intent= new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        };

        Timer timer= new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }
}
