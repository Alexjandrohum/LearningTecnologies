package com.grupopakar.grupopakarapp.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Comentarios;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.CompositePermissionListener;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArchivosFragment extends DialogFragment implements View.OnClickListener, PermissionListener  {
    private Context context;
    private View source;
    private ImageView imageViewFoto;
    private ImageView imageViewVideo;
    private ImageView imageViewAudio;
    private ImageView imageViewSdocumento;
    private PermissionListener allPermissionListener;
    private static Uri uri;
    private String fotoPath;




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_archivos, container, false);
        imageViewFoto = view.findViewById(R.id.acctionFoto);
        imageViewFoto.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.acctionFoto:
                Toast.makeText(context, "foto", Toast.LENGTH_SHORT).show();
                cargarImagen();
                break;
        }
    }

    private void cargarImagen() {
        PermissionListener dialogOnDeniedPermissionListener =
                (PermissionListener) DialogOnDeniedPermissionListener.Builder.withContext(context)
                        .withTitle("Permisos")
                        .withMessage("Los permisos son necesarios para seleccionar la foto")
                        .withButtonText("Aceptar")
                        .withIcon(R.mipmap.ic_launcher)
                        .build();


        allPermissionListener = new CompositePermissionListener(
                ArchivosFragment.this,
                dialogOnDeniedPermissionListener
        );

        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(allPermissionListener)
                .check();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == 1) {
                if (data != null) {
                    Uri imagenSeleccionada = data.getData();


                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = context.getContentResolver().query(imagenSeleccionada,
                            filePathColumn, null, null, null);

                    if (cursor != null) {
                        cursor.moveToFirst();
                        int imagenIndex = cursor.getColumnIndex(filePathColumn[0]);
                        fotoPath = cursor.getString(imagenIndex);
                        //uploadPhoto(fotoPath, imagenSeleccionada);
                        //mImageView.setImageURI(imagenSeleccionada);
                        //etComentario.setText(fotoPath);
                        //uri = imagenSeleccionada;
                        cursor.close();
                    }
                }
            }
        }
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
        Intent seleccionarFoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(seleccionarFoto, 1);
        dismiss();
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {

        Toast.makeText(getActivity(), "Denegado", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

    }
}
