package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text_correcto, txt_sinacceso, txt_advertencia, txt_incorrecto;
    LayoutInflater inflater;
    View layout_correcto, layout_sinacceso, layout_advertencia, layout_incorrecto;
    ImageView img_correcto, img_incorrecto, img_advertencia, img_sinacceso;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater = getLayoutInflater();

        layout_correcto = inflater.inflate(R.layout.toast_personalizado,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        layout_sinacceso = inflater.inflate(R.layout.toast_incorrecto,
                (ViewGroup)findViewById(R.id.toast_layout_incorrecto));
        layout_advertencia = inflater.inflate(R.layout.toast_advertencia,
                (ViewGroup)findViewById(R.id.totas_layout_advertencia));
        layout_incorrecto = inflater.inflate(R.layout.toast_error,
                (ViewGroup)findViewById(R.id.toast_layout_error));

        img_correcto = (ImageView) layout_correcto.findViewById(R.id.image);
        img_sinacceso = (ImageView)layout_sinacceso.findViewById(R.id.img_incorrecto);
        img_advertencia = (ImageView)layout_advertencia.findViewById(R.id.img_advertencia);
        img_incorrecto = (ImageView)layout_incorrecto.findViewById(R.id.img_error);

        text_correcto = (TextView) layout_correcto.findViewById(R.id.text);
        txt_sinacceso = (TextView)layout_sinacceso.findViewById(R.id.incorrecto);
        txt_advertencia = (TextView)layout_advertencia.findViewById(R.id.txt_advertencia);
        txt_incorrecto = (TextView)layout_incorrecto.findViewById(R.id.txt_error);

    }

    public void Correcto(View view){

        img_correcto.setImageResource(R.drawable.ja);
        text_correcto.setText("Todo ha salido correctamente!");

        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout_correcto);
        toast.show();

    }


    public void SinAcceso(View view){

        img_sinacceso.setImageResource(R.drawable.incorrecto);
        txt_sinacceso.setText("Lo sentimos el servicio está inactivo.");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout_sinacceso);
        toast.show();
    }

    public void Advertencia(View view){

        img_advertencia.setImageResource(R.drawable.advertencia);
        txt_advertencia.setText("Ingresa todos tus datos.");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout_advertencia);
        toast.show();
    }

    public void Errores(View view){

        img_incorrecto.setImageResource(R.drawable.error);
        txt_incorrecto.setText("Tus datos son incorrectos");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout_incorrecto);
        toast.show();
    }
}
