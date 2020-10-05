package com.grupopakar.grupopakarapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.adapter.InfoTiendaAdapter;
import com.grupopakar.grupopakarapp.contract.TiendaContract;
import com.grupopakar.grupopakarapp.dao.TiendaDAOImpl;
import com.grupopakar.grupopakarapp.dto.GpoInfoTiendaDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.presenter.TiendaPresenterImpl;
import com.grupopakar.grupopakarapp.util.GlideApp;
import com.grupopakar.grupopakarapp.util.Mensaje;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class Tienda extends AppCompatActivity implements TiendaContract.TiendaView {
    private SessionManager session;
    private TiendaDTO tienda;
    private TiendaPresenterImpl presenter;

    private ProgressBar progressBar;
    private ImageView ivTienda;
    private RecyclerView rv;
    private InfoTiendaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        setupComponentes();
        getInfo();
    }

    private void setupComponentes() {
        tienda = (TiendaDTO) Util.getParametro(this, "tienda");
        session = new SessionManager(this);
        presenter = new TiendaPresenterImpl(this, new TiendaDAOImpl());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        progressBar = findViewById(R.id.progressBar);
        ivTienda = findViewById(R.id.ivTienda);
        rv = findViewById(R.id.rv);
        TextView tvNombreTienda = findViewById(R.id.tvNombreTienda);
        TextView tvCiudad = findViewById(R.id.tvCiudad);
        TextView tvTipo = findViewById(R.id.tvTipo);
        TextView tvSupervisor = findViewById(R.id.tvSupervisor);
        tvNombreTienda.setText(getString(R.string.lb_info_tienda_almacen, tienda.getNombreTienda(), tienda.getCveTienda()));
        tvCiudad.setText(tienda.getCiudad());
        tvTipo.setText(getString(R.string.lb_info_tipo_ciudad, tienda.getTipoTienda(), tienda.getCiudad()));
        tvSupervisor.setText(getString(R.string.lb_supervisor_tienda, tienda.getSupervisor()));
        adapter = new InfoTiendaAdapter(this, new ArrayList<GpoInfoTiendaDTO>());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);

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
    public void updateProgress(boolean enabled) {
        progressBar.setVisibility(enabled ? GONE : VISIBLE);
        rv.setVisibility(enabled ? VISIBLE : GONE);
    }

    @Override
    public void muestraDatos(List<GpoInfoTiendaDTO> datos) {
        adapter.setItems(datos);
    }

    @Override
    public void muestraFoto(String url) {
        GlideApp.with(this)
                .load(url)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .priority(Priority.NORMAL)
                .into(ivTienda);
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

    @Override
    public void getInfo() {
        try {
            if (Util.isConnected(this)) {
                presenter.cargaDatos(session.getToken(), tienda.getIdTienda());
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void actualizaTienda(int idInformacionTienda, String valor) {
        try {
            if (Util.isConnected(this)) {
                presenter.actualizaTienda(session.getToken(), idInformacionTienda, valor);
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
