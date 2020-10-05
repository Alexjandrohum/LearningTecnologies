package com.example.minitwitter.data;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.minitwitter.retrofit.response.Tweet;
import com.example.minitwitter.ui.BottomModal.BottonModalTweetFragment;

import java.util.List;

public class TweetViewModel extends AndroidViewModel {

    private TweetRepository tweetRepository;
    private LiveData<List<Tweet>> tweets;
    private LiveData<List<Tweet>> fabTweets;

    public TweetViewModel(@NonNull Application application) {

        super(application);
        tweetRepository = new TweetRepository();
        tweets = tweetRepository.getAllTweets();
    }


    public LiveData<List<Tweet>> getTweets(){return tweets;}

    public LiveData<List<Tweet>> getFavsTweets(){
        fabTweets = tweetRepository.getFavsTweet();
        return fabTweets;
    }

    public LiveData<List<Tweet>> getNewTweets(){

        tweets = tweetRepository.getAllTweets();

        return tweets;
    }

    public LiveData<List<Tweet>> getNewFavsTweets(){

        getNewTweets();
        return getFavsTweets();
    }

    public void insertTweet(String mensaje){
        tweetRepository.creatTweet(mensaje);
    }


    public void deleteTweet(int idTweet){
        tweetRepository.deleteTweet(idTweet);
    }


    public void likeTweet( int idTweet){
        tweetRepository.likeTweet(idTweet);
    }


    public void opendialogTweetMenu(Context ctx, int idTweet){

        BottonModalTweetFragment dialogFragment = BottonModalTweetFragment.newInstance(idTweet);

        dialogFragment.show(((AppCompatActivity)ctx).getSupportFragmentManager(), "opendialogTweetMenu");


    }

}
