package com.ningchuang.youwuquan.ui.home.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.adapter.YouwuAdapter;
import com.ningchuang.youwuquan.ui.home.bean.ActorBean;
import com.ningchuang.youwuquan.ui.home.bean.NearbyBean;
import com.ningchuang.youwuquan.view.DivItemDecoration;
import com.zqd.common.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActorFragment extends BaseFragment implements YouwuAdapter.SetOnActorClick {


    @Bind(R.id.line)
    View line;
    @Bind(R.id.super_recycle_view)
    SuperRecyclerView mSuperRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private SwipeRefreshLayout.OnRefreshListener refreshListener;
    private List<ActorBean> nearbyBeanList = new ArrayList<>();
    private final int TYPE_PULL_REFRESH = 1;
    private final int TYPE_PULL_MORE = 2;
    private final int TYPE_REMOVE = 3;
    private  int type = 0;//表示尤物1表示网红
    private YouwuAdapter adapter;
    public void setType(int type){
      this.type=type;
    }
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_actor;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mSuperRecyclerView.setLayoutManager(mLinearLayoutManager);
        mSuperRecyclerView.addItemDecoration(new DivItemDecoration(2, true));
        mSuperRecyclerView.getMoreProgressView().getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;

        refreshListener = new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
//                  mSuperRecyclerView.showMoreProgress();

//                if (type == 1) {
//                    model.getIndepnetOrderList(status, 1, count, TYPE_PULL_REFRESH, OrderFragments.this);
//                } else {
//                    model.getOrderList(status, 1, count, TYPE_PULL_REFRESH, OrderFragments.this);
//                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSuperRecyclerView.hideMoreProgress();
//                        LogUtils.e("result", "name2");
                    }
                }, 1500);
            }
        };
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());
        nearbyBeanList.add(new ActorBean());

        mSuperRecyclerView.setRefreshListener(refreshListener);
        adapter = new YouwuAdapter(nearbyBeanList, this);
        adapter.setContext(getActivity());
        if(type!=0){
            adapter.setNames("新晋网红","推荐网红");
        }
         mSuperRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void lazyLoad() {

    }
    private List<String> list=new ArrayList<>();
    private int currpage;
    public void onDataLoaded(int loadType, final int ServerTotalSize, List<String> datas) {

        if (loadType == TYPE_PULL_REFRESH) {
            currpage = 1;

        } else {

        }
//            adapter.setDatas(list);
//            adapter.notifyDataSetChanged();


        mSuperRecyclerView.hideMoreProgress();

        if (list.size() < ServerTotalSize) {
            mSuperRecyclerView.setupMoreListener(new OnMoreListener() {
                @Override
                public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
                    currpage++;
                    mSuperRecyclerView.showMoreProgress();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                            if (list.size() <= ServerTotalSize)
//                                mSuperRecyclerView.hideMoreProgress();
//                            LogUtils.e("result", "name3");
//                            if (type == 1) {
//                                model.getIndepnetOrderList(status, currpage, count, TYPE_PULL_MORE, OrderFragments.this);
//                            } else {
//                                model.getOrderList(status, currpage, count, TYPE_PULL_MORE, OrderFragments.this);
//                            }

                        }
                    }, 2000);
                }
            }, 1);
        } else {
            mSuperRecyclerView.removeMoreListener();
            mSuperRecyclerView.hideMoreProgress();

        }


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

    @Override
    public void onActorClick(View view, Object o, int pos) {

    }
}
