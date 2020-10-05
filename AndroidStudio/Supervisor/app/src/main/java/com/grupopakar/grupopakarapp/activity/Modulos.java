package com.grupopakar.grupopakarapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.adapter.ModulosAdapter;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;

public class Modulos extends AppCompatActivity {
    private TiendaDTO tienda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);
        setupComponentes();
    }

    private void setupComponentes() {
        tienda = (TiendaDTO) Util.getParametro(this, "tienda");
        SessionManager session = new SessionManager(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        RecyclerView rv = findViewById(R.id.rv);
        ModulosAdapter adapter = new ModulosAdapter(this, session.getModulos());
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

    public TiendaDTO getTienda() {
        return tienda;
    }
}
