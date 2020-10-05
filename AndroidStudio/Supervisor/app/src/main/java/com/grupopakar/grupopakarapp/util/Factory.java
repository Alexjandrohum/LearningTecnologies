package com.grupopakar.grupopakarapp.util;

public class Factory {
    /**
     * Cliente de WebService
     * @return instancia de cliente Retrofit.
     */
    public static Object getWS(Class clase) {
        return RetrofitClient.getClient().create(clase);
    }

    public static void closeWS(){
        RetrofitClient.destroyClient();
    }
}
