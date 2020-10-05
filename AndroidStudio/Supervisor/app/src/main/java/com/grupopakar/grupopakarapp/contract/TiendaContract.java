package com.grupopakar.grupopakarapp.contract;

import com.grupopakar.grupopakarapp.dto.GpoInfoTiendaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-07
 */
public interface TiendaContract {
    /**
     * Interactua vista y dao
     */
    interface TiendaPresenter {
        void onDestroy();

        void cargaDatos(String token, int idTienda);

        void actualizaTienda(String token, int id, String valor);
    }

    /**
     * Actualizar vista
     **/
    interface TiendaView {
        void getInfo();

        void updateProgress(boolean enabled);

        void muestraDatos(List<GpoInfoTiendaDTO> datos);

        void muestraFoto(String url);

        void muestraError(MensajeDTO mensaje);

        void errorToken(MensajeDTO mensaje);
    }

    /**
     * Interactua con webservice.
     **/
    interface TiendaDAO {

        interface OnFinishedListener {
            void onFinished(List<GpoInfoTiendaDTO> datos);

            void onFinished(String url);

            void onFinished(MensajeDTO mensaje);

            void onFailureToken(MensajeDTO mensaje);

            void onFailure(MensajeDTO mensaje);
        }

        void cargaDatos(String token, int idTienda, OnFinishedListener onFinishedListener);

        void cargaFoto(int idTienda, OnFinishedListener listener);

        void actualizaTienda(String token, int id, String valor, OnFinishedListener onFinishedListener);
    }
}
