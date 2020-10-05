package com.grupopakar.grupopakarapp.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.grupopakar.grupopakarapp.activity.Plantilla;

public class Util {
    /**
     * Valida que exista una conexión activa.
     *
     * @param context Contexto de la aplicación.
     * @return <code>true</code> si existe una conexión activa, de lo contrario <code>false</code>.
     */
    public static boolean isConnected(Context context) {
        boolean conectado;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
            conectado = (networkInfo != null && networkInfo.isConnected() && networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED);
            return conectado;
        }
        return false;
    }

    /**
     * Obtienes los pixeles de acuerdo a la densidad de la pantalla.
     */
    public static int convertDipToPixels(Context context, float dips) {
        return (int) (dips * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    /**
     * Obtiene un parámetro del context
     *
     * @param context Contexto de la aplicación del cual se obtendrá el parámetro.
     * @param clave   Parámetro que se busca obtener.
     * @return Objeto con los datos, de no existir regresa null.
     */
    public static Object getParametro(Context context, String clave) {
        Object param = null;
        try {
            if (((Activity) context).getIntent().getExtras() != null)
                param = ((Activity) context).getIntent().getExtras().getSerializable(clave);
        } catch (Exception e) {
            Log.e(Util.class.getName() + ".getParametro", e.getMessage());
        } finally {
            return param;
        }
    }

    /**
     * Ocultar teclado
     */
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && activity.getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }
}
