package com.grupopakar.grupopakarapp.dao;

import com.google.gson.Gson;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.TiendasCercanasContract;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.util.Factory;
import com.grupopakar.grupopakarapp.util.MyApplication;
import com.grupopakar.grupopakarapp.ws.TiendaWS;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by antonio.ruiz on 2019-05-06
 */
public class TiendasCercanasDAOImpl implements TiendasCercanasContract.TiendasDAO {
    @Override
    public void getTiendasCercanas(String token, String lat, String lon, final OnFinishedListener onFinishedListener) {
        TiendaWS service = (TiendaWS) Factory.getWS(TiendaWS.class);

        Call<List<TiendaDTO>> call = service.getTiendasCercanas(token, lat, lon);

        call.enqueue(new Callback<List<TiendaDTO>>() {
            @Override
            public void onResponse(Call<List<TiendaDTO>> call, Response<List<TiendaDTO>> response) {
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
                    case 404: // No existen tiendas cercanas
                        try {
                            if (response.errorBody() != null) {
                                onFinishedListener.onFailure(new Gson().fromJson(response.errorBody().string(), MensajeDTO.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 406: // Coordenadas erroneas
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
            public void onFailure(Call<List<TiendaDTO>> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }
}
