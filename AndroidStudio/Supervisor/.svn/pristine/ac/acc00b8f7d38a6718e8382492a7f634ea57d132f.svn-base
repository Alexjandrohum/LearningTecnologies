package com.grupopakar.grupopakarapp.ws;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by antonio.ruiz on 2019-05-20
 */
public interface DispositivoWS {
    @POST("dispositivo")
    Call<Void> registraToken(@Header("token") String tokenUser, @Body String tokenFirebase);
}
