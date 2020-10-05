package com.grupopakar.grupopakarapp.contract;

import com.grupopakar.grupopakarapp.dto.ActividadDTO;
import com.grupopakar.grupopakarapp.dto.InfoTareaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-13
 */
public interface TareaContract {
    /**
     * Interactua vista y dao
     */
    interface TareaPresenter {
        void onDestroy();

        void cargaDatos(String token, int idTienda);

        void actualizaEstatus(String token, InfoTareaDTO infoTarea);
    }

    /**
     * Actualizar vista
     **/
    interface TareaView {
        void cargaDatos();

        void updateProgress(boolean enabled);

        void muestraDatos(List<ActividadDTO> datos);

        void muestraError(MensajeDTO mensaje);

        void errorToken(MensajeDTO mensaje);
    }

    /**
     * Interactua con webservice.
     **/
    interface TareaDAO {

        interface OnFinishedListener {
            void onFinished(List<ActividadDTO> datos);

            void onFinished(MensajeDTO mensaje);

            void onFailureToken(MensajeDTO mensaje);

            void onFailure(MensajeDTO mensaje);
        }

        void cargaDatos(String token, int idTienda, OnFinishedListener onFinishedListener);

        void actualizaEstatus(String token, InfoTareaDTO infoTarea, OnFinishedListener onFinishedListener);
    }
}
