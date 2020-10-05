package com.grupopakar.grupopakarapp.util;

import android.Manifest;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.dto.MenuDTO;

/**
 * Created by antonio.ruiz on 2019-05-03
 */
public class Constante {
    /**
     * Código para verificar permisos.
     */
    public static final int PERMISSION_CODE = 1234;

    /**
     * Constante de permisos necesarios para el uso de la App.
     */
    public static final String[] PERMISSIONS = new String[]{
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.CHANGE_NETWORK_STATE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    /**
     * IP de servidor.
     */
    //static final String BASE_URL = "http://grupopakar.mx:8881/GrupoPakarAppWS/ws/";
    //static final String BASE_URL = "http://194.168.1.111:8883/GrupoPakarAppWS/ws/";
    public static final String BASE_URL = "http://194.168.1.111:8090/SCPakarAppWS/ws/";

    /**
     * Menu.
     */
    public static final MenuDTO[] MENUS = new MenuDTO[]{
            new MenuDTO(MyApplication.getRes().getString(R.string.menu_bandeja)),
            new MenuDTO(MyApplication.getRes().getString(R.string.menu_tiendas)),
            new MenuDTO(MyApplication.getRes().getString(R.string.menu_cuenta)),
            new MenuDTO(MyApplication.getRes().getString(R.string.menu_configuracion)),
            new MenuDTO(MyApplication.getRes().getString(R.string.menu_salir))
    };

    /**
     * Tiempo de espera de respuesta Htpp en milisegundos.
     */
    public static final int TIME_OUT_CONNECT_HTTP = 30000;

    /**
     * Tiempo de espera de respuesta Htpp en milisegundos.
     */
    public static final int TIME_OUT_READ_HTTP = 30000;


    /**
     * Constantes de SharedPreferences.
     */
    // Preferencias de Sesión
    static final String IS_LOGIN = "IsLoggedIn";
    static final String KEY_TOKEN = "token";
    static final String KEY_NAME = "name";
    static final String KEY_NOTIFICATION = "notification";
    // Modulos
    static final String KEY_NUM_MODULOS = "numModulos";
    static final String KEY_NAME_MODULO = "nameModulo";
    static final String KEY_ID_MODULO = "idModulo";
    static final String KEY_ICONO_MODULO = "iconoModulo";

    /**
     * Tipo de archivo a subir
     */

    public static final int IMAGE_CODE = 100;
    public static final int AUDIO_CODE = 200;
    public static final int VIDEO_CODE = 300;
    public static final int ARCHIVO_CODE = 400;
}
