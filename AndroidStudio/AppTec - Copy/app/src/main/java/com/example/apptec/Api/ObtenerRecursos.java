package com.example.apptec.Api;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.example.apptec.Fragments.HoyFragment;
import com.example.apptec.Fragments.LunesFragment;
import com.example.apptec.Fragments.PerfilFragment;
import com.example.apptec.Modelos.ModeloHoy;
import com.example.apptec.Modelos.ModeloLogin;
import com.example.apptec.Modelos.ModeloLunes;
import com.example.apptec.Modelos.ModeloPerfil;
import com.example.apptec.Modelos.ModeloToken;
import com.example.apptec.Pantallas.Logeo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ObtenerRecursos {

    public static int matricula;
    public static String password;
    public static String token;

    public static int estado;


    public void DatosLogeo(int mat, String pass){

        matricula = mat;
        password = pass;


    }

    public void obtenerTokenn(String top){
        token = top;

        obtenerRecursoPerfil();

    }






    public void obtenerToken() {

        Log.d("mensaje","Matricula: "+matricula+" Contraseña: "+password);


        ModeloLogin mod = new ModeloLogin();
        mod.setMatricula(matricula);
        mod.setContrasena(password);
        Call<List<String>> call = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerToken(mod);

        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.code() == 200) {
                    //tokenn = response.body().toString();
                    token = response.body().get(0).toString();
                    Log.d("TAG1", "El token es: " + token);

                   obtenerRecursoPerfil();
                    //obtenerRecursoSemana();
                    //obtenerRecursoDia();

                    estado = 200;


                    LunesFragment lunesFragment = new LunesFragment();
                    lunesFragment.ObtenerToken(token);





                } else if (response.code() == 401) {
                    Log.d("Tag1", "No autorizado");

                    estado = 401;




                } else {
                    Log.d("Tag1", "No obtenido Token");


                }





            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("Error: ", "" + t);
                estado = 500;

            }
        });




    }


    public void obtenerRecursoDia(){
        ModeloToken tookDia = new ModeloToken();
        tookDia.setToken(token);
        Call<List<ModeloHoy>> callDia = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerDia(tookDia);

        callDia.enqueue(new Callback<List<ModeloHoy>>() {
            @Override
            public void onResponse(Call<List<ModeloHoy>> call, Response<List<ModeloHoy>> response) {
                List<ModeloHoy> dia = response.body();

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
            public void onFailure(Call<List<ModeloHoy>> call, Throwable t) {

            }
        });
    }



    public void obtenerRecursoSemana(){

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

                /*String took = tokenn;
                String dat1 = datoSemana1[0];

                Log.d("datos","############## ############### "+dat1);

                FragmentHoy frahoy = new FragmentHoy();

                frahoy.ObtenerDatos(dat1);*/



            }

            @Override
            public void onFailure(Call<List<ModeloLunes>> call, Throwable t) {

            }
        });


    }


    public void obtenerRecursoPerfil(){
        ModeloToken too = new ModeloToken();
        too.setToken(token);
        Call<List<ModeloPerfil>> callPerfil = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerPerfil(too);


        callPerfil.enqueue(new Callback<List<ModeloPerfil>>() {
            @Override
            public void onResponse(Call<List<ModeloPerfil>> call, Response<List<ModeloPerfil>> response) {

                List<ModeloPerfil> perfil = response.body();

                int dat1 =  perfil.get(0).getMatricula();
                String dat2 = perfil.get(0).getNom();
                String dat3 = perfil.get(0).getAm();
                String dat4 =  perfil.get(0).getAp();
                String dat5 =  perfil.get(0).getGru();
                String dat6 =  perfil.get(0).getSem();
                String dat7 =  perfil.get(0).getCar();

                /*Log.d("saf","=================== "+dat1);
                Log.d("saf","=================== "+dat2);
                Log.d("saf","=================== "+dat3);
                Log.d("saf","=================== "+dat4);
                Log.d("saf","=================== "+dat5);
                Log.d("saf","=================== "+dat6);
                Log.d("saf","=================== "+dat7);*/

                PerfilFragment objPerfil = new PerfilFragment();
                objPerfil.obteniendoDaos(dat1,dat2,dat3,dat4,dat5,dat6,dat7);




            }

            @Override
            public void onFailure(Call<List<ModeloPerfil>> call, Throwable t) {

            }
        });






    }




    }
