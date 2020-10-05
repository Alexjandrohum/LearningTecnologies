package com.grupopakar.grupopakarapp.util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by antonio.ruiz on 2019-05-20
 */
public class EmptyCallback<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {}

    @Override
    public void onFailure(Call<T> call, Throwable t) {}
}
