package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.adapter.MyPhotoAdapter;
import com.ningchuang.youwuquan.ui.me.bean.AlbumBean;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeAlbumActivity extends BaseActivity {

    @Bind(R.id.navigationBar)
    NavigationBar photoMeBack;
    @Bind(R.id.photo_me_recyc)
    RecyclerView photoMeRecyc;

    private List<AlbumBean> mList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_me_photo;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        photoMeBack.setNavigationBarListener(this);
        mList = new ArrayList<>();
        mList.add(new AlbumBean("头像专辑",""));
        mList.add(new AlbumBean( "可见相册",""));
        mList.add(new AlbumBean( "私密相册",""));


        //设置item间距，30dp

        photoMeRecyc.setLayoutManager(new GridLayoutManager(this, 2));
        MyPhotoAdapter mAdapter = new MyPhotoAdapter(this, mList);
        //设置item间距，30dp
        photoMeRecyc.setAdapter(mAdapter);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
