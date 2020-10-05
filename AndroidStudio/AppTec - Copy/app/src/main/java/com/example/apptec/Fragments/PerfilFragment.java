package com.example.apptec.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apptec.Api.ObtenerRecursos;
import com.example.apptec.Clases.ObjetosPerfil;
import com.example.apptec.R;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    RecyclerView reciclerPerfil;
    ArrayList<ObjetosPerfil> listaPerfil;

    private static int matt;
    private static String nombre, app, apm, gra, se, ca;


    public PerfilFragment() {
        // Required empty public constructor
    }

    public void obteniendoDaos(int a, String dat2, String dat3, String dat4, String dat5, String dat6,String dat7){

        matt = a;
        nombre = dat2;
        app = dat3;
        apm = dat4;
        gra = dat5;
        se = dat6;
        ca = dat7;


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

        TextView nombreText,matriculaText, gradoText,semestreText, carreraText;

        View vista =inflater.inflate(R.layout.fragment_perfil, container, false);

       /* listaPerfil = new ArrayList<>();

        reciclerPerfil = vista.findViewById(R.id.recicler_id);
        reciclerPerfil.setLayoutManager(new LinearLayoutManager(getContext()));
        reciclerPerfil.setHasFixedSize(true);*/

        nombreText = vista.findViewById(R.id.nombre);
        matriculaText = vista.findViewById(R.id.matricula);
        gradoText = vista.findViewById(R.id.grado);
        //semestreText = vista.findViewById(R.id.semestre);
        carreraText = vista.findViewById(R.id.carrera);

        nombreText.setText(nombre+" "+app+" "+apm);

        String cad = Integer.toString(matt);
        matriculaText.setText(cad);
        gradoText.setText("Grupo: "+gra+"    "+se+" Semestre");
       // semestreText.setText(se);
        carreraText.setText(ca);

        //llenarLista();
        return vista;
    }


}
