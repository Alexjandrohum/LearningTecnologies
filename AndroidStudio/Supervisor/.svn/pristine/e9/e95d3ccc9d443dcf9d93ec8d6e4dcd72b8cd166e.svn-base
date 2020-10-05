package com.grupopakar.grupopakarapp.dao;

import com.google.gson.Gson;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.TiendaContract;
import com.grupopakar.grupopakarapp.dto.InfoTiendaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.GpoInfoTiendaDTO;
import com.grupopakar.grupopakarapp.util.Factory;
import com.grupopakar.grupopakarapp.util.MyApplication;
import com.grupopakar.grupopakarapp.ws.InfoTiendaWS;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by antonio.ruiz on 2019-05-07
 */
public class TiendaDAOImpl implements TiendaContract.TiendaDAO {
    private final InfoTiendaWS service;

    public TiendaDAOImpl() {
        service = (InfoTiendaWS) Factory.getWS(InfoTiendaWS.class);
    }

    @Override
    public void cargaDatos(String token, int idTienda, final OnFinishedListener onFinishedListener) {
        Call<List<GpoInfoTiendaDTO>> call = service.getInfoTienda(token, idTienda);

        call.enqueue(new Callback<List<GpoInfoTiendaDTO>>() {
            @Override
            public void onResponse(Call<List<GpoInfoTiendaDTO>> call, Response<List<GpoInfoTiendaDTO>> response) {
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
                    case 406: // No existe informacion para la tienda
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
            public void onFailure(Call<List<GpoInfoTiendaDTO>> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }

    @Override
    public void cargaFoto(int idTienda, final OnFinishedListener onFinishedListener) {
        Call<String> call = service.getFotoTienda(idTienda);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
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
                    case 406: // No existe informacion para la tienda
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
            public void onFailure(Call<String> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }

    @Override
    public void actualizaTienda(String token, int id, String valor, final OnFinishedListener onFinishedListener) {
        Call<MensajeDTO> call = service.actualizaInfoTienda(token, new InfoTiendaDTO(id, valor));

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
                    case 406: // No existe informacion para la tienda
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
