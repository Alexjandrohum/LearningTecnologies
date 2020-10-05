package com.example.loginandsend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView Mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Mensaje = findViewById(R.id.ver);

        Bundle bundle = getIntent().getExtras();

        String user = bundle.getString("keyUser");
        String contra = bundle.getString("keyPass");

        Mensaje.setText("Hola, buenos días: "+user+" con coontraseña: "+contra);
    }
}
