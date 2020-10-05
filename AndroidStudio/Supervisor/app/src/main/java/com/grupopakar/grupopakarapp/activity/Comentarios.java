package com.grupopakar.grupopakarapp.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.adapter.ComentariosAdapter;
import com.grupopakar.grupopakarapp.contract.ComentariosContract;
import com.grupopakar.grupopakarapp.dao.ComentariosDAOImpl;
import com.grupopakar.grupopakarapp.dto.ComentarioDTO;
import com.grupopakar.grupopakarapp.dto.MensajeDTO;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.presenter.ComentariosPresenterImpl;
import com.grupopakar.grupopakarapp.util.Archivos;
import com.grupopakar.grupopakarapp.util.Mensaje;
import com.grupopakar.grupopakarapp.util.SessionManager;
import com.grupopakar.grupopakarapp.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.grupopakar.grupopakarapp.util.Constante.ARCHIVO_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.AUDIO_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.IMAGE_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.VIDEO_CODE;

public class Comentarios extends AppCompatActivity implements ComentariosContract.ComentariosView, View.OnClickListener {
    private SessionManager session;
    private TiendaDTO tienda;
    private ComentariosPresenterImpl presenter;

    private ProgressBar progressBar;
    private RecyclerView rv;
    private ComentariosAdapter adapter;
    private Animation posiScroll;
    private ImageButton imageButton;
    private ImageView imageButtonSend;
    private TextInputEditText etComentario;
    private AlertDialog alertDialog;
    private int PICK_IMAGE;
    private ImageView archivoImage;

    private Uri imagenUri;
    private String CARPETA_RAIZ = "MisFotos";
    private String CARPETAS_IMAGENES = "imagenes";
    private String RUTA_IMAGEN = CARPETA_RAIZ + CARPETAS_IMAGENES;
    private String path;
    BottomSheetDialog mBottomSheetDialog;
    Archivos archivos;

    private final static int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static String[] PERMISOS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    String[] filePathColumn = {
            MediaStore.Audio.Media.DATA,
            MediaStore.Video.Media.DATA,
            MediaStore.Images.Media.DATA};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);
        setupComponentes();
        cargaDatos();
    }

    private void permisos() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, PERMISOS, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mBottomSheetDialog.show();
        } else {
            Toast.makeText(this, "Los permisos son necesarios, para adjuntar un archivo", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupComponentes() {
        tienda = (TiendaDTO) Util.getParametro(this, "tienda");
        session = new SessionManager(this);
        presenter = new ComentariosPresenterImpl(this, new ComentariosDAOImpl());
        archivos = new Archivos();
        mBottomSheetDialog = new BottomSheetDialog(this);
        View view = View.inflate(this, R.layout.fragment_archivos, null);
        mBottomSheetDialog.setContentView(view);
        ImageView imageViewPhoto = view.findViewById(R.id.acctionFoto);
        ImageView imageViewDocumento = view.findViewById(R.id.actionDocumento);
        ImageView imageViewMusic = view.findViewById(R.id.actionAudio);
        ImageView imageViewVide = view.findViewById(R.id.acctionVideo);
        archivoImage = findViewById(R.id.archivoImage);
        imageViewDocumento.setOnClickListener(this);
        imageViewPhoto.setOnClickListener(this);
        imageViewMusic.setOnClickListener(this);
        imageViewVide.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        progressBar = findViewById(R.id.progressBar);
        rv = findViewById(R.id.rv);
        posiScroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_down);
        etComentario = findViewById(R.id.etComentario);
        TextView tvNombreTienda = findViewById(R.id.tvNombreTienda);
        TextView tvCiudad = findViewById(R.id.tvCiudad);
        TextView tvTipo = findViewById(R.id.tvTipo);
        ImageView mImageView = findViewById(R.id.ivPicPhoto);
        imageButton = findViewById(R.id.imageButton);
        imageButtonSend = findViewById(R.id.imageButtonSend);
        TextView tvSupervisor = findViewById(R.id.tvSupervisor);
        tvNombreTienda.setText(getString(R.string.lb_info_tienda_almacen, tienda.getNombreTienda(), tienda.getCveTienda()));
        tvCiudad.setText(tienda.getCiudad());
        tvTipo.setText(getString(R.string.lb_info_tipo_ciudad, tienda.getTipoTienda(), tienda.getCiudad()));
        tvSupervisor.setText(getString(R.string.lb_supervisor_tienda, tienda.getSupervisor()));
        adapter = new ComentariosAdapter(this, new ArrayList<ComentarioDTO>());
        rv.setAdapter(adapter);
        imageButton.setOnClickListener(this);
        imageButtonSend.setOnClickListener(this);
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
    public void cargaDatos() {
        try {
            if (Util.isConnected(this)) {
                presenter.cargaDatos(session.getToken(), tienda.getIdTienda());
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void registraComentario(int idComentario, String comentario) {
        try {
            if (Util.isConnected(this)) {
                presenter.registraComentario(session.getToken(), new ComentarioDTO(idComentario, tienda.getIdTienda(), comentario));
            } else Mensaje.muestraMensajeCorto(this, R.string.mensaje_no_internet);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void updateProgress(boolean enabled) {
        progressBar.setVisibility(enabled ? GONE : VISIBLE);
        rv.setVisibility(enabled ? VISIBLE : GONE);
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
    public void muestraMensajeImagen(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                permisos();
                break;
            case R.id.imageButtonSend:
                enviarComentario();
                break;
            case R.id.acctionFoto:
                archivos.openGallery(this);
                mBottomSheetDialog.dismiss();
                break;
            case R.id.actionDocumento:
                archivos.openDocument(this);
                mBottomSheetDialog.dismiss();
                break;
            case R.id.actionAudio:
                archivos.openMusic(this);
                mBottomSheetDialog.dismiss();
                break;
            case R.id.acctionVideo:
                archivos.openVideo(this);
                mBottomSheetDialog.dismiss();
                break;
        }
    }

    private void enviarComentario(){
        if (!TextUtils.isEmpty(etComentario.getText())) {
            registraComentario(0, etComentario.getText().toString());
            etComentario.setText(null);
        } else {
            Mensaje.muestraMensajeCorto(this, getString(R.string.error_campo_vacio));
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
                    String ruta = archivos.rutaArchivo(uri, filePathColumn, this);
                    System.out.println("Ruta **: " + ruta);
                    archivoImage.setVisibility(VISIBLE);
                    archivoImage.setImageURI(uri);
                    break;
                case ARCHIVO_CODE:
                    Uri content_describer = data.getData();
                    getArchivo(content_describer);
                    break;
            }
        }
    }

    @Override
    public void muestraDatos(List<ComentarioDTO> datos) {
        adapter.setItems(datos);
        rv.scrollToPosition(datos.size() - 1);
        rv.startAnimation(posiScroll);
    }

    public void capturePhoto(String targetFilename) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //intent.putExtra(MediaStore.EXTRA_OUTPUT,
        //      Uri.withAppendedPath(locationForPhotos, targetFilename));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 8);
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
            System.out.println("getArchivo " + builder.toString());
            System.out.println("InputStream: "+in);
            //presenter.cargaImagen(in,"Archivo1");

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
}
