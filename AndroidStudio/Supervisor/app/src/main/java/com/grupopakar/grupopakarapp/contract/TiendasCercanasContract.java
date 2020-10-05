package com.grupopakar.grupopakarapp.contract;

import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-06
 */
public interface TiendasCercanasContract {
    /**
     * Interactua vista y dao
     */
    interface TiendasPresenter {
        void onDestroy();

        void getTiendasCercanas(String token, String lat, String lon);
    }

    /**
     * Actualizar vista
     **/
    interface TiendasView {
        void updateProgress(boolean enabled);

        void muestraTiendasCercanas(List<TiendaDTO> tiendas);

        void muestraError(MensajeDTO mensaje);

        void errorToken(MensajeDTO mensaje);
    }

    /**
     * Interactua con webservice.
     **/
    interface TiendasDAO {

        interface OnFinishedListener {
            void onFinished(List<TiendaDTO> tiendas);

            void onFailureToken(MensajeDTO mensaje);

            void onFailure(MensajeDTO mensaje);
        }

        void getTiendasCercanas(String token, String lat, String lon, OnFinishedListener onFinishedListener);
    }
}
