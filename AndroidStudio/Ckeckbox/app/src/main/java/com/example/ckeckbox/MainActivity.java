package com.example.ckeckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtxt_number1, edtxt_number2;
    CheckBox checkBox_sumar, checkBox_restar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxt_number1 = (EditText)findViewById(R.id.editText);
        edtxt_number2 = (EditText)findViewById(R.id.editText2);
        checkBox_sumar = (CheckBox)findViewById(R.id.checkBox);
        checkBox_restar = (CheckBox)findViewById(R.id.checkBox2);
        resultado = (TextView)findViewById(R.id.textView);

    }

    public void Calcular(View view){

        int v1 = Integer.parseInt(edtxt_number1.getText().toString());
        int v2 = Integer.parseInt(edtxt_number2.getText().toString());

         String resultado_operacion = " ";
        if (checkBox_sumar.isChecked() == true){

            int operacion_suma = v1 + v2;
            resultado_operacion = " La suma es: "+operacion_suma;

        }

        if (checkBox_restar.isChecked() == true){
            int operacion_resta = v1 - v2;
            resultado_operacion = resultado_operacion+ " La resta es: "+operacion_resta;
        }

        resultado.setText(resultado_operacion);

    }
}
