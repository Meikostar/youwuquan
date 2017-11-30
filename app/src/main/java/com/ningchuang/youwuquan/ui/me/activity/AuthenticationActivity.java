package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.adapter.Icon_me_Adapter;
import com.ningchuang.youwuquan.ui.me.bean.IconBean;
import com.zqd.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthenticationActivity extends BaseActivity {
    @Bind(R.id.renzheng_me_back)
    ImageView renzhengMeBack;
    @Bind(R.id.renzheng_me_tubiao)
    RecyclerView renzhengMeTubiao;

    private List<IconBean> icon_pic = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_authentication;
    }

    @Override
    public void initPresenter() {
        icon_pic = new ArrayList<>();
        icon_pic.add(new IconBean(R.mipmap.me_a_none, "运动达人"));
        icon_pic.add(new IconBean(R.mipmap.me_d_none, "摄影达人"));
        icon_pic.add(new IconBean(R.mipmap.me_r, "网红"));
        icon_pic.add(new IconBean(R.mipmap.me_v, "尤物女神"));
        icon_pic.add(new IconBean(R.mipmap.me_r, "网红"));
        icon_pic.add(new IconBean(R.mipmap.me_d_none, "摄影达人"));
        icon_pic.add(new IconBean(R.mipmap.me_d_none, "摄影达人"));
        icon_pic.add(new IconBean(R.mipmap.me_v, "尤物女神"));
        icon_pic.add(new IconBean(R.mipmap.me_d_none, "摄影达人"));
        icon_pic.add(new IconBean(R.mipmap.comming, "敬请期待"));

    }

    @Override
    public void initView() {
        renzhengMeTubiao.setLayoutManager(new GridLayoutManager(this, 4));
        Icon_me_Adapter mAdapter = new Icon_me_Adapter(this,icon_pic);
        renzhengMeTubiao.setAdapter(mAdapter);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.renzheng_me_back)
    public void onViewClicked() {
    }
}
