package com.example.twitter.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.twitter.Model.TwitterModel;
import com.example.twitter.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<TwitterModel> mTweet = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(List<TwitterModel> mTweet, Context mContext) {
        this.mTweet = mTweet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).mName.setText(mTweet.get(position).getName());
        ((ViewHolder)holder).mfavourites.setText(String.valueOf(mTweet.get(position).getFavoriteCount()));
        ((ViewHolder)holder).mdescription.setText(String.valueOf(mTweet.get(position).getText()));
        ((ViewHolder)holder).mhandle.setText(String.valueOf(mTweet.get(position).getHandle()));
        ((ViewHolder)holder).mretweets.setText(String.valueOf(mTweet.get(position).getRetweetCount()));
        // Set the image
        System.out.println(mTweet.get(position).getName());
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
//        Uri uri= Uri.parse(mTweet.get(position).getProfileImageUrl().toString());
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .asBitmap()
                .apply(RequestOptions.circleCropTransform())
                .load(mTweet.get(position).getProfileImageUrl())
                .into(((ViewHolder) holder).mImage);
    }

    @Override
    public int getItemCount() {
        return mTweet.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mImage;
        private TextView mName;
        private TextView mhandle;
        private TextView mretweets;
        private TextView mfavourites;
        private TextView mdescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.name);
            mfavourites = itemView.findViewById(R.id.favourites);
            mhandle = itemView.findViewById(R.id.handle);
            mretweets = itemView.findViewById(R.id.retweets);
            mdescription = itemView.findViewById(R.id.description);

        }
    }

}