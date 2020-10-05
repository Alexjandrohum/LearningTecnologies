package com.grupopakar.grupopakarapp.dao;

import com.google.gson.Gson;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.PlantillaContract;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.PlantillaDTO;
import com.grupopakar.grupopakarapp.dto.ValidaPlantillaDTO;
import com.grupopakar.grupopakarapp.util.Factory;
import com.grupopakar.grupopakarapp.util.MyApplication;
import com.grupopakar.grupopakarapp.ws.PlantillaWS;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by antonio.ruiz on 2019-05-10
 */
public class PlantillaDAOImpl implements PlantillaContract.PlantillaDAO {
    private final PlantillaWS service;

    public PlantillaDAOImpl() {
        service = (PlantillaWS) Factory.getWS(PlantillaWS.class);
    }

    @Override
    public void cargaDatos(String token, int idTienda, final OnFinishedListener onFinishedListener) {
        Call<PlantillaDTO> call = service.getPlantilla(token, idTienda);

        call.enqueue(new Callback<PlantillaDTO>() {
            @Override
            public void onResponse(Call<PlantillaDTO> call, Response<PlantillaDTO> response) {
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
                    case 406: // No existe informacion
                        try {
                            if (response.errorBody() != null) {
                                onFinishedListener.onFailure(new Gson().fromJson(response.errorBody().string(), MensajeDTO.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 503: // Conexion no disponible (base de datos)
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
            public void onFailure(Call<PlantillaDTO> call, Throwable t) {
                onFinishedListener.onFailure(new MensajeDTO(t.getMessage()));
            }
        });
    }

    @Override
    public void validaPlantilla(String token, ValidaPlantillaDTO validacion, final OnFinishedListener onFinishedListener) {
        Call<MensajeDTO> call = service.validaPlantilla(token, validacion);

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
                    case 406: // No aceptable
                        try {
                            if (response.errorBody() != null) {
                                onFinishedListener.onFailure(new Gson().fromJson(response.errorBody().string(), MensajeDTO.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 503: // Conexion no disponible (base de datos)
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