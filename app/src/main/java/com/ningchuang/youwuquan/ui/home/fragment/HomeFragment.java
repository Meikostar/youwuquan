package com.ningchuang.youwuquan.ui.home.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.activity.SearchActivity;
import com.zqd.common.base.BaseFragment;
import com.zqd.common.baseapp.AppConfig;
import com.zqd.common.baserx.RxBus;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    @Bind(R.id.tv_home_local)
    TextView tvHomeLocal;
    @Bind(R.id.tv_home_wangh)
    TextView tvHomeWangh;
    @Bind(R.id.v_home_wangh)
    View vHomeWangh;
    @Bind(R.id.tv_home_actor)
    TextView tvHomeActor;
    @Bind(R.id.v_home_actor)
    View vHomeActor;
    @Bind(R.id.tv_home_video)
    TextView tvHomeVideo;
    @Bind(R.id.v_home_video)
    View vHomeVideo;
    @Bind(R.id.fl_home)
    FrameLayout flHome;

    private ActorFragment actorFragment;
    private VideoFragment videoFragment;
    private ActorFragment wangHFragment;
    private FakeHomeFragment fakeHomeFragment;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

        String a = new String("aaaa");
        String b = a;
        Log.e("zhou",b+"..."+a);
        actorFragment = new ActorFragment();
        videoFragment = new VideoFragment();
        wangHFragment = new ActorFragment();
        fakeHomeFragment = new FakeHomeFragment();
        wangHFragment.setType(1);
        initLayout();
        changeFragment(R.id.fl_home,fakeHomeFragment);
        mRxManager.mRxBus.register("home");
        mRxManager.on("home", new Action1<String>() {
            @Override
            public void call(String o) {
                if (AppConfig.RX_HOME.equals(o)){
                    initLayout();
                    changeFragment(R.id.fl_home,fakeHomeFragment);
                }else if(AppConfig.RX_WH.equals(o)){
                    initLayout();
                    tvHomeWangh.setTextColor(Color.parseColor("#f80378"));
                    vHomeWangh.setBackgroundColor(Color.parseColor("#f80378"));
                    changeFragment(R.id.fl_home,actorFragment);
                }else if(AppConfig.RX_ACTOR.equals(o)){
                    initLayout();
                    tvHomeActor.setTextColor(Color.parseColor("#f80378"));
                    vHomeActor.setBackgroundColor(Color.parseColor("#f80378"));
                    changeFragment(R.id.fl_home,wangHFragment);
                }
            }
        });
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

    @OnClick({R.id.rll_home_local, R.id.rll_home_wangh, R.id.rll_home_actor, R.id.rll_home_video, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rll_home_local:

                break;
            case R.id.rll_home_wangh:
                // TODO: 2017/10/30 网红
                initLayout();
                tvHomeWangh.setTextColor(Color.parseColor("#f80378"));
                vHomeWangh.setBackgroundColor(Color.parseColor("#f80378"));
                changeFragment(R.id.fl_home,actorFragment);
                break;
            case R.id.rll_home_actor:
                // TODO: 2017/10/30 演员
                initLayout();
                tvHomeActor.setTextColor(Color.parseColor("#f80378"));
                vHomeActor.setBackgroundColor(Color.parseColor("#f80378"));
                changeFragment(R.id.fl_home,wangHFragment);
                break;
            case R.id.rll_home_video:
                // TODO: 2017/10/30 视频
                initLayout();
                tvHomeVideo.setTextColor(Color.parseColor("#f80378"));
                vHomeVideo.setBackgroundColor(Color.parseColor("#f80378"));
                changeFragment(R.id.fl_home,videoFragment);
                break;
            case R.id.iv_search:
                // TODO: 2017/11/14 搜索
                 startActivity(SearchActivity.class);
                break;
        }
    }
    /*
    初始化layout
     */
    private void initLayout(){
        tvHomeWangh.setTextColor(Color.parseColor("#000000"));
        vHomeWangh.setBackgroundColor(Color.parseColor("#ffffffff"));

        tvHomeActor.setTextColor(Color.parseColor("#000000"));
        vHomeActor.setBackgroundColor(Color.parseColor("#ffffffff"));

        tvHomeVideo.setTextColor(Color.parseColor("#000000"));
        vHomeVideo.setBackgroundColor(Color.parseColor("#ffffffff"));
    }

}
