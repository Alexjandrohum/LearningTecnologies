package com.alexjandrohum.semanas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alexjandrohum.semanas.api.ModeloDia;
import com.alexjandrohum.semanas.api.ModeloLunes;
import com.alexjandrohum.semanas.api.ModeloToken;
import com.alexjandrohum.semanas.api.ObtenerDatos;
import com.alexjandrohum.semanas.api.WebServiceApi;
import com.alexjandrohum.semanas.api.WebServiceJWT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class FragmentHoy extends Fragment {

    View v;
    private RecyclerView myreciclerview;
    private List<Hoy> lstContact;


    public static String dato;


    public FragmentHoy() { }


    public void ObtenerDatos(String d){
        dato = d;

    }



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();

        Log.d("ja","############### Mirando el cargo "+dato);

        //lstContact.add(new Hoy(modeloDia1[i],modeloDia2[i], modeloDia3[i],modeloDia4[i],modeloDia5[i],modeloDia6[i],modeloDia7[i],modeloDia8[i],"Lunes","08:00","10:00","A20"));
        lstContact.add(new Hoy(dato,"Juan", "Garcia","Hernandez","Ing.","4","SCA1123","CO","Lunes","10:00","11:00","L Elect"));
        lstContact.add(new Hoy("Redes de computadoras","Maricela", "Maqrquez","Cortez","Lic.","5","SEA1123","CO","Lunes","11:00","13:00","L Cisco"));
        lstContact.add(new Hoy("Simulación","Ernesto", "Silverio","Flores","Ing.","5","QCA1423","CO","Lunes","14:00","16:00","L Sistemas"));
        lstContact.add(new Hoy("Administración de servidores de redes","Ernesto", "Silverio","Florez","Ing.","4","SCA1153","CO","Lunes","16:00","17:00","L Cisco"));





    }





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.hoy_fragment, container, false);

        myreciclerview = (RecyclerView) v.findViewById(R.id.contact_reciclerview_hoy);
        ReciclerViewAdapter_hoy reciclerViewAdapter = new ReciclerViewAdapter_hoy(getContext(),lstContact);
        myreciclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreciclerview.setAdapter(reciclerViewAdapter);


        return v;
    }






}
