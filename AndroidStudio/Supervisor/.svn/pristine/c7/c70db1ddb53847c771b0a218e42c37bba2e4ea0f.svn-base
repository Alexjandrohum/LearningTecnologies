package com.grupopakar.grupopakarapp.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.grupopakar.grupopakarapp.util.PermissionListener;
import com.grupopakar.grupopakarapp.util.SessionManager;

import static com.grupopakar.grupopakarapp.util.Constante.PERMISSIONS;
import static com.grupopakar.grupopakarapp.util.Constante.PERMISSION_CODE;

public class Splash extends AppCompatActivity implements PermissionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermissions();
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean flag = false;
            for (String s : PERMISSIONS)
                if (checkSelfPermission(s) != PackageManager.PERMISSION_GRANTED) flag = true;
            if (flag) requestPermissions(PERMISSIONS, PERMISSION_CODE);
            else permissionResult(true);
        } else permissionResult(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            boolean flag = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                for (int i = 0, len = permissions.length; i < len; i++)
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) flag = false;
            permissionResult(true);
        }
    }

    @Override
    public void permissionResult(boolean hasPermission) {
        if (new SessionManager(this).isLoggedIn())
            startActivity(new Intent(Splash.this, Inicio.class));
        else if (hasPermission)
            startActivity(new Intent(Splash.this, Login.class));
        finish();
    }
}
