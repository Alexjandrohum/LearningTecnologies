package com.grupopakar.grupopakarapp.ws;

import com.grupopakar.grupopakarapp.dto.ActividadDTO;
import com.grupopakar.grupopakarapp.dto.InfoTareaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Métodos de TareaWS
 * Created by antonio.ruiz on 2019-05-13
 */
public interface TareaWS {
    @GET("tareas")
    Call<List<ActividadDTO>> getTareas(@Header("tokenDeUsuario") String token, @Query("idTienda") int idTienda);

    @POST("tareas/actualizaEstatus")
    Call<MensajeDTO> actualizaEstatusTarea(@Header("token") String token, @Body InfoTareaDTO infoTarea);
}
