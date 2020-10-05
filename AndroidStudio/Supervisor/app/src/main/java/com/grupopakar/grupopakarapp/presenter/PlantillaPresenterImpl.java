package com.grupopakar.grupopakarapp.presenter;

import com.grupopakar.grupopakarapp.contract.PlantillaContract;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.PlantillaDTO;
import com.grupopakar.grupopakarapp.dto.ValidaPlantillaDTO;

/**
 * Created by antonio.ruiz on 2019-05-10
 */
public class PlantillaPresenterImpl implements PlantillaContract.PlantillaPresenter, PlantillaContract.PlantillaDAO.OnFinishedListener {
    private PlantillaContract.PlantillaView view;
    private PlantillaContract.PlantillaDAO dao;

    public PlantillaPresenterImpl(PlantillaContract.PlantillaView view, PlantillaContract.PlantillaDAO dao) {
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
    public void validaPlantilla(String token, ValidaPlantillaDTO validacion) {
        if (view != null) {
            view.updateProgress(false);
            dao.validaPlantilla(token, validacion, this);
        }
    }

    @Override
    public void onFinished(PlantillaDTO datos) {
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
