package com.grupopakar.grupopakarapp.util;

import android.content.res.Resources;
import android.util.Log;

import androidx.multidex.MultiDexApplication;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * Created by antonio.ruiz on 14/05/2018.
 */

public class MyApplication extends MultiDexApplication {
    private static Resources res;

    @Override
    public void onCreate() {
        try {
            Class.forName("android.os.AsyncTask");
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "onCreate: " + e.getMessage());
        }
        res = getResources();
        super.onCreate();
    }

    public static Resources getRes() {
        return res;
    }
}
