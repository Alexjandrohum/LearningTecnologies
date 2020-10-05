package com.example.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText edtxt1, edtxt2;
    TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        edtxt1 = (EditText)findViewById(R.id.editText);
        edtxt2 = (EditText)findViewById(R.id.editText2);
        r = (TextView)findViewById(R.id.textView);

        String [] opciones = {"Sumar","Restar"};

        //ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, opciones);
        spinner.setAdapter(adapter);
    }

    public void Calcular(View view){

        int valor1 = Integer.parseInt(edtxt1.getText().toString());
        int valor2 = Integer.parseInt(edtxt2.getText().toString());

        String seleccion = spinner.getSelectedItem().toString();

        if (seleccion.equals("Sumar")){
            int opera_sumar = valor1 + valor2;
            String r1 = String.valueOf(opera_sumar);
            r.setText(r1);

        }else if(seleccion.equals("Restar")){
            int opera_restar = valor1 - valor2;
            String r2 = String.valueOf(opera_restar);
            r.setText(r2);
        }


    }
}
