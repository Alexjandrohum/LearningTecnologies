package com.grupopakar.grupopakarapp.ws;

import com.grupopakar.grupopakarapp.dto.TiendaDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface TiendaWS {
    /**
     * Tiendas WS métodos
     */
    @GET("tiendas/cercanas")
    Call<List<TiendaDTO>> getTiendasCercanas(@Header("tokenDeUsuario") String token, @Query("lat") String latitud,
                                             @Query("lon") String longitud);

    @GET("tiendas/buscaTienda")
    Call<List<TiendaDTO>> buscaTiendas(@Header("tokenDeUsuario") String token, @Query("dc") String descripcion);
}
