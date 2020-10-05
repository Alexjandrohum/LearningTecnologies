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
import com.grupopakar.grupopakarapp.adapter.PlantillaAdapter;
import com.grupopakar.grupopakarapp.contract.PlantillaContract;
import com.grupopakar.grupopakarapp.dao.PlantillaDAOImpl;
import com.grupopakar.grupopakarapp.dto.EmpleadoDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.PlantillaDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.dto.ValidaPlantillaDTO;
import com.grupopakar.grupopakarapp.presenter.PlantillaPresenterImpl;
import com.grupopakar.grupopakarapp.util.Mensaje;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static androidx.constraintlayout.widget.Constraints.TAG;

public class Plantilla extends AppCompatActivity implements PlantillaContract.PlantillaView {
    private SessionManager session;
    private TiendaDTO tienda;
    private PlantillaPresenterImpl presenter;

    private ProgressBar progressBar;
    private RecyclerView rv;
    private PlantillaAdapter adapter;
    private TextView tvVacantes;
    private TextView tvPlantillaAutorizada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla);
        setupComponentes();
        cargaDatos();
    }

    private void setupComponentes() {
        tienda = (TiendaDTO) Util.getParametro(this, "tienda");
        session = new SessionManager(this);
        presenter = new PlantillaPresenterImpl(this, new PlantillaDAOImpl());
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
        tvVacantes = findViewById(R.id.tvVacantes);
        tvPlantillaAutorizada = findViewById(R.id.tvPlantillaAutorizada);
        tvVacantes.setText(getString(R.string.lb_vacantes, 0));
        tvPlantillaAutorizada.setText(getString(R.string.lb_plantilla_autorizada, 0));
        tvNombreTienda.setText(getString(R.string.lb_info_tienda_almacen, tienda.getNombreTienda(), tienda.getCveTienda()));
        tvCiudad.setText(tienda.getCiudad());
        tvTipo.setText(getString(R.string.lb_info_tipo_ciudad, tienda.getTipoTienda(), tienda.getCiudad()));
        adapter = new PlantillaAdapter(this, new ArrayList<EmpleadoDTO>());
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
    public void updateProgress(boolean enabled) {
        progressBar.setVisibility(enabled ? GONE : VISIBLE);
        rv.setVisibility(enabled ? VISIBLE : GONE);
    }

    @Override
    public void muestraDatos(PlantillaDTO datos) {
        tvVacantes.setText(getString(R.string.lb_vacantes, datos.getVacantes()));
        tvPlantillaAutorizada.setText(getString(R.string.lb_plantilla_autorizada, datos.getPlantillaAutorizada()));
        adapter.setItems(datos.getPlantilla());
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

    public void validaPlantilla(int idEmpleado, String comentario) {
        try {
            if (Util.isConnected(this)) {
                presenter.validaPlantilla(session.getToken(), new ValidaPlantillaDTO(tienda.getIdTienda(), idEmpleado, true, comentario));
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}