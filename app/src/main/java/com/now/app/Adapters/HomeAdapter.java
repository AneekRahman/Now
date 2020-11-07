package com.now.app.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.now.app.Classes.HomePost;
import com.now.app.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    private List<Integer> mPostIndicatorIdList = new ArrayList<>();
    private List<HomePost> mHomePostLists;
    private Context mContext;

    public HomeAdapter(List<HomePost> homePostLists, Context context) {

        this.mHomePostLists = homePostLists;
        this.mContext = context;
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        LinearLayout mRootHolder;
        ImageView mDp, mImg;

        public HomeViewHolder(View itemView) {
            super(itemView);

            this.mRootHolder = (LinearLayout) itemView.findViewById(R.id.root);
            this.mDp = (ImageView) itemView.findViewById(R.id.dp);
            this.mImg = (ImageView) itemView.findViewById(R.id.img);


        }
    }

    @Override
    public int getItemViewType(int position) {

        switch (mHomePostLists.get(position).getPostType()) {
            case HomePost.TYPE_IMAGE_POST:
                return HomePost.TYPE_IMAGE_POST;
            case HomePost.TYPE_VIDEO_POST:
                return HomePost.TYPE_VIDEO_POST;
            default:
                return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_post_layout, parent, false);

        return new HomeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        HomePost homePost = mHomePostLists.get(listPosition);

        HomeViewHolder homeViewHolder = (HomeViewHolder) holder;


        if (homePost != null) {

            switch (homePost.getPostType()) {

                case HomePost.TYPE_IMAGE_POST:

                    imageHomePost(homeViewHolder, homePost);

                    break;

                case HomePost.TYPE_VIDEO_POST:

                    videoHomePost(homeViewHolder, homePost);

                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return mHomePostLists.size();
    }

    private void imageHomePost(HomeViewHolder viewHolder, HomePost homePost){

        //viewHolder.itemView;

        Glide.with(mContext)
                .load(homePost.getPostContentUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(viewHolder.mImg);

        Glide.with(mContext)
                .load("https://images.pexels.com/photos/638700/pexels-photo-638700.jpeg?auto=compress&cs=tinysrgb&h=350")
                .apply(RequestOptions.circleCropTransform())
                .into(viewHolder.mDp);


    }

    private void videoHomePost(HomeViewHolder viewHolder, HomePost homePost){


    }

}