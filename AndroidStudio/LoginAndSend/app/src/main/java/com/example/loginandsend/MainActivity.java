package com.example.loginandsend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user, contra;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.idCorreo);
        contra = findViewById(R.id.contra);
        enviar = findViewById(R.id.envio);

        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario = user.getText().toString();
        String password = contra.getText().toString();

        if (usuario.isEmpty()){
            user.setError("Ingresa tu correo.");
        }

        if (password.isEmpty()){
            contra.setError("Ingresa tu contraseña.");
        }

        if (!usuario.isEmpty() && !password.isEmpty()){
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("keyUser",usuario);
            intent.putExtra("keyPass",password);
            startActivity(intent);
        }
    }
}
