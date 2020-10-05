package com.grupopakar.grupopakarapp.contract;

import com.grupopakar.grupopakarapp.dto.ComentarioDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.io.InputStream;
import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-13
 */
public interface ComentariosContract {
    /**
     * Interactua vista y dao
     */
    interface ComentariosPresenter {
        void onDestroy();

        void cargaDatos(String token, int idTienda);

        void registraComentario(String token, ComentarioDTO comentario);

        void cargaImagen(String path, String nombre);
    }

    /**
     * Actualizar vista
     **/
    interface ComentariosView {
        void cargaDatos();

        void registraComentario(int idComentario, String comentario);

        void updateProgress(boolean enabled);

        void muestraDatos(List<ComentarioDTO> datos);

        void muestraError(MensajeDTO mensaje);

        void errorToken(MensajeDTO mensaje);

        void muestraMensajeImagen(String mensaje);
    }

    /**
     * Interactua con webservice.
     **/
    interface ComentariosDAO {

        interface OnFinishedListener {
            void onFinished(List<ComentarioDTO> datos);

            void onFinished(MensajeDTO mensaje);

            void onFailureToken(MensajeDTO mensaje);

            void onFailure(MensajeDTO mensaje);

            void onFinishedImagen(String respuesta);
        }

        void cargaDatos(String token, int idTienda, OnFinishedListener onFinishedListener);

        void registraComentario(String token, ComentarioDTO comentario, OnFinishedListener onFinishedListener);

        void cargaImagen(String path, String nombre, OnFinishedListener listener);
    }
}
