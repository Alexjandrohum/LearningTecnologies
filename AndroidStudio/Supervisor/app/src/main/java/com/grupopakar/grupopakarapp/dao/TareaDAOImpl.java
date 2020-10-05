package com.grupopakar.grupopakarapp.dao;

import com.google.gson.Gson;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.TareaContract;
import com.grupopakar.grupopakarapp.dto.ActividadDTO;
import com.grupopakar.grupopakarapp.dto.InfoTareaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.util.Factory;
import com.grupopakar.grupopakarapp.util.MyApplication;
import com.grupopakar.grupopakarapp.ws.TareaWS;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by antonio.ruiz on 2019-05-13
 */
public class TareaDAOImpl implements TareaContract.TareaDAO {
    private final TareaWS service;

    public TareaDAOImpl() {
        service = (TareaWS) Factory.getWS(TareaWS.class);
    }

    @Override
    public void cargaDatos(String token, int idTienda, final OnFinishedListener onFinishedListener) {
        Call<List<ActividadDTO>> call = service.getTareas(token, idTienda);

        call.enqueue(new Callback<List<ActividadDTO>>() {
            @Override
            public void onResponse(Call<List<ActividadDTO>> call, Response<List<ActividadDTO>> response) {
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
            public void onFailure(Call<List<ActividadDTO>> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }

    @Override
    public void actualizaEstatus(String token, InfoTareaDTO infoTarea, final OnFinishedListener onFinishedListener) {
        Call<MensajeDTO> call = service.actualizaEstatusTarea(token, infoTarea);

        call.enqueue(new Callback<MensajeDTO>() {
            @Override
            public void onResponse(Call<MensajeDTO> call, Response<MensajeDTO> response) {
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
                    case 406: // No aceptable
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
            public void onFailure(Call<MensajeDTO> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }
}
