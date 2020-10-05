package com.grupopakar.grupopakarapp.fragments.tabs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Inicio;
import com.grupopakar.grupopakarapp.adapter.TabTiendasAdapter;
import com.grupopakar.grupopakarapp.contract.ListaTiendasContract;
import com.grupopakar.grupopakarapp.dao.ListaTiendasDAOImpl;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.layout.DividerItemTiendas;
import com.grupopakar.grupopakarapp.presenter.ListaTiendasPresenterImpl;
import com.grupopakar.grupopakarapp.util.Mensaje;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by antonio.ruiz on 20/08/2018.
 */

public class TabListaTiendas extends Fragment implements ListaTiendasContract.TiendasView, SearchView.OnQueryTextListener {
    private Activity activity;
    private SessionManager session;
    private ListaTiendasContract.TiendasPresenter presenter;

    private SearchView search;
    private RecyclerView rv;
    private ProgressBar progressBar;
    private TabTiendasAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_lista_tiendas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        session = ((Inicio) activity).getSessionManager();
        if (session == null) session = new SessionManager(activity);
        setupComponentes(view);
    }

    private void setupComponentes(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        rv = view.findViewById(R.id.rv);
        search = view.findViewById(R.id.search);
        presenter = new ListaTiendasPresenterImpl(this, new ListaTiendasDAOImpl());
        adapter = new TabTiendasAdapter(activity, new ArrayList<TiendaDTO>());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new DividerItemTiendas(ContextCompat.getDrawable(activity, R.drawable.divider_menu_white)));
        search.onActionViewExpanded();
        search.clearFocus();
        search.setOnQueryTextListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) activity = (Activity) context;
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
        search.setEnabled(enabled);
    }

    @Override
    public void muestraTiendas(List<TiendaDTO> tiendas) {
        adapter.setItems(tiendas);
    }

    @Override
    public void muestraError(MensajeDTO mensaje) {
        Mensaje.muestraMensajeCorto(activity, mensaje.getEstatus());
    }

    @Override
    public void errorToken(MensajeDTO mensaje) {
        Mensaje.muestraDialogoSesion(activity, mensaje.getEstatus());
        session.logout();
    }

    private void buscaTiendas(String token, String busqueda) {
        try {
            if (Util.isConnected(activity)) {
                presenter.buscaTiendas(token, busqueda);
            } else Mensaje.muestraMensajeCorto(activity, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        buscaTiendas(session.getToken(), query);
        search.clearFocus();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return true;
    }
}
