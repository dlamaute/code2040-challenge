package com.example.diana.code2040challenge;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setDisplayHomeAsUpEnabled(false);

        Button st1 = (Button)findViewById(R.id.s1button);
        Button st2 = (Button)findViewById(R.id.s2button);
        Button st3 = (Button)findViewById(R.id.s3button);
        Button st4 = (Button)findViewById(R.id.s4button);
        Button results = (Button)findViewById(R.id.resbutton);
        TextView resText = (TextView)findViewById(R.id.resText);

        st1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i1 = new Intent(MainActivity.this, Stage1.class);
                        startActivity(i1);
                        finish();
                    }
                }
        );

        st2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i2 = new Intent(MainActivity.this, Stage2.class);
                        startActivity(i2);
                        finish();
                    }
                }
        );

        st3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i3 = new Intent(MainActivity.this, Stage3.class);
                        startActivity(i3);
                        finish();
                    }
                }
        );

        st4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i4 = new Intent(MainActivity.this, Stage4.class);
                        startActivity(i4);
                        finish();
                    }
                }
        );

        results.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //display results in the textview, resText, assoc with it
                    }
                }
        );

    }
}
