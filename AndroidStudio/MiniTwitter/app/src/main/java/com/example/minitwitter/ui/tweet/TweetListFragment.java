package com.example.minitwitter.ui.tweet;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minitwitter.R;
import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.data.TweetViewModel;
import com.example.minitwitter.retrofit.AuthTwitterClient;
import com.example.minitwitter.retrofit.AuthTwitterService;
import com.example.minitwitter.retrofit.response.Tweet;


import java.util.List;


public class TweetListFragment extends Fragment {


    private int tweetListType = 1;
    RecyclerView recyclerView;
    MyTweetRecyclerViewAdapter adapter;
    List<Tweet> tweetList;
    AuthTwitterService authTwitterService;
    AuthTwitterClient authTwitterClient;

    TweetViewModel tweetViewModel;
    SwipeRefreshLayout swipeRefreshLayout;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TweetListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TweetListFragment newInstance(int tweetListType) {
        TweetListFragment fragment = new TweetListFragment();
        Bundle args = new Bundle();
        args.putInt(Constantes.TWEET_LIST_TYPE, tweetListType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tweetViewModel = ViewModelProviders.of(getActivity())
                .get(TweetViewModel.class);

        if (getArguments() != null) {
            tweetListType = getArguments().getInt(Constantes.TWEET_LIST_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_list, container, false);

        // Set the adapter
            Context context = view.getContext();
             recyclerView = view.findViewById(R.id.list);
             swipeRefreshLayout = view.findViewById(R.id.swiperefreshlayout);

             swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimaryDark));

             swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                 @Override
                 public void onRefresh() {

                     if (tweetListType == Constantes.TWEET_LIST_ALL) {

                         loadNewData();

                     }else if(tweetListType == Constantes.TWEET_LIST_FAVS){
                         loadNewFavData();
                     }

                 }
             });

             recyclerView.setLayoutManager(new LinearLayoutManager(context));


            adapter = new MyTweetRecyclerViewAdapter(
                    getActivity(),
                    tweetList
            );
            recyclerView.setAdapter(adapter);

            if (tweetListType == Constantes.TWEET_LIST_ALL) {

                loadTweetData();

            }else if(tweetListType == Constantes.TWEET_LIST_FAVS){
                loadFavNewData();
            }

        return view;
    }

    private void loadNewFavData() {

        tweetViewModel.getNewFavsTweets().observe(getActivity(), new Observer<List<Tweet>>() {
            @Override
            public void onChanged(List<Tweet> tweets) {
                tweetList = tweets;
                    swipeRefreshLayout.setRefreshing(false);
                    adapter.setData(tweetList);
                    tweetViewModel.getNewFavsTweets().removeObserver(this);
            }
        });
    }

    private void loadFavNewData() {

        tweetViewModel.getFavsTweets().observe(getActivity(), new Observer<List<Tweet>>() {
            @Override
            public void onChanged(List<Tweet> tweets) {
                tweetList = tweets;
                adapter.setData(tweetList);
            }
        });


    }


    private void loadTweetData() {

        tweetViewModel.getTweets().observe(getActivity(), new Observer<List<Tweet>>() {
            @Override
            public void onChanged(List<Tweet> tweets) {
                tweetList = tweets;
                adapter.setData(tweetList);
            }
        });

    }

    private void loadNewData() {

        tweetViewModel.getNewTweets().observe(getActivity(), new Observer<List<Tweet>>() {
            @Override
            public void onChanged(List<Tweet> tweets) {
                tweetList = tweets;
                swipeRefreshLayout.setRefreshing(false);
                adapter.setData(tweetList);

                //Eliminar este observador en el que nos encontramos
                tweetViewModel.getNewTweets().removeObserver(this);
            }
        });

    }


}
