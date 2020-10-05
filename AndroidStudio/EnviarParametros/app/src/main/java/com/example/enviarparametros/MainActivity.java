package com.example.enviarparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);


    }

    public void Enviar(View view){

        String dato = editText.getText().toString();

        Intent intent = new Intent(this, Mostrar.class);
        intent.putExtra("dato", dato);
        startActivity(intent);

    }
}
