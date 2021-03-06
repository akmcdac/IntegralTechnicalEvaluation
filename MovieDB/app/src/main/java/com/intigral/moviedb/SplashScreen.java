package com.intigral.moviedb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.intigral.moviedb._activities.MainActivity;


/**
 * Created by Ajay Maurya on 10/3/2017.
 */
public class SplashScreen extends AppCompatActivity {

    // used to know if the back button was pressed in the splash screen activity and avoid opening the next activity
    private boolean mIsBackButtonPressed;
    private static final int SPLASH_DURATION = 3000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();

        // run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // make sure we close the splash screen so the user won't come back when it presses back key
                finish();
                if (!mIsBackButtonPressed) {
                    // start the home screen if the back button wasn't pressed already
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    SplashScreen.this.startActivity(intent);


                }

            }

        }, SPLASH_DURATION); // time in milliseconds (1 second = 1000 milliseconds) until the run() method will be called

    }

    @Override
    public void onBackPressed() {

        // set the flag to true so the next activity won't start up
        mIsBackButtonPressed = true;
        super.onBackPressed();

    }
}
