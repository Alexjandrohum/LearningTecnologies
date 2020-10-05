package com.example.conectarapi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class PruebaFragment extends Fragment {

    private static int matt;
    private static String nombre, app, apm, gra, se, ca;


    public PruebaFragment() {
        // Required empty public constructor
    }

    public void cachando(int a, String dat2, String dat3, String dat4, String dat5, String dat6,String dat7){

        matt = a;
        nombre = dat2;
        app = dat3;
        apm = dat4;
        gra = dat5;
        se = dat6;
        ca = dat7;




        //Toast.makeText(getContext(),"Obtenido dato del método "+matt,Toast.LENGTH_LONG).show();


    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        Log.d("Mensaje","Matricula################3 "+matt);
        Log.d("Mensaje","Nombre################3 "+nombre);
        Log.d("Mensaje","Paterno################3 "+app);
        Log.d("Mensaje","Materno################3 "+apm);
        Log.d("Mensaje","Grado################3 "+gra);
        Log.d("Mensaje","Semestre################3 "+se);
        Log.d("Mensaje","Carrera################3 "+ca);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_prueba, container, false);
    }


}
