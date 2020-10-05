package com.grupopakar.grupopakarapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.adapter.TareaAdapter;
import com.grupopakar.grupopakarapp.contract.TareaContract;
import com.grupopakar.grupopakarapp.dao.TareaDAOImpl;
import com.grupopakar.grupopakarapp.dto.ActividadDTO;
import com.grupopakar.grupopakarapp.dto.InfoTareaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.presenter.TareaPresenterImpl;
import com.grupopakar.grupopakarapp.util.Mensaje;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class Tarea extends AppCompatActivity implements TareaContract.TareaView {
    private SessionManager session;
    private TiendaDTO tienda;
    private TareaContract.TareaPresenter presenter;

    private ProgressBar progressBar;
    private RecyclerView rv;
    private TareaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);
        setupComponentes();
        cargaDatos();
    }

    private void setupComponentes() {
        tienda = (TiendaDTO) Util.getParametro(this, "tienda");
        session = new SessionManager(this);
        presenter = new TareaPresenterImpl(this, new TareaDAOImpl());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        progressBar = findViewById(R.id.progressBar);
        rv = findViewById(R.id.rv);
        TextView tvNombreTienda = findViewById(R.id.tvNombreTienda);
        TextView tvCiudad = findViewById(R.id.tvCiudad);
        TextView tvTipo = findViewById(R.id.tvTipo);
        TextView tvSupervisor = findViewById(R.id.tvSupervisor);
        tvNombreTienda.setText(getString(R.string.lb_info_tienda_almacen, tienda.getNombreTienda(), tienda.getCveTienda()));
        tvCiudad.setText(tienda.getCiudad());
        tvTipo.setText(getString(R.string.lb_info_tipo_ciudad, tienda.getTipoTienda(), tienda.getCiudad()));
        tvSupervisor.setText(getString(R.string.lb_supervisor_tienda, tienda.getSupervisor()));
        adapter = new TareaAdapter(this, new ArrayList<ActividadDTO>());
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void cargaDatos() {
        try {
            if (Util.isConnected(this)) {
                presenter.cargaDatos(session.getToken(), tienda.getIdTienda());
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void updateProgress(boolean enabled) {
        progressBar.setVisibility(enabled ? GONE : VISIBLE);
        rv.setVisibility(enabled ? VISIBLE : GONE);
    }

    @Override
    public void muestraDatos(List<ActividadDTO> datos) {
        adapter.setItems(datos);
        Util.hideSoftKeyboard(this);
    }

    @Override
    public void muestraError(MensajeDTO mensaje) {
        Mensaje.muestraMensajeCorto(this, mensaje.getEstatus());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorToken(MensajeDTO mensaje) {
        Mensaje.muestraDialogoSesion(this, mensaje.getEstatus());
//        session.logout();
    }

    public void actualizaEstatus(int idTarea, boolean valor) {
        try {
            if (Util.isConnected(this)) {
                presenter.actualizaEstatus(session.getToken(), new InfoTareaDTO(idTarea, valor, tienda.getIdTienda()));
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
