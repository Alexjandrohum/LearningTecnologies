package com.grupopakar.grupopakarapp.contract;

import com.grupopakar.grupopakarapp.dto.CredencialesDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.UsuarioDTO;

public interface LoginContract {
    /**
     * Interactua vista y dao
     */
    interface LoginPresenter {
        void onDestroy();

        void intentaLogin(CredencialesDTO credenciales);
    }

    /**
     * Actualizar vista
     **/
    interface LoginView {
        void updateProgress(boolean enabled);

        void login(UsuarioDTO usuario);

        void muestraError(MensajeDTO mensaje);
    }

    /**
     * Interactua con webservice.
     **/
    interface LoginDAO {

        interface OnFinishedListener {
            void onFinished(UsuarioDTO usuario);

            void onFailure(MensajeDTO mensaje);
        }

        void login(CredencialesDTO credenciales, OnFinishedListener onFinishedListener);
    }
}