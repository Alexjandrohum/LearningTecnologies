package com.grupopakar.grupopakarapp.util;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;

import androidx.core.content.ContextCompat;

import static com.grupopakar.grupopakarapp.util.Constante.ARCHIVO_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.AUDIO_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.IMAGE_CODE;
import static com.grupopakar.grupopakarapp.util.Constante.VIDEO_CODE;

public class Archivos {

    public void openGallery(Activity activity) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        activity.startActivityForResult(gallery, IMAGE_CODE);
    }

    public void openMusic(Activity activity) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(gallery, AUDIO_CODE);
    }

    public void openVideo(Activity activity) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        activity.startActivityForResult(gallery, VIDEO_CODE);
    }

    public void openDocument(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(intent, ARCHIVO_CODE);
    }

    public String rutaArchivo(Uri uri, String[] media, Activity activity) {
        String fotoPath = null;
        Cursor cursor = activity.getContentResolver().query(uri,
                media, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int archivoIndex = cursor.getColumnIndex(media[0]);
            fotoPath = cursor.getString(archivoIndex);
            cursor.close();
        }
        return fotoPath;
    }

    public String nombreArchivo(Uri uri, Activity activity) {
        String displayName = null;
        try (Cursor cursor = activity.getApplication().getContentResolver().query(uri, null, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                displayName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                cursor.close();
            }
        } catch (Exception e) {
            Log.e("TAG", e.getMessage());
        }
        return displayName;
    }
    public boolean checkAudioPermission(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.MEDIA_CONTENT_CONTROL) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
