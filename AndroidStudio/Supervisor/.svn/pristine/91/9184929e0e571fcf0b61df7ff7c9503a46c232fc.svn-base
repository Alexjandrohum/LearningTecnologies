package com.grupopakar.grupopakarapp.ws;

import com.grupopakar.grupopakarapp.dto.CredencialesDTO;
import com.grupopakar.grupopakarapp.dto.UsuarioDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginWS {
    /**
     * Login WS métodos
     */
    @POST("login")
    Call<UsuarioDTO> login(@Body CredencialesDTO credenciales);
}
