package com.grupopakar.grupopakarapp.presenter;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.LoginContract;
import com.grupopakar.grupopakarapp.dto.CredencialesDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.UsuarioDTO;
import com.grupopakar.grupopakarapp.util.MyApplication;

public class LoginPresenterImpl implements LoginContract.LoginPresenter, LoginContract.LoginDAO.OnFinishedListener {

    private LoginContract.LoginView view;
    private LoginContract.LoginDAO dao;

    public LoginPresenterImpl(LoginContract.LoginView view, LoginContract.LoginDAO dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void intentaLogin(CredencialesDTO credenciales) {
        if (view != null) {
            view.updateProgress(false);
            dao.login(credenciales, this);
        }
    }

    @Override
    public void onFinished(UsuarioDTO user) {
        if (view != null) {
            if (user.getTokenDeUsuario() != null && !user.getTokenDeUsuario().isEmpty()) {
                view.login(user);
            } else {
                view.muestraError(new MensajeDTO(MyApplication.getRes().getString(R.string.error_usuario)));
            }
            view.updateProgress(true);
        }
    }

    @Override
    public void onFailure(MensajeDTO mensaje) {
        if (view != null) {
            view.muestraError(mensaje);
            view.updateProgress(true);
        }
    }
}