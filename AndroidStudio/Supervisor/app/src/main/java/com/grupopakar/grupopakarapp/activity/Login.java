package com.grupopakar.grupopakarapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.LoginContract;
import com.grupopakar.grupopakarapp.dao.LoginDAOImpl;
import com.grupopakar.grupopakarapp.dto.CredencialesDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.UsuarioDTO;
import com.grupopakar.grupopakarapp.presenter.LoginPresenterImpl;
import com.grupopakar.grupopakarapp.util.Mensaje;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;


/**
 * Pantalla de ingreso para socios.
 */
public class Login extends AppCompatActivity implements OnClickListener, LoginContract.LoginView {
    private final String TAG = Login.class.getName();
    private SessionManager session;
    private LoginContract.LoginPresenter presenter;

    private ProgressBar progressBar;
    private TextInputLayout inputUser, inputPassword;
    private TextInputEditText etUser, etPassword;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupComponentes();
    }

    private void setupComponentes() {
        session = new SessionManager(this);
        presenter = new LoginPresenterImpl(this, new LoginDAOImpl());
        btnEntrar = findViewById(R.id.btnEntrar);
        etPassword = findViewById(R.id.etPassword);
        etUser = findViewById(R.id.etSocio);
        inputPassword = findViewById(R.id.inputPassword);
        inputUser = findViewById(R.id.inputSocio);
        progressBar = findViewById(R.id.progressBar);
        btnEntrar.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEntrar) {
            validaDatos();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void validaDatos() {
        inputUser.setError(null);
        inputPassword.setError(null);
        if (TextUtils.isEmpty(etUser.getText()) && TextUtils.isEmpty(etPassword.getText())) {
            inputUser.setError(getString(R.string.error_campo_requerido));
            inputPassword.setError(getString(R.string.error_campo_requerido));
        } else if (TextUtils.isEmpty(etUser.getText())) {
            inputUser.setError(getString(R.string.error_campo_requerido));
        } else if (TextUtils.isEmpty(etPassword.getText())) {
            inputPassword.setError(getString(R.string.error_campo_requerido));
        } else {
            intentaLogin(new CredencialesDTO(etUser.getText().toString(), etPassword.getText().toString()));
        }
    }

    private void intentaLogin(CredencialesDTO credenciales) {
        try {
            if (Util.isConnected(this)) {
                presenter.intentaLogin(credenciales);
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG + ".intentaLogin", e.getMessage());
        }
    }

    @Override
    public void updateProgress(boolean enabled) {
        btnEntrar.setEnabled(enabled);
        btnEntrar.setAlpha(enabled ? 1.0f : 0.6f);
        progressBar.setVisibility(enabled ? View.GONE : View.VISIBLE);
        inputUser.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
    }

    @Override
    public void login(UsuarioDTO usuario) {
        session.crearLoginSesion(usuario);
        startActivity(new Intent(this, Inicio.class));
        finish();
    }

    @Override
    public void muestraError(MensajeDTO mensaje) {
        inputPassword.setError(mensaje.getEstatus());
    }
}

