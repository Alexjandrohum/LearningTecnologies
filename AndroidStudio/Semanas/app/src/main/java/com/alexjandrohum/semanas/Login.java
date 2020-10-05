package com.alexjandrohum.semanas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.alexjandrohum.semanas.api.ModeloDia;
import com.alexjandrohum.semanas.api.ModeloLogin;
import com.alexjandrohum.semanas.api.ModeloLunes;
import com.alexjandrohum.semanas.api.ModeloPerfil;
import com.alexjandrohum.semanas.api.ModeloToken;
import com.alexjandrohum.semanas.api.ObtenerDatos;
import com.alexjandrohum.semanas.api.WebServiceApi;
import com.alexjandrohum.semanas.api.WebServiceJWT;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {




    EditText edtx_Matricula, edtx_Contrasena;
    Button btn_iniciar;
    TextView titulo;


    public static  String tokenn0;
    public static String resp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpView();
    }

    private void setUpView(){

        edtx_Matricula = (EditText)findViewById(R.id.matricula);
        edtx_Contrasena = (EditText)findViewById(R.id.password);
        btn_iniciar = (Button)findViewById(R.id.iniciar);

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerToken();


            }
        });

    }

    private void obtenerRecursoDia(){
        ModeloToken tookDia = new ModeloToken();
        tookDia.setToken(tokenn0);
        Call<List<ModeloDia>> callDia = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerDia(tookDia);

        callDia.enqueue(new Callback<List<ModeloDia>>() {
            @Override
            public void onResponse(Call<List<ModeloDia>> call, Response<List<ModeloDia>> response) {
                List<ModeloDia> dia = response.body();

                String[] modeloDia1 = new String[dia.size()];
                String[] modeloDia2 = new String[dia.size()];
                String[] modeloDia3 = new String[dia.size()];
                String[] modeloDia4 = new String[dia.size()];
                String[] modeloDia5 = new String[dia.size()];
                String[] modeloDia6 = new String[dia.size()];
                String[] modeloDia7 = new String[dia.size()];
                String[] modeloDia8 = new String[dia.size()];


                for (int i = 0; i<dia.size(); i++){

                    modeloDia1[i] = dia.get(i).getSalon();
                    modeloDia2[i] = dia.get(i).getMat();
                    modeloDia3[i] = dia.get(i).getHorain();
                    modeloDia4[i] = dia.get(i).getHorafin();
                    modeloDia5[i] = dia.get(i).getStud();
                    modeloDia6[i] = dia.get(i).getNom();
                    modeloDia7[i] = dia.get(i).getApp();
                    modeloDia8[i] = dia.get(i).getApm();

                    Log.d("tag1","****************************Hoy");

                    Log.d("Datos","Datos "+i+": "+modeloDia1[i]);
                    Log.d("Datos","Datos "+i+": "+modeloDia2[i]);
                    Log.d("Datos","Datos "+i+": "+modeloDia3[i]);
                    Log.d("Datos","Datos "+i+": "+modeloDia4[i]);
                    Log.d("Datos","Datos "+i+": "+modeloDia5[i]);
                    Log.d("Datos","Datos "+i+": "+modeloDia6[i]);
                    Log.d("Datos","Datos "+i+": "+modeloDia7[i]);
                    Log.d("Datos","Datos "+i+": "+modeloDia8[i]);



                }

            }

            @Override
            public void onFailure(Call<List<ModeloDia>> call, Throwable t) {

            }
        });
    }



    private void obtenerRecursoSemana(){

        ModeloToken too2 = new ModeloToken();
        too2.setToken(tokenn0);
        Call<List<ModeloLunes>> callSemana = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerLunes(too2);

        callSemana.enqueue(new Callback<List<ModeloLunes>>() {
            @Override
            public void onResponse(Call<List<ModeloLunes>> call, Response<List<ModeloLunes>> response) {
                List<ModeloLunes> semana = response.body();

                String[] datoSemana1 = new String[semana.size()];
                String[] datoSemana2 = new String[semana.size()];
                String[] datoSemana3 = new String[semana.size()];
                String[] datoSemana4 = new String[semana.size()];
                String[] datoSemana5 = new String[semana.size()];
                String[] datoSemana6 = new String[semana.size()];
                String[] datoSemana7 = new String[semana.size()];
                String[] datoSemana8 = new String[semana.size()];
                String[] datoSemana9 = new String[semana.size()];
                int[] datoSemana10 = new int[semana.size()];
                String[] datoSemana11 = new String[semana.size()];
                String[] datoSemana12 = new String[semana.size()];

                for (int i = 0; i<semana.size(); i++){
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

                String took = tokenn0;
                String dat1 = datoSemana1[0];

                Log.d("datos","############## ############### "+dat1);

                FragmentHoy frahoy = new FragmentHoy();

                frahoy.ObtenerDatos(dat1);



            }

            @Override
            public void onFailure(Call<List<ModeloLunes>> call, Throwable t) {

            }
        });


    }


    private void obtenerRecursoPerfil(){
        ModeloToken too = new ModeloToken();
        too.setToken(tokenn0);
        Call<List<ModeloPerfil>> callPerfil = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerPerfil(too);


        callPerfil.enqueue(new Callback<List<ModeloPerfil>>() {
            @Override
            public void onResponse(Call<List<ModeloPerfil>> call, Response<List<ModeloPerfil>> response) {

                List<ModeloPerfil> perfil = response.body();



                int[] idPErfil1 = new int[perfil.size()];
                String[] idPErfil2 = new String[perfil.size()];
                String[] idPErfil3 = new String[perfil.size()];
                String[] idPErfil4 = new String[perfil.size()];
                String[] idPErfil5 = new String[perfil.size()];
                String[] idPErfil6 = new String[perfil.size()];
                String[] idPErfil7 = new String[perfil.size()];

                for (int i = 0; i<perfil.size(); i++){

                    idPErfil1[i] = perfil.get(i).getMatricula();
                    idPErfil2[i] = perfil.get(i).getNom();
                    idPErfil3[i] = perfil.get(i).getAp();
                    idPErfil4[i] = perfil.get(i).getAm();
                    idPErfil5[i] = perfil.get(i).getGru();
                    idPErfil6[i] = perfil.get(i).getSem();
                    idPErfil7[i] = perfil.get(i).getCar();

                    Log.d("Datos","Datos "+i+": "+idPErfil1[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil2[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil3[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil4[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil5[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil6[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil7[i]);
                }

            }

            @Override
            public void onFailure(Call<List<ModeloPerfil>> call, Throwable t) {

            }
        });






    }

    private void obtenerToken(){

        int mat = Integer.parseInt(edtx_Matricula.getText().toString());

        ModeloLogin mod=new ModeloLogin();
        mod.setMatricula(mat);
        mod.setContrasena(edtx_Contrasena.getText().toString());
        Call<List<String>> call = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerToken(mod);

        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.code()==200){
                    //tokenn = response.body().toString();
                    tokenn0 = response.body().get(0).toString();
                    Log.d("TAG1","El token es: "+tokenn0);

                    obtenerRecursoPerfil();
                    obtenerRecursoSemana();
                    obtenerRecursoDia();


                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);






                }else  if (response.code()==401){
                    Log.d("Tag1","No autorizado");
                }else{
                    Log.d("Tag1","No obtenido Token");
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("Error: ",""+t);

            }
        });



    }

}