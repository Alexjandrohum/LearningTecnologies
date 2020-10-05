package com.example.progressbar;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


import com.github.ybq.android.spinkit.style.Wave;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button invisible, visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.Skin);
        invisible = (Button)findViewById(R.id.button);
        visible = (Button)findViewById(R.id.visible);
        progressBar.setVisibility(View.INVISIBLE);
        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wave wave = new Wave();
                progressBar.setVisibility(View.VISIBLE);
            }
        });




        invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(),Logeo.class);
                //startActivity(intent);
            }
        });

    }
}
