package com.example.toastsnackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnToast, btnSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.buttonToast);
        btnSnackbar = findViewById(R.id.buttonSnackbar);

        btnToast.setOnClickListener(this);
        btnSnackbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonToast){
            Toast.makeText(this, "Mostrando Toast", Toast.LENGTH_SHORT).show();
        }else if (v.getId() == R.id.buttonSnackbar){
            Snackbar.make(v, "Mostrando SnackBar", Snackbar.LENGTH_SHORT).show();
        }

    }
}
