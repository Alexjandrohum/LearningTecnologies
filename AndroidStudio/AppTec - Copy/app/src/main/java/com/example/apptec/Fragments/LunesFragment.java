package com.example.apptec.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.apptec.Adapters.ReciclerViewAdapter_lunes;
import com.example.apptec.Adapters.SeccionesAdapter;
import com.example.apptec.Api.ObtenerRecursos;
import com.example.apptec.Api.WebServiceApi;
import com.example.apptec.Api.WebServiceJWT;
import com.example.apptec.Clases.ObjetosLunes;
import com.example.apptec.Modelos.ModeloLunes;
import com.example.apptec.Modelos.ModeloToken;
import com.example.apptec.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LunesFragment extends Fragment {

    public static String token;

    View v;
    private RecyclerView myreciclerview;
    private List<ObjetosLunes> lstContact;

    public static String[] datoSemana1;
    public static String[] datoSemana2;
    public static String[] datoSemana3;
    public static String[] datoSemana4;
    public static String[] datoSemana5;
    public static String[] datoSemana6;
    public static String[] datoSemana7;
    public static String[] datoSemana8;
    public static String[] datoSemana9;
    public static int[] datoSemana10;
    public static String[] datoSemana11;
    public static String[] datoSemana12;


    public static int i = 0, contador = 0;


    public LunesFragment() {
        // Required empty public constructor
    }

    public void ObtenerToken(String tok){



        token = tok;


        Log.d("mensaje","Token para semana "+token);

        ModeloToken too2 = new ModeloToken();
        too2.setToken(token);
        Call<List<ModeloLunes>> callSemana = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerLunes(too2);

        callSemana.enqueue(new Callback<List<ModeloLunes>>() {
            @Override
            public void onResponse(Call<List<ModeloLunes>> call, Response<List<ModeloLunes>> response) {
                List<ModeloLunes> semana = response.body();

                datoSemana1 = new String[semana.size()];
                datoSemana2 = new String[semana.size()];
                datoSemana3 = new String[semana.size()];
                datoSemana4 = new String[semana.size()];
                datoSemana5 = new String[semana.size()];
                datoSemana6 = new String[semana.size()];
                datoSemana7 = new String[semana.size()];
                datoSemana8 = new String[semana.size()];
                datoSemana9 = new String[semana.size()];
                datoSemana10 = new int[semana.size()];
                datoSemana11 = new String[semana.size()];
                datoSemana12 = new String[semana.size()];

                //contador = semana.size();
                for (i = 0; i<semana.size(); i++){
                    datoSemana1[i] = semana.get(i).getEstudios();
                    datoSemana2[i] = semana.get(i).getNombre();
                    datoSemana3[i] = semana.get(i).getApep();
                    datoSemana4[i] = semana.get(i).getApem();
                    datoSemana5[i] = semana.get(i).getSalon();
                    datoSemana6[i] = semana.get(i).getMateria();
                    datoSemana7[i] = semana.get(i).getDia();
                    datoSemana8[i] = semana.get(i).getHorain();
                    datoSemana9[i] = semana.get(i).getHorafin();
                    datoSemana10[i] = semana.get(i).getCredito();
                    datoSemana11[i] = semana.get(i).getClavemat();
                    datoSemana12[i] = semana.get(i).getOpcioncur();

                    contador = contador + i;

                    Log.d("tag1","****************************SEMANA");

                    Log.d("Datos","Datos "+i+": "+datoSemana1[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana2[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana3[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana4[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana5[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana6[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana7[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana8[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana9[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana10[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana11[i]);
                    Log.d("Datos","Datos "+i+": "+datoSemana12[i]);




                }



            }

            @Override
            public void onFailure(Call<List<ModeloLunes>> call, Throwable t) {

            }
        });








    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lunes, container, false);

        myreciclerview = (RecyclerView) v.findViewById(R.id.contact_reciclerview_lunes);
        ReciclerViewAdapter_lunes reciclerViewAdapter = new ReciclerViewAdapter_lunes(getContext(),lstContact);
        myreciclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreciclerview.setAdapter(reciclerViewAdapter);
        return v;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstContact = new ArrayList<>();


        for (i = 0; i<contador; i++){
            String ca = Integer.toString(datoSemana10[i]);

         lstContact.add(new ObjetosLunes(datoSemana6[i],datoSemana2[i]+" ", datoSemana3[i]+" ",datoSemana4[i]+" ",datoSemana1[i],ca,datoSemana11[i],datoSemana12[i],datoSemana7[i],datoSemana8[i],datoSemana9[i],datoSemana5[i]));

        }






















    }




}
