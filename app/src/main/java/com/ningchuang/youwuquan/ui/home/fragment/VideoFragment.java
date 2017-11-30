package com.ningchuang.youwuquan.ui.home.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.adapter.VideoAdapter;
import com.zqd.common.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment {


    @Bind(R.id.iv_video_tou)
    ImageView ivVideoTou;
    @Bind(R.id.tll_video)
    TabLayout tllVideo;
    @Bind(R.id.vp_video)
    ViewPager vpVideo;
    private String[] title;
    private VideoAdapter videoAdapter;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_video;
    }

    @Override
    public void initPresenter() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initView() {
        title = new String[]{"高清视频","VR视频"};
        videoAdapter = new VideoAdapter(getFragmentManager(),title);

        vpVideo.setAdapter(videoAdapter);

        tllVideo.setupWithViewPager(vpVideo);

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
