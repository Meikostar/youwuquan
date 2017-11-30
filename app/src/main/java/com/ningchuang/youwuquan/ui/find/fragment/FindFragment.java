package com.ningchuang.youwuquan.ui.find.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.find.adapter.MyPagerAdapter;
import com.zqd.common.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FindFragment extends BaseFragment {


    @Bind(R.id.find_tab_title)
    SlidingTabLayout mTab_Title;
    @Bind(R.id.find_viewpager_show)
    ViewPager mViewpager_Show;


    List<Fragment> mList;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_find;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mList = new ArrayList<Fragment>();
        mList.add(new Tuijian_fragment_Find());
        mList.add(new Guanzhu_fragment_Find());
        MyPagerAdapter mAdapter = new MyPagerAdapter(getFragmentManager(), (ArrayList<Fragment>) mList);
        mViewpager_Show.setAdapter(mAdapter);
        mTab_Title.setViewPager(mViewpager_Show, new String[]{"推荐", "关注"}, getActivity(), (ArrayList<Fragment>) mList);
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
