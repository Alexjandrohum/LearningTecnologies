package com.grupopakar.grupopakarapp.fragments.tabs;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Inicio;
import com.grupopakar.grupopakarapp.adapter.TabTiendasAdapter;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.layout.DividerItemTiendas;
import com.grupopakar.grupopakarapp.contract.TiendasCercanasContract;
import com.grupopakar.grupopakarapp.dao.TiendasCercanasDAOImpl;
import com.grupopakar.grupopakarapp.presenter.TiendasCercanasPresenterImpl;
import com.grupopakar.grupopakarapp.util.Mensaje;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.grupopakar.grupopakarapp.util.Constante.PERMISSION_CODE;

/**
 * Created by antonio.ruiz on 20/08/2018.
 */

public class TabTiendasCercanas extends Fragment implements TiendasCercanasContract.TiendasView, SwipeRefreshLayout.OnRefreshListener, LocationListener {
    private Activity activity;
    private SessionManager session;
    private TiendasCercanasContract.TiendasPresenter presenter;

    private String lon;
    private String lat;

    private SwipeRefreshLayout swipe;
    private RecyclerView rv;
    private TextView tvTienda;
    private ProgressBar progressBar;
    private TabTiendasAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_tiendas_cercanas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        session = ((Inicio) activity).getSessionManager();
        if (session == null) session = new SessionManager(activity);
        setupComponentes(view);
        setupGPS();
        getLocation();
    }

    private void setupGPS() {
        //LocationManager lm = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(activity.getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_CODE);
        }
    }

    private void setupComponentes(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        rv = view.findViewById(R.id.rv);
        tvTienda = view.findViewById(R.id.tvTienda);
        swipe = view.findViewById(R.id.swipe);
        presenter = new TiendasCercanasPresenterImpl(this, new TiendasCercanasDAOImpl());
        adapter = new TabTiendasAdapter(activity, new ArrayList<TiendaDTO>());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new DividerItemTiendas(ContextCompat.getDrawable(activity, R.drawable.divider_menu_white)));
        swipe.setOnRefreshListener(this);
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
    }

    @Override
    public void muestraTiendasCercanas(List<TiendaDTO> tiendas) {
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

    private void getTiendasCercanas() {
        try {
            if (Util.isConnected(activity)) {
                presenter.getTiendasCercanas(session.getToken(), lat, lon);
            } else Mensaje.muestraMensajeCorto(activity, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void onRefresh() {
        setupGPS();
        getLocation();
        swipe.setRefreshing(false);
    }

    // Métodos relacionados a la ubicación
    private void getLocation() {
        LocationManager locationManager;
        try {
            Mensaje.muestraMensajeCorto(activity, getString(R.string.mensaje_gps_cargando));
            locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 20, this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = String.valueOf(location.getLatitude());
        lon = String.valueOf(location.getLongitude());
        getTiendasCercanas();

        try {
            Geocoder geocoder = new Geocoder(activity, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses!=null && !addresses.isEmpty())
                tvTienda.setText(addresses.get(0).getAddressLine(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        Mensaje.muestraMensajeCorto(activity, getString(R.string.mensaje_gps_desactivado));
    }
}
