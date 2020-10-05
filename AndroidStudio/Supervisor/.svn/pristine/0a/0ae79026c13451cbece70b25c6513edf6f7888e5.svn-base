package com.grupopakar.grupopakarapp.presenter;

import com.grupopakar.grupopakarapp.contract.TiendasCercanasContract;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-06
 */
public class TiendasCercanasPresenterImpl implements TiendasCercanasContract.TiendasPresenter, TiendasCercanasContract.TiendasDAO.OnFinishedListener {
    private TiendasCercanasContract.TiendasView view;
    private TiendasCercanasContract.TiendasDAO dao;

    public TiendasCercanasPresenterImpl(TiendasCercanasContract.TiendasView view, TiendasCercanasContract.TiendasDAO dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getTiendasCercanas(String token, String lat, String lon) {
        if (view != null) {
            view.updateProgress(false);
            dao.getTiendasCercanas(token, lat, lon, this);
        }
    }

    @Override
    public void onFinished(List<TiendaDTO> tiendas) {
        if (view != null) {
            view.updateProgress(true);
            view.muestraTiendasCercanas(tiendas);
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
