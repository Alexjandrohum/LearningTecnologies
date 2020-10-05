package com.example.minitwitter.common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String APP_SETTINGS_FILE  = "APP_SETTINGS";

    private SharedPreferencesManager(){}

    private static SharedPreferences getSharedPrefernces(){
        return  MyApp.getContext().getSharedPreferences(APP_SETTINGS_FILE, Context.MODE_PRIVATE);
    }

    public static void setSomeStringValue(String dataLabel, String dataValue){
        SharedPreferences.Editor editor = getSharedPrefernces().edit();
        editor.putString(dataLabel, dataValue);
        editor.commit();
    }

    public static void setSomeBooleanValue(String dataLabel, boolean dataValue){
        SharedPreferences.Editor editor = getSharedPrefernces().edit();
        editor.putBoolean(dataLabel, dataValue);
        editor.commit();
    }


    public static String getSomeStringValue(String dateLabel){
        return getSharedPrefernces().getString(dateLabel, null);
    }

    public static boolean getSomeBooleanValue(String dataLabel){
        return getSharedPrefernces().getBoolean(dataLabel, false);
    }
}
