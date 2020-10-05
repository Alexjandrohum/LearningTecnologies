package com.grupopakar.grupopakarapp.presenter;

import com.grupopakar.grupopakarapp.contract.TareaContract;
import com.grupopakar.grupopakarapp.dto.ActividadDTO;
import com.grupopakar.grupopakarapp.dto.InfoTareaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-13
 */
public class TareaPresenterImpl implements TareaContract.TareaPresenter, TareaContract.TareaDAO.OnFinishedListener {
    private TareaContract.TareaView view;
    private TareaContract.TareaDAO dao;

    public TareaPresenterImpl(TareaContract.TareaView view, TareaContract.TareaDAO dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void cargaDatos(String token, int idTienda) {
        if (view != null) {
            view.updateProgress(false);
            dao.cargaDatos(token, idTienda, this);
        }
    }

    @Override
    public void actualizaEstatus(String token, InfoTareaDTO infoTarea) {
        if (view != null) {
            view.updateProgress(false);
            dao.actualizaEstatus(token, infoTarea, this);
        }
    }

    @Override
    public void onFinished(List<ActividadDTO> datos) {
        if (view != null) {
            view.updateProgress(true);
            view.muestraDatos(datos);
        }
    }

    @Override
    public void onFinished(MensajeDTO mensaje) {
        if (view != null) {
            view.updateProgress(true);
            view.muestraError(mensaje);
            view.cargaDatos();
        }
    }

    @Override
    public void onFailureToken(MensajeDTO mensaje) {
        if (view != null) {
            view.updateProgress(true);
            view.errorToken(mensaje);
        }
    }

    @Override
    public void onFailure(MensajeDTO mensaje) {
        if (view != null) {
            view.updateProgress(true);
            view.muestraError(mensaje);
        }
    }
}
