package com.example.minitwitter.ui.BottomModal;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.minitwitter.R;
import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.data.TweetViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

public class BottonModalTweetFragment extends BottomSheetDialogFragment {

    private TweetViewModel tweetViewModel;
    private int idTweetEliminar;

    public static BottonModalTweetFragment newInstance(int idTweet) {

        BottonModalTweetFragment fragment = new BottonModalTweetFragment();
        Bundle args = new Bundle();
        args.putInt(Constantes.ARG_TWEET_ID, idTweet);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            idTweetEliminar = getArguments().getInt(Constantes.ARG_TWEET_ID);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.botton_modal_tweet_fragment, container, false);

        final NavigationView nav = view.findViewById(R.id.navigation_view_botton_tweet);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.action_delete_tweet){

                    tweetViewModel.deleteTweet(idTweetEliminar);
                    getDialog().dismiss();
                    return true;

                }

                return  false;
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tweetViewModel = ViewModelProviders.of(getActivity()).get(TweetViewModel.class);
        // TODO: Use the ViewModel
    }

}