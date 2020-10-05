package com.grupopakar.grupopakarapp.contract;

import com.grupopakar.grupopakarapp.dto.PlantillaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.ValidaPlantillaDTO;

/**
 * Created by antonio.ruiz on 2019-05-07
 */
public interface PlantillaContract {
    /**
     * Interactua vista y dao
     */
    interface PlantillaPresenter {
        void onDestroy();

        void cargaDatos(String token, int idTienda);

        void validaPlantilla(String token, ValidaPlantillaDTO validacion);
    }

    /**
     * Actualizar vista
     **/
    interface PlantillaView {
        void cargaDatos();

        void updateProgress(boolean enabled);

        void muestraDatos(PlantillaDTO datos);

        void muestraError(MensajeDTO mensaje);

        void errorToken(MensajeDTO mensaje);
    }

    /**
     * Interactua con webservice.
     **/
    interface PlantillaDAO {

        interface OnFinishedListener {
            void onFinished(PlantillaDTO datos);

            void onFinished(MensajeDTO mensaje);

            void onFailureToken(MensajeDTO mensaje);

            void onFailure(MensajeDTO mensaje);
        }

        void cargaDatos(String token, int idTienda, OnFinishedListener onFinishedListener);

        void validaPlantilla(String token, ValidaPlantillaDTO validacion, OnFinishedListener onFinishedListener);
    }
}
