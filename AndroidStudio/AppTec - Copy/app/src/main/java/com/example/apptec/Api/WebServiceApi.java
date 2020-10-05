package com.example.apptec.Api;

import com.example.apptec.Modelos.ModeloHoy;
import com.example.apptec.Modelos.ModeloJueves;
import com.example.apptec.Modelos.ModeloLogin;
import com.example.apptec.Modelos.ModeloLunes;
import com.example.apptec.Modelos.ModeloMartes;
import com.example.apptec.Modelos.ModeloMiercoles;
import com.example.apptec.Modelos.ModeloPerfil;
import com.example.apptec.Modelos.ModeloSabado;
import com.example.apptec.Modelos.ModeloToken;
import com.example.apptec.Modelos.ModeloViernes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WebServiceApi {

    @POST("/api/login/authenticate")
    Call<List<String>> obtenerToken(@Body ModeloLogin modeloLogin);

    @POST("/api/horario/dia")
    Call<List<ModeloHoy>>obtenerDia(@Body ModeloToken modeloToken);



    @POST("/api/horario/lunes")
    Call<List<ModeloLunes>> obtenerLunes(@Body ModeloToken modeloToken);

    @POST("/api/horario/martes")
    Call<List<ModeloMartes>> obtenerMartes(@Body ModeloToken modeloToken);

    @POST("/api/horario/miercoles")
    Call<List<ModeloMiercoles>> obtenerMiercoles(@Body ModeloToken modeloToken);

    @POST("/api/horario/jueves")
    Call<List<ModeloJueves>> obtenerJueves(@Body ModeloToken modeloToken);

    @POST("/api/horario/viernes")
    Call<List<ModeloViernes>> obtenerViernes(@Body ModeloToken modeloToken);

    @POST("/api/horario/sabado")
    Call<List<ModeloSabado>> obtenerSabado(@Body ModeloToken modeloToken);



    @POST("/api/horario/Lunes")
    Call<List<ModeloLunes>>obtenerLista(@Body ModeloToken modeloToken);

    @POST("/api/perfil/alumno")
    Call<List<ModeloPerfil>> obtenerPerfil(@Body ModeloToken modeloToken);


}
