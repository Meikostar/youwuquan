package com.ningchuang.youwuquan.ui.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.activity.NearbyActivity;
import com.ningchuang.youwuquan.ui.home.adapter.ActorAdapter;
import com.ningchuang.youwuquan.ui.home.adapter.NearbyAdapter;
import com.ningchuang.youwuquan.ui.home.adapter.WangHAdapter;
import com.ningchuang.youwuquan.ui.home.bean.ActorBean;
import com.ningchuang.youwuquan.ui.home.bean.NearbyBean;
import com.ningchuang.youwuquan.ui.home.bean.WanghBean;
import com.zqd.common.base.BaseFragment;
import com.zqd.common.baseapp.AppConfig;
import com.zqd.common.baserx.RxBus;
import com.zqd.common.utils.ImageLoaderUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FakeHomeFragment extends BaseFragment implements WangHAdapter.SetOnWanghClick, ActorAdapter.SetOnActorClick, NearbyAdapter.SetOnNearbyClick {


    @Bind(R.id.iv_home_tou)
    ImageView ivHomeTou;
    @Bind(R.id.rlv_home_wangh)
    RecyclerView rlvHomeWangh;
    @Bind(R.id.rlv_home_actor)
    RecyclerView rlvHomeActor;
    @Bind(R.id.rlv_home_nearby)
    RecyclerView rlvHomeNearby;
    @Bind(R.id.nsv_fake_home)
    NestedScrollView nsvFakeHome;
    @Bind(R.id.llt_fake_home)
    LinearLayout lltFakeHome;

    private WangHAdapter wangHAdapter = null;
    private List<WanghBean> wangBeanList = new ArrayList<>();
    private List<ActorBean> actorBeanList = new ArrayList<>();
    private ActorAdapter actorAdapter = null;
    private NearbyAdapter nearbyAdapter = null;
    private List<NearbyBean> nearbyBeanList = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_fake_home;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        wangBeanList.add(new WanghBean());
        wangBeanList.add(new WanghBean());

        actorBeanList.add(new ActorBean());
        actorBeanList.add(new ActorBean());

        nearbyBeanList.add(new NearbyBean());
        nearbyBeanList.add(new NearbyBean());
        nearbyBeanList.add(new NearbyBean());
        nearbyBeanList.add(new NearbyBean());
        nearbyBeanList.add(new NearbyBean());
        nearbyBeanList.add(new NearbyBean());
        nearbyBeanList.add(new NearbyBean());
        nearbyBeanList.add(new NearbyBean());
        ImageLoaderUtils.display(getActivity(), ivHomeTou, R.mipmap.home_test);

        nsvFakeHome.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        y1 = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        y2 = motionEvent.getY();
                        if (y2-y1 >0) {

                            mRxManager.post("bottom", "bottom");
                        }else {
                            mRxManager.post("bottom", "top");
                        }
                        break;
                }
                return false;
            }
        });
        initRec();
    }


    @Override
    protected void lazyLoad() {

    }

    private void initRec() {
        wangHAdapter = new WangHAdapter(wangBeanList, this);
        wangHAdapter.setContext(getActivity());
        rlvHomeWangh.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager wangHManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rlvHomeWangh.setLayoutManager(wangHManager);
        rlvHomeWangh.setAdapter(wangHAdapter);

        actorAdapter = new ActorAdapter(actorBeanList, this);
        actorAdapter.setContext(getActivity());
        LinearLayoutManager actorManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rlvHomeActor.setItemAnimator(new DefaultItemAnimator());
        rlvHomeActor.setLayoutManager(actorManager);
        rlvHomeActor.setAdapter(actorAdapter);

        nearbyAdapter = new NearbyAdapter(nearbyBeanList, this);
        nearbyAdapter.setContext(getActivity());
        rlvHomeNearby.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager nearbyManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rlvHomeNearby.setLayoutManager(nearbyManager);
        rlvHomeNearby.setAdapter(nearbyAdapter);
    }


    @OnClick({R.id.rlt_home_wangh_more, R.id.rlt_home_actor_more, R.id.rlt_home_nearby_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rlt_home_wangh_more:
                // TODO: 2017/11/7  网红更多
                mRxManager.post("bottom", "bottom");
                mRxManager.post("home", AppConfig.RX_WH);
                break;
            case R.id.rlt_home_actor_more:
                // TODO: 2017/11/7 演员更多
                mRxManager.post("bottom", "bottom");
                mRxManager.post("home", AppConfig.RX_ACTOR);
                break;
            case R.id.rlt_home_nearby_more:
                // TODO: 2017/11/7 附近更多
                mRxManager.post("bottom", "bottom");
                getActivity().startActivity(new Intent(getActivity(),NearbyActivity.class));
                break;
        }
    }

    @Override
    public void onWanghClick(View view, Object o, int pos) {

    }

    @Override
    public void onActorClick(View view, Object o, int pos) {

    }

    @Override
    public void onNearbyClick(View view, Object o, int pos) {
        startActivity(NearbyActivity.class);
    }

    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

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
