package com.grupopakar.grupopakarapp.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Comentarios;
import com.grupopakar.grupopakarapp.activity.Inicio;
import com.grupopakar.grupopakarapp.activity.Plantilla;
import com.grupopakar.grupopakarapp.activity.Tarea;
import com.grupopakar.grupopakarapp.activity.Tienda;
import com.grupopakar.grupopakarapp.adapter.PlantillaAdapter;

public class Mensaje {
    /**
     * Muestra mensaje flotante con tiempo corto.
     *
     * @param context Contexto de la aplicación.
     * @param resId   Recurso de mensaje o mensaje.
     */
    public static void muestraMensajeCorto(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void muestraMensajeCorto(Context context, String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    /**
     * Muestra snackbar corto.
     *
     * @param view    Coordinator Layout activity.
     * @param mensaje Mensaje a mostrar.
     */
    public static void muestraSnackbar(View view, String mensaje) {
        Snackbar snackbar = Snackbar.make(view, mensaje, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    /**
     * Dialogo de sesión terminada.
     */
    public static void muestraDialogoSesion(final Context context, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.titulo_sesion_expirada);
        builder.setMessage(mensaje);
        builder.setPositiveButton(R.string.ok, null);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (context instanceof Inicio) {
                    ((Inicio) context).finish();
                } else if (context instanceof Tienda) {
                    ((Tienda) context).finish();
                } else if (context instanceof Plantilla) {
                    ((Plantilla) context).finish();
                } else if (context instanceof Tarea) {
                    ((Tarea) context).finish();
                } else if (context instanceof Comentarios) {
                    ((Comentarios) context).finish();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void muestraMenuArchivos(final Activity activity){
        View view = View.inflate(activity, R.layout.fragment_archivos, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        ImageView imageViewPhoto = view.findViewById(R.id.acctionFoto);
        ImageView imageViewDocumento = view.findViewById(R.id.actionDocumento);
        ImageView imageViewMusic = view.findViewById(R.id.actionAudio);
        ImageView imageViewVide = view.findViewById(R.id.acctionVideo);
        /*imageViewDocumento.setOnClickListener(this);
        imageViewPhoto.setOnClickListener(this);
        imageViewMusic.setOnClickListener(this);
        imageViewVide.setOnClickListener(this);*/

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(view);
        AlertDialog alertDialog1 = builder.create();
        alertDialog1.show();

        imageViewPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imageViewMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imageViewVide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imageViewDocumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
