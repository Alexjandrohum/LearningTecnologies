package com.example.retrofit.service;

import com.example.retrofit.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Client {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getResposForUser(@Path("user") String user);
}
