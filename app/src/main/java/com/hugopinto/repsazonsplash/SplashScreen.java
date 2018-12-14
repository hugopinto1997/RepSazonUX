package com.hugopinto.repsazonsplash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SplashScreen extends AppCompatActivity {

   private RelativeLayout relativeLayout, relativeLayoutbelowimg;
   private Handler handler = new Handler();
   private EditText email, password;
   private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        final ViewGroup transition = findViewById(R.id.transition);
        relativeLayout = findViewById(R.id.belowimg);
        relativeLayoutbelowimg = findViewById(R.id.ll_data);
        login = findViewById(R.id.loginbtn);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                TransitionManager.beginDelayedTransition(transition);
                relativeLayoutbelowimg.setVisibility(View.VISIBLE);
            }
        };

        handler.postDelayed(runnable, 2000);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                TransitionManager.beginDelayedTransition(transition);
                startActivity(intent);
                finish();
            }
        });

    }
}
