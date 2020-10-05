package com.example.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
    }

    public void Guardar(View view){

        String name = editText1.getText().toString();
        String datos = editText2.getText().toString();


        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(name, datos);
        obj_editor.commit();

        Toast.makeText(this, "Rl contacto ha suido gaurdar", Toast.LENGTH_LONG).show();

    }

    public void Buscar(View view){

        String name = editText1.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferences.getString(name, "");

        if (datos.length() == 0){
            Toast.makeText(this, "No se encontró el usuario", Toast.LENGTH_LONG).show();
        }else{
            editText2.setText(datos);

        }




    }

    public void ir(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
