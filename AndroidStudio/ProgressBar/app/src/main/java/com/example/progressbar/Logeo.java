package com.example.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import net.steamcrafted.loadtoast.LoadToast;

public class Logeo extends AppCompatActivity {

    Button succes, error, hig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo);

        succes = (Button)findViewById(R.id.success);
        error = (Button)findViewById(R.id.error);
        hig = (Button)findViewById(R.id.hide);

        final LoadToast loadToast = new LoadToast(Logeo.this);

        succes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadToast.success();
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadToast.error();
            }
        });

        hig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadToast.setText("Cargando...");
                loadToast.setTranslationY(250);
                loadToast.show();
            }
        });
    }
}
