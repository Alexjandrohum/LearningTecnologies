package com.grupopakar.grupopakarapp.presenter;

import com.grupopakar.grupopakarapp.contract.TiendaContract;
import com.grupopakar.grupopakarapp.dto.GpoInfoTiendaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-07
 */
public class TiendaPresenterImpl implements TiendaContract.TiendaPresenter, TiendaContract.TiendaDAO.OnFinishedListener {
    private TiendaContract.TiendaView view;
    private TiendaContract.TiendaDAO dao;

    public TiendaPresenterImpl(TiendaContract.TiendaView view, TiendaContract.TiendaDAO dao) {
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
            dao.cargaFoto(idTienda, this);
        }
    }

    @Override
    public void actualizaTienda(String token, int id, String valor) {
        if (view != null) {
            view.updateProgress(false);
            dao.actualizaTienda(token, id, valor, this);
        }
    }

    @Override
    public void onFinished(List<GpoInfoTiendaDTO> datos) {
        if (view != null) {
            view.updateProgress(true);
            view.muestraDatos(datos);
        }
    }

    @Override
    public void onFinished(String url) {
        if (view != null) {
            view.updateProgress(true);
            view.muestraFoto(url);
        }
    }

    @Override
    public void onFinished(MensajeDTO mensaje) {
        if (view != null) {
            //view.updateProgress(true);
            view.muestraError(mensaje);
            view.getInfo();
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
