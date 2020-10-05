package com.grupopakar.grupopakarapp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.grupopakar.grupopakarapp.activity.Login;
import com.grupopakar.grupopakarapp.dto.ModuloDTO;
import com.grupopakar.grupopakarapp.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

import static com.grupopakar.grupopakarapp.util.Constante.IS_LOGIN;
import static com.grupopakar.grupopakarapp.util.Constante.KEY_ICONO_MODULO;
import static com.grupopakar.grupopakarapp.util.Constante.KEY_ID_MODULO;
import static com.grupopakar.grupopakarapp.util.Constante.KEY_NAME;
import static com.grupopakar.grupopakarapp.util.Constante.KEY_NAME_MODULO;
import static com.grupopakar.grupopakarapp.util.Constante.KEY_NOTIFICATION;
import static com.grupopakar.grupopakarapp.util.Constante.KEY_NUM_MODULOS;
import static com.grupopakar.grupopakarapp.util.Constante.KEY_TOKEN;

public class SessionManager {

    private final SharedPreferences pref;
    private final Editor editor;
    private final Context _context;
    private static final String PREF_NAME = "SesionPref";

    // Constructor
    @SuppressLint("CommitPrefEdits")
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    /**
     * Crea sesión.
     *
     * @param usuario que esta logeando*/
    public void crearLoginSesion(UsuarioDTO usuario){
        // guarda datos
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_TOKEN, usuario.getTokenDeUsuario());
        editor.putString(KEY_NAME, usuario.getNombre());
        editor.putInt(KEY_NOTIFICATION, usuario.getNotificacionesPendientes());
        editor.putInt(KEY_NUM_MODULOS, usuario.getListaModulos().size());
        int i = 0;
        for (ModuloDTO m : usuario.getListaModulos()) {
            editor.putString(KEY_NAME_MODULO + i, m.getNombreModulo());
            editor.putInt(KEY_ID_MODULO + i, m.getIdModulo());
            editor.putString(KEY_ICONO_MODULO + i, m.getIcono());
            i++;
        }
        editor.commit();
    }

    /**
     * Revisa si esta logeado si no redirigir a Logeo.
     * */
    public void checkLogin(){
        // Revista el estatus de si esta logeado.
        if(!this.isLoggedIn()){
            // Usuario no esta logeado
             Intent i = new Intent(_context, Login.class);
            // Cerrar todas las actividades
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Iniciar nueva actividad
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }

    }

    /**
     * Limpia datos de usuario.
     * */
    public void logout(){
        // Limpia todos los datos de la SharedPreferences
        editor.clear();
        editor.commit();
    }

    public void exit() {
        // Redirigir a Inicio
        Intent i = new Intent(_context, Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    /**
     * Revisar rápidamente si esta logeado.
     * **/
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public String getToken() {
        return pref.getString(KEY_TOKEN, "");
    }

    public List<ModuloDTO> getModulos() {
        System.out.println("Editor" + pref.getAll());
        List<ModuloDTO> lista = new ArrayList<>();
        for (int i = 0; i < pref.getInt(KEY_NUM_MODULOS, 0); i++){

            lista.add(new ModuloDTO(pref.getInt(KEY_ID_MODULO + i, 0), pref.getString(KEY_NAME_MODULO + i, ""), pref.getString(KEY_ICONO_MODULO  + i,"")));

            System.out.println("Lista Modulos: "+lista.get(i).toString());
        }
        return lista;
    }
}