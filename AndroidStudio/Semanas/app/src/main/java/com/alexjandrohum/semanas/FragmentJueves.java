package com.alexjandrohum.semanas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentJueves extends Fragment {

    View v;
    private RecyclerView myreciclerview;
    private List<Jueves> lstContact;

    public FragmentJueves() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.jueves_fragment, container, false);

        myreciclerview = (RecyclerView) v.findViewById(R.id.contact_reciclerview_jueves);
        ReciclerViewAdapter_jueves reciclerViewAdapter = new ReciclerViewAdapter_jueves(getContext(),lstContact);
        myreciclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myreciclerview.setAdapter(reciclerViewAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstContact = new ArrayList<>();

        lstContact.add(new Jueves("Programación web","Damaso", "Canizo","Guzman","Ing.","4","SCA1243","CO","Lunes","08:00","10:00","A20"));
        lstContact.add(new Jueves("Sistemas programables","Juan", "Garcia","Hernandez","Ing.","4","SCA1123","CO","Martes","10:00","11:00","L Elect"));
        lstContact.add(new Jueves("Redes de computadoras","Maricela", "Maqrquez","Cortez","Lic.","5","SEA1123","CO","Martes","11:00","13:00","L Cisco"));
        lstContact.add(new Jueves("Simulación","Ernesto", "Silverio","Flores","Ing.","5","QCA1423","CO","Martes","14:00","16:00","L Sistemas"));
        lstContact.add(new Jueves("Administración de servidores de redes","Ernesto", "Silverio","Florez","Ing.","4","SCA1153","CO","Martes","10:00","11:00","L Cisco"));






    }
}
