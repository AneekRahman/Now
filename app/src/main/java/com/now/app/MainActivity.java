package com.now.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.now.app.Adapters.HomeAdapter;
import com.now.app.Classes.HomePost;
import com.now.app.Classes.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declaring views
    private RecyclerView mRecyclerView;
    private LinearLayout mRecyclerHolder;

    // Declaring recyclerview stuff
    private RecyclerView.LayoutManager mLayoutManager;
    private List<HomePost> mPostList;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerHolder = (LinearLayout) findViewById(R.id.recycler_holder);

        // Transparent status bar
        MyUtils.transpStatusBar(this);
        // Hidden system bars
        MyUtils.showHideSystem(this, true);

        mRecyclerHolder.setPadding(0, MyUtils.getStatusBarHeight(this), 0, MyUtils.getNavBarHeight(this));


        setUpRecycler();
        testPosts();


    }

    private void setUpRecycler(){

        // Assign recyclerview stuff
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mPostList = new ArrayList<>();
        mAdapter = new HomeAdapter(mPostList, this);

        // Setting up the recyclerview
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setFocusable(false);
        mRecyclerView.setNestedScrollingEnabled(false);

    }

    private void testPosts(){

        mPostList.clear();

        HomePost post = new HomePost(HomePost.TYPE_IMAGE_POST, "https://i.pinimg.com/originals/bb/e5/40/bbe540c946a547ec39d8ff63a4625ff5.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "http://wojdylosocialmedia.com/wp-content/uploads/2015/10/IMG_4864.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "http://www.wallpapermaiden.com/wallpaper/20711/download/1080x1920/gigi-hadid-sunglasses-model-red-lipstick-long-hair.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "https://www.hiamag.com/sites/default/files/profile/%20%D8%A7%D8%B1%D8%AA%D8%B4%D9%8A%D9%84.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "https://images.unsplash.com/photo-1537941032657-672864703060?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=4e25dea0cf8dd7808c7bfbdecc6a02a1&dpr=1&auto=format&fit=crop&w=1000&q=80&cs=tinysrgb");
        mPostList.add(post);

        mAdapter.notifyDataSetChanged();

    }


    @Override
    protected void onResume() {
        super.onResume();
        // Hidden system bars
        MyUtils.showHideSystem(this, true);
    }

}
