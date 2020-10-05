package com.example.minitwitter.data;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.common.MyApp;
import com.example.minitwitter.common.SharedPreferencesManager;
import com.example.minitwitter.retrofit.AuthTwitterClient;
import com.example.minitwitter.retrofit.AuthTwitterService;
import com.example.minitwitter.retrofit.request.RequestCreateTweet;
import com.example.minitwitter.retrofit.response.Like;
import com.example.minitwitter.retrofit.response.Tweet;
import com.example.minitwitter.retrofit.response.TweetDeleted;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TweetRepository {

    AuthTwitterService authTwitterService;
    AuthTwitterClient authTwitterClient;
    MutableLiveData<List<Tweet>> allTweets;
    MutableLiveData<List<Tweet>> favTweets;
    String username;


    TweetRepository(){

        authTwitterClient = AuthTwitterClient.getInstance();
        authTwitterService = authTwitterClient.getAuthTwitterService();
        allTweets = getAllTweets();
        username = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_USERNAME);
    }


    public  MutableLiveData<List<Tweet>> getAllTweets(){


        if (allTweets == null){
            allTweets = new MutableLiveData<>();
        }

        Call<List<Tweet>> call = authTwitterService.getAllTweets();
        call.enqueue(new Callback<List<Tweet>>() {
            @Override
            public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {

                // Log.d("TAG","Obteniendo respuesta: "+response);
                // Log.d("TAG","Obteniendo respuesta Body: "+response.body());

                if(response.isSuccessful()){
                    allTweets.setValue(response.body());


                }else {
                    Toast.makeText(MyApp.getContext(), "Algo ha ido mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Tweet>> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });

        return allTweets;

    }


    public MutableLiveData<List<Tweet>> getFavsTweet(){
        if (favTweets == null){
            favTweets = new MutableLiveData<>();
        }

        List<Tweet> newFavList = new ArrayList<>();
        Iterator itTweet = allTweets.getValue().iterator();

        while (itTweet.hasNext()){
            Tweet current = (Tweet) itTweet.next();
            Iterator itLikes = current.getLikes().iterator();

            boolean enc = false;
            while (itLikes.hasNext() && !enc){
                Like like = (Like)itLikes.next();
                if (like.getUsername().equals(username)){
                    enc = true;
                    newFavList.add(current);
                }
            }
        }


        favTweets.setValue(newFavList);

        return favTweets;


        }



    public void creatTweet(String mensaje){
        RequestCreateTweet requestCreateTweet = new RequestCreateTweet(mensaje);
        Call<Tweet> call = authTwitterService.createTweet(requestCreateTweet);
        call.enqueue(new Callback<Tweet>() {
            @Override
            public void onResponse(Call<Tweet> call, Response<Tweet> response) {
                if (response.isSuccessful()){

                    List<Tweet> listaClonada = new ArrayList<>();
                    //Añadimos en primer lugar el nuevo tweet que nos llega del servidor
                    listaClonada.add(response.body());
                    for (int i = 0; i<allTweets.getValue().size(); i++){
                        listaClonada.add(new Tweet(allTweets.getValue().get(i)));
                    }

                    allTweets.setValue(listaClonada);



                }else {
                    Toast.makeText(MyApp.getContext(), "Algo a ido mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Tweet> call, Throwable t) {

                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }



    public void deleteTweet(final int idTweet){
        Call<TweetDeleted> call = authTwitterService.deleteTweet(idTweet);
        call.enqueue(new Callback<TweetDeleted>() {
            @Override
            public void onResponse(Call<TweetDeleted> call, Response<TweetDeleted> response) {
                if (response.isSuccessful()){

                    List<Tweet> clonedTweet = new ArrayList<>();
                    for (int i = 0; i< allTweets.getValue().size(); i++){
                        if (allTweets.getValue().get(i).getId() != idTweet){
                            clonedTweet.add(new Tweet(  allTweets.getValue().get(i)));
                        }
                    }

                    allTweets.setValue(clonedTweet);
                    getFavsTweet();

                }else{
                    Toast.makeText(MyApp.getContext(), "Algo a ido mal", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<TweetDeleted> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void likeTweet(final int idTweet){


        Call<Tweet> call = authTwitterService.likeTweet(idTweet);
        call.enqueue(new Callback<Tweet>() {
            @Override
            public void onResponse(Call<Tweet> call, Response<Tweet> response) {
                if (response.isSuccessful()){

                    List<Tweet> listaClonada = new ArrayList<>();

                    for (int i = 0; i<allTweets.getValue().size(); i++){

                        if (allTweets.getValue().get(i).getId() == idTweet){

                            // Si hemos encontrado en la lista orignal
                            // el elemento sobre el que hemos echo like,
                            // introducimos el elemento que nos ha llegado del servidor

                            listaClonada.add(response.body());

                        }else {

                            listaClonada.add(new Tweet(allTweets.getValue().get(i)));
                        }
                    }


                    allTweets.setValue(listaClonada);
                    getFavsTweet();

                }else {
                    Toast.makeText(MyApp.getContext(), "Algo a ido mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Tweet> call, Throwable t) {

                Toast.makeText(MyApp.getContext(), "Error en la conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }



}
