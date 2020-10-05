package com.grupopakar.grupopakarapp.ws;

import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.PlantillaDTO;
import com.grupopakar.grupopakarapp.dto.ValidaPlantillaDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Métodos de PlantillaWS
 * Created by antonio.ruiz on 2019-05-10
 */
public interface PlantillaWS {
    @GET("plantilla")
    Call<PlantillaDTO> getPlantilla(@Header("tokenDeUsuario") String token, @Query("idTienda") int idTienda);

    @POST("plantilla/validar")
    Call<MensajeDTO> validaPlantilla(@Header("tokenDeUsuario") String token, @Body ValidaPlantillaDTO validacion);
}
