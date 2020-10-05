package com.example.enviarparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        textView = (TextView)findViewById(R.id.textView);

        String dato = getIntent().getStringExtra("dato");

        textView.setText("Saludos "+dato);
    }

    public void Atras(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
