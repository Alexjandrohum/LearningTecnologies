package com.example.conectarapi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.conectarapi.api.ModeloLogin;
import com.example.conectarapi.api.ModeloPerfil;
import com.example.conectarapi.api.ModeloToken;
import com.example.conectarapi.api.WebServiceApi;
import com.example.conectarapi.api.WebServiceJWT;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragment extends Fragment {


    public static List<ModeloPerfil> perfil;


    public PerfilFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);








    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }


}
