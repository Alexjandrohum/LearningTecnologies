package com.grupopakar.grupopakarapp.ws;

import com.grupopakar.grupopakarapp.dto.ComentarioDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Métodos de ComentariosWS
 * Created by antonio.ruiz on 2019-05-13
 */
public interface ComentariosWS {
    @GET("comentarios")
    Call<List<ComentarioDTO>> getComentarios(@Header("tokenDeUsuario") String token, @Query("idTienda") int idTienda);

    @POST("comentarios/registra")
    Call<MensajeDTO> registraComentario(@Header("tokenDeUsuario") String token, @Body ComentarioDTO info);

    @Multipart
    @POST("upload")
    Call<String> Upload(@Part MultipartBody.Part body, @Query("nombre") String nombre);

    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadArchivo(@Part MultipartBody.Part body, @Query("referencia") String nombre, @Query("socio") String socio);
}
