package com.example.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText number1, number2;
    private RadioButton sumar, restar;
    private Button realizar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view){

        number1 = (EditText)findViewById(R.id.editText1);
        number2 = (EditText)findViewById(R.id.editText2);
        sumar = (RadioButton)findViewById(R.id.radioButton1);
        restar = (RadioButton)findViewById(R.id.radioButton2);

        String valor_string1 = number1.getText().toString();
        String valor_string2 = number2.getText().toString();

        int valor_entero1 = Integer.parseInt(valor_string1);
        int valor_entero2 = Integer.parseInt(valor_string2);

        if (sumar.isChecked() == true){

            int resultado_suma = valor_entero1 + valor_entero2;
            resultado.setText(resultado_suma);

        }else if (restar.isChecked() == true){

            int resultado_resta = valor_entero1 - valor_entero2;
            resultado.setText(resultado_resta);
        }
    }
}
