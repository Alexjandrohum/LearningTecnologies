package com.example.conectarapi.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebServiceApi {

    @POST("/api/login/authenticate")
    Call<List<String>> obtenerToken(@Body ModeloLogin modeloLogin);



    @POST("/api/perfil/alumno")
    Call<List<ModeloPerfil>> obtenerPerfil(@Body ModeloToken modeloToken);

}
