package com.grupopakar.grupopakarapp.ws;

import com.grupopakar.grupopakarapp.dto.GpoInfoTiendaDTO;
import com.grupopakar.grupopakarapp.dto.InfoTiendaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InfoTiendaWS {
    /**
     * Info Tienda WS métodos
     */
    @GET("infoTienda")
    Call<List<GpoInfoTiendaDTO>> getInfoTienda(@Header("token") String token, @Query("id") int idTienda);

    @GET("fotoTienda")
    Call<String> getFotoTienda(@Query("id") int idTienda);

    @POST("infoTienda/actualizaInfo")
    Call<MensajeDTO> actualizaInfoTienda(@Header("token") String token, @Body InfoTiendaDTO infoTiendaDTO);
}
