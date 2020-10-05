package com.grupopakar.grupopakarapp.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.contract.ComentariosContract;
import com.grupopakar.grupopakarapp.dao.ComentariosDAOImpl;
import com.grupopakar.grupopakarapp.dto.ComentarioDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.presenter.ComentariosPresenterImpl;
import com.grupopakar.grupopakarapp.util.Archivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import static com.grupopakar.grupopakarapp.util.Constante.ARCHIVO_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.AUDIO_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.IMAGE_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.VIDEO_CODE;

public class ImagenCorporativa extends AppCompatActivity implements ComentariosContract.ComentariosView, View.OnClickListener {
    private ComentariosPresenterImpl presenter;
    private String[] filePathColumn = {
            MediaStore.Audio.Media.DATA,
            MediaStore.Video.Media.DATA,
            MediaStore.Images.Media.DATA};
    private Archivos archivos;
    private ProgressDialog progressDoalog;
    private String ruta;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_corporativa);
        SetupComponents();
    }

    private void SetupComponents() {
        Button button = findViewById(R.id.subir);
        presenter = new ComentariosPresenterImpl(this, new ComentariosDAOImpl());
        archivos = new Archivos();
        /*progressDoalog = new ProgressDialog(ImagenCorporativa.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Cargando....");
        progressDoalog.setTitle("Subiendo archivo");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);*/

        progressDoalog = new ProgressDialog(this);
        progressDoalog.setIcon(R.mipmap.ic_launcher);
        progressDoalog.setMessage("Subiendo archivo...");
        button.setOnClickListener(this);

    }

    @Override
    public void cargaDatos() {

    }

    @Override
    public void registraComentario(int idComentario, String comentario) {

    }

    @Override
    public void updateProgress(boolean enabled) {

    }

    @Override
    public void muestraDatos(List<ComentarioDTO> datos) {

    }

    @Override
    public void muestraError(MensajeDTO mensaje) {

    }

    @Override
    public void errorToken(MensajeDTO mensaje) {

    }

    @Override
    public void muestraMensajeImagen(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        progressDoalog.dismiss();


    }

    @Override
    public void onClick(View v) {
        if (archivos.checkAudioPermission(this)) {
            archivos.openDocument(this);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    IMAGE_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case IMAGE_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Aquí lo que se hace si aceptan el permiso
                    archivos.openGallery(this);

                } else {
                    Toast.makeText(this, "Los permisos son necesarios para seleccionar una imagen", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            Uri uri = data.getData();
            assert uri != null;
            switch (requestCode) {
                case IMAGE_CODE:
                case AUDIO_CODE:
                case VIDEO_CODE:
                    //ruta = archivos.rutaArchivo(uri, filePathColumn, this);
                    //nombre = archivos.nombreArchivo(uri, this);
                    //System.out.println("Nombre: " + nombre + "\n Ruta: " + ruta);



                    break;
                case ARCHIVO_CODE:
                    Uri content_describer = data.getData();
                    getArchivo(content_describer);
                    String rutaArchivo = archivos.rutaArchivo(uri, filePathColumn, this);
                    String nombreArchivo = archivos.nombreArchivo(uri, this);

                    System.out.println("Nombre: " + nombreArchivo + "\n Ruta: " + rutaArchivo);
                    break;
            }
        }
    }

    private void getArchivo(Uri content_describer) {
        BufferedReader reader = null;
        try {
            InputStream in = getContentResolver().openInputStream(content_describer);
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            System.out.println("Tamaño: "+builder);
            presenter.cargaImagen(ruta, nombre);
            progressDoalog.show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class UploadFilesTask extends AsyncTask<URL, Long, Void> {

        @Override
        protected Void doInBackground(URL... urls) {

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Long... values) {
        }
    }
}
