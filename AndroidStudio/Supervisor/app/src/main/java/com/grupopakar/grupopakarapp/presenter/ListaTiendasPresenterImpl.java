package com.grupopakar.grupopakarapp.presenter;

import com.grupopakar.grupopakarapp.contract.ListaTiendasContract;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-06
 */
public class ListaTiendasPresenterImpl implements ListaTiendasContract.TiendasPresenter, ListaTiendasContract.ListaTiendasDAO.OnFinishedListener {
    private ListaTiendasContract.TiendasView view;
    private ListaTiendasContract.ListaTiendasDAO dao;

    public ListaTiendasPresenterImpl(ListaTiendasContract.TiendasView view, ListaTiendasContract.ListaTiendasDAO dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void buscaTiendas(String token, String descripcion) {
        if (view != null) {
            view.updateProgress(false);
            dao.buscaTiendas(token, descripcion, this);
        }
    }

    @Override
    public void onFinished(List<TiendaDTO> tiendas) {
        if (view != null) {
            view.updateProgress(true);
            view.muestraTiendas(tiendas);
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
