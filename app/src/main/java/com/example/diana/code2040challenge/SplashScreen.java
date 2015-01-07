package com.example.diana.code2040challenge;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Handler;

public class SplashScreen extends Activity {

    //Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
	    	/*
	    	 * showing splash screen w/ timer
	    	 */

            @Override
            public void run() {
                //method executed once timer is over
                //start app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                //close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
