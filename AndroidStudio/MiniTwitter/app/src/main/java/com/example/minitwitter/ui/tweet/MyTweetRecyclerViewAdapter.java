package com.example.minitwitter.ui.tweet;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.minitwitter.R;
import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.common.SharedPreferencesManager;
import com.example.minitwitter.data.TweetViewModel;
import com.example.minitwitter.retrofit.response.Like;
import com.example.minitwitter.retrofit.response.Tweet;

import java.util.List;


public class MyTweetRecyclerViewAdapter extends RecyclerView.Adapter<MyTweetRecyclerViewAdapter.ViewHolder> {

    private List<Tweet> mValues;
    private Context ctx;
    String username;
    TweetViewModel tweetViewModel;

    public MyTweetRecyclerViewAdapter(Context context, List<Tweet> items) {
        mValues = items;
        ctx = context;
        username = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_USERNAME);
        tweetViewModel = ViewModelProviders.of((FragmentActivity) ctx).get(TweetViewModel.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if (mValues != null) {
            holder.mItem = mValues.get(position);

            holder.tvUserName.setText("@" + holder.mItem.getUser().getUsername());
            holder.tvMessage.setText(holder.mItem.getMensaje());
            holder.tvLikesCount.setText(String.valueOf(holder.mItem.getLikes().size()));


            String photo = holder.mItem.getUser().getPhotoUrl();

            if (!photo.equals("")) {
                Glide.with(ctx)
                        .load("https://www.minitwitter.com/apiv1/uploads/photos/" + photo)
                        .into(holder.ivAvatar);
            }

            Glide.with(ctx)
                    .load(R.drawable.ic_star_border_black_24dp)
                    .into(holder.ivLike);
            holder.tvLikesCount.setTextColor(ctx.getResources().getColor(R.color.color_azul_dark));
            holder.tvLikesCount.setTypeface(null, Typeface.BOLD);


            holder.ivShowMenu.setVisibility(View.GONE);


            if (holder.mItem.getUser().getUsername().equals(username)){
                holder.ivShowMenu.setVisibility(View.VISIBLE);
            }


            holder.ivShowMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tweetViewModel.opendialogTweetMenu(ctx ,holder.mItem.getId());
                }
            });



            holder.ivLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tweetViewModel.likeTweet(holder.mItem.getId());
                }
            });

            for (Like like : holder.mItem.getLikes()) {
                if (like.getUsername().equals(username)) {
                    Glide.with(ctx)
                            .load(R.drawable.ic_grade_black_24dp)
                            .into(holder.ivLike);
                    holder.tvLikesCount.setTextColor(ctx.getResources().getColor(R.color.colorAccent));
                    holder.tvLikesCount.setTypeface(null, Typeface.BOLD);
                    break;
                }
            }

        }

    }


    public void setData(List<Tweet> tweetList){

        this.mValues = tweetList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {

        if (mValues != null)
            return mValues.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivAvatar;
        public final ImageView ivLike;
        public final ImageView ivShowMenu;
        public final TextView tvUserName;
        public final TextView tvMessage;
        public final TextView tvLikesCount;
        public Tweet mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivAvatar = view.findViewById(R.id.imageViewAvatar);
            ivLike = view.findViewById(R.id.imageViewLike);
            ivShowMenu = view.findViewById(R.id.imageViewShowMenu);
            tvUserName = view.findViewById(R.id.textViewNombre);
            tvMessage = view.findViewById(R.id.textViewMensaje);
            tvLikesCount = view.findViewById(R.id.textViewCount);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvUserName.getText() + "'";
        }
    }
}
