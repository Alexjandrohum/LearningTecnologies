package com.grupopakar.grupopakarapp.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class RetrofitClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(Constante.TIME_OUT_CONNECT_HTTP, TimeUnit.MILLISECONDS)
                    .readTimeout(Constante.TIME_OUT_READ_HTTP, TimeUnit.MILLISECONDS)
                    .writeTimeout(Constante.TIME_OUT_READ_HTTP, TimeUnit.MILLISECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constante.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    static void destroyClient() {
        retrofit = null;
    }
}