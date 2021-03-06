package com.example.conectarapi.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceJWT {
    private static final String BASE_URL_JWT = "http://192.168.0.104:6436";
    private static WebServiceJWT instance;
    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

    public WebServiceJWT(){
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_JWT)
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized WebServiceJWT getInstance(){
        if (instance == null){
            instance = new WebServiceJWT();
        }
        return instance;
    }

    public <S> S createService(Class<S> ServiceClass){
        return retrofit.create(ServiceClass);
    }



}
