package com.grupopakar.grupopakarapp.dao;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.ComentariosContract;
import com.grupopakar.grupopakarapp.dto.ComentarioDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.util.Factory;
import com.grupopakar.grupopakarapp.util.MyApplication;
import com.grupopakar.grupopakarapp.ws.ComentariosWS;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by antonio.ruiz on 2019-05-13
 */
public class ComentariosDAOImpl implements ComentariosContract.ComentariosDAO {
    private final ComentariosWS service;
    private Call<String> callImage;

    public ComentariosDAOImpl() {
        service = (ComentariosWS) Factory.getWS(ComentariosWS.class);
    }

    @Override
    public void cargaDatos(String token, int idTienda, final OnFinishedListener onFinishedListener) {
        Call<List<ComentarioDTO>> call = service.getComentarios(token, idTienda);

        call.enqueue(new Callback<List<ComentarioDTO>>() {
            @Override
            public void onResponse(Call<List<ComentarioDTO>> call, Response<List<ComentarioDTO>> response) {
                switch (response.code()) {
                    case 200: // Ejecucion exitosa
                        onFinishedListener.onFinished(response.body());
                        break;
                    case 401: // Token invalido
                        try {
                            if (response.errorBody() != null) {
                                onFinishedListener.onFailureToken(new Gson().fromJson(response.errorBody().string(), MensajeDTO.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 404: // No existe informacion
                        try {
                            if (response.errorBody() != null) {
                                onFinishedListener.onFailure(new Gson().fromJson(response.errorBody().string(), MensajeDTO.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        onFinishedListener.onFailure(new MensajeDTO(MyApplication.getRes().getString(R.string.error_inesperado)));
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<ComentarioDTO>> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }

    @Override
    public void registraComentario(String token, ComentarioDTO comentario, final OnFinishedListener onFinishedListener) {
        Call<MensajeDTO> call = service.registraComentario(token, comentario);

        call.enqueue(new Callback<MensajeDTO>() {
            @Override
            public void onResponse(Call<MensajeDTO> call, Response<MensajeDTO> response) {
                switch (response.code()) {
                    case 200: // Ejecucion exitosa
                        onFinishedListener.onFinished(response.body());
                        break;
                    case 400: // error actualizacion
                        try {
                            if (response.errorBody() != null) {
                                onFinishedListener.onFailure(new Gson().fromJson(response.errorBody().string(), MensajeDTO.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 401: // Token invalido
                        try {
                            if (response.errorBody() != null) {
                                onFinishedListener.onFailureToken(new Gson().fromJson(response.errorBody().string(), MensajeDTO.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        onFinishedListener.onFailure(new MensajeDTO(MyApplication.getRes().getString(R.string.error_inesperado)));
                        break;
                }
            }

            @Override
            public void onFailure(Call<MensajeDTO> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }

    @Override
    public void cargaImagen(String path, String nombre, final OnFinishedListener listener) {
        File file = new File(path);
        RequestBody Filebody = RequestBody.create(okhttp3.MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part FileName = MultipartBody.Part.createFormData("archivo", file.getName(), Filebody);

        Call<ResponseBody> callImage = service.uploadArchivo(FileName, nombre,"socio");
        callImage.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    listener.onFinishedImagen("Correcto");
                } else {
                    listener.onFinishedImagen(response.message());
                    System.out.println("Failure Response: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("Failure .cargaImagen: " + t.getMessage());
                listener.onFinishedImagen(t.getMessage());
            }
        });
    }
}