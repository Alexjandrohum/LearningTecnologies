package com.example.conectarapi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.conectarapi.api.ModeloLogin;
import com.example.conectarapi.api.ModeloPerfil;
import com.example.conectarapi.api.ModeloToken;
import com.example.conectarapi.api.WebServiceApi;
import com.example.conectarapi.api.WebServiceJWT;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static  String tokenn0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);

        //obtenerToken();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        boolean fragmentSeleccionado = false;

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            fragment = new  PerfilFragment();
            fragmentSeleccionado = true;

        } else if (id == R.id.nav_slideshow) {
            fragment = new PruebaFragment();
            fragmentSeleccionado = true;

        } else if (id == R.id.nav_manage) {

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        if (fragmentSeleccionado == true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    private void obtenerToken(){


        ModeloLogin mod=new ModeloLogin();
        mod.setMatricula(15791008);
        mod.setContrasena("password");
        Call<List<String>> call = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerToken(mod);

        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.code()==200){
                    //tokenn = response.body().toString();
                    tokenn0 = response.body().get(0).toString();
                    Log.d("TAG1","El token es: "+tokenn0);

                    obtenerRecursoPerfil();









                }else  if (response.code()==401){
                    Log.d("Tag1","No autorizado");
                }else{
                    Log.d("Tag1","No obtenido Token");
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("Error: ",""+t);

            }
        });



    }


    private void obtenerRecursoPerfil(){
        ModeloToken too = new ModeloToken();
        too.setToken(tokenn0);
        Call<List<ModeloPerfil>> callPerfil = WebServiceJWT
                .getInstance()
                .createService(WebServiceApi.class)
                .obtenerPerfil(too);


        callPerfil.enqueue(new Callback<List<ModeloPerfil>>() {
            @Override
            public void onResponse(Call<List<ModeloPerfil>> call, Response<List<ModeloPerfil>> response) {

                List<ModeloPerfil> perfil = response.body();



                int[] idPErfil1 = new int[perfil.size()];
                String[] idPErfil2 = new String[perfil.size()];
                String[] idPErfil3 = new String[perfil.size()];
                String[] idPErfil4 = new String[perfil.size()];
                String[] idPErfil5 = new String[perfil.size()];
                String[] idPErfil6 = new String[perfil.size()];
                String[] idPErfil7 = new String[perfil.size()];

                for (int i = 0; i<perfil.size(); i++){

                    idPErfil1[i] = perfil.get(i).getMatricula();
                    idPErfil2[i] = perfil.get(i).getNom();
                    idPErfil3[i] = perfil.get(i).getAp();
                    idPErfil4[i] = perfil.get(i).getAm();
                    idPErfil5[i] = perfil.get(i).getGru();
                    idPErfil6[i] = perfil.get(i).getSem();
                    idPErfil7[i] = perfil.get(i).getCar();

                    Log.d("Datos","Datos "+i+": "+idPErfil1[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil2[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil3[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil4[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil5[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil6[i]);
                    Log.d("Datos","Datos "+i+": "+idPErfil7[i]);
                }

            }

            @Override
            public void onFailure(Call<List<ModeloPerfil>> call, Throwable t) {

            }
        });






    }


}
