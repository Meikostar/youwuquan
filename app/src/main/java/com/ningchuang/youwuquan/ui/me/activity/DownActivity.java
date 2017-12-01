package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.adapter.AlbumAdapter;
import com.ningchuang.youwuquan.ui.me.adapter.Downdapter;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DownActivity extends BaseActivity implements Downdapter.SetOnPhotoClick {


    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.tv_count)
    TextView tvCount;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.photo_me_recyc)
    RecyclerView photoMeRecyc;

    @Override
    public int getLayoutId() {
        return R.layout.activity_down;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
     navigationBar.setNavigationBarListener(this);
        Downdapter mAdapter = new Downdapter(null, this,this);
        photoMeRecyc.setLayoutManager(new GridLayoutManager(this, 2));
        photoMeRecyc.setAdapter(mAdapter);
    }


    @Override
    public void onPhotoClick(View view, Object o, int pos) {

    }
}
