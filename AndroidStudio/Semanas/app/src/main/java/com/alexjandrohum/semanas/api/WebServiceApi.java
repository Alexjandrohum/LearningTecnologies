package com.alexjandrohum.semanas.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface WebServiceApi {

    @POST("/api/login/authenticate")
    Call<List<String>> obtenerToken(@Body ModeloLogin modeloLogin);

    @POST("/api/horario/dia")
    Call<List<ModeloDia>>obtenerDia(@Body ModeloToken modeloToken);



    @POST("/api/horario/lunes")
    Call<List<ModeloLunes>> obtenerLunes(@Body ModeloToken modeloToken);

    @POST("/api/horario/martes")
    Call<List<ModeloLunes>> obtenerMartes(@Body ModeloToken modeloToken);

    @POST("/api/horario/miercoles")
    Call<List<ModeloLunes>> obtenerMiercoles(@Body ModeloToken modeloToken);

    @POST("/api/horario/jueves")
    Call<List<ModeloLunes>> obtenerJueves(@Body ModeloToken modeloToken);

    @POST("/api/horario/viernes")
    Call<List<ModeloLunes>> obtenerViernes(@Body ModeloToken modeloToken);

    @POST("/api/horario/sabado")
    Call<List<ModeloLunes>> obtenerSabado(@Body ModeloToken modeloToken);



    @POST("/api/horario/Lunes")
    Call<List<ModeloLunes>>obtenerLista(@Body ModeloToken modeloToken);

    @POST("/api/perfil/alumno")
    Call<List<ModeloPerfil>> obtenerPerfil(@Body ModeloToken modeloToken);



}
