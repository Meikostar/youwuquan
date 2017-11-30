package com.ningchuang.youwuquan.ui.me.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.adapter.AlbumAdapter;
import com.ningchuang.youwuquan.ui.me.adapter.MyPhotoAdapter;
import com.ningchuang.youwuquan.view.DivItemDecoration;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PublicAlbumActivity extends BaseActivity implements AlbumAdapter.SetOnNearbyPeopleClick {


    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.rlv_album_people)
    RecyclerView mSuperRecyclerView;
    private int type=1;//1表示公开2表示私有
    private LinearLayoutManager mLinearLayoutManager;
    @Override
    public int getLayoutId() {
        return R.layout.activity_public_album;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 1);
        if(type!=1){
            navigationBar.setNaviTitle("私密相册");
        }
        navigationBar.setNavigationBarListener(this);
        AlbumAdapter mAdapter = new AlbumAdapter(null, this,this);
        mSuperRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mSuperRecyclerView.setAdapter(mAdapter);

    }

    private List<String> list = new ArrayList<>();
    private int currpage;




    @Override
    public void onNearbyPeopleClick(View view, Object o, int pos) {
      startActivity(ImageListWitesActivity.class);
    }
}
