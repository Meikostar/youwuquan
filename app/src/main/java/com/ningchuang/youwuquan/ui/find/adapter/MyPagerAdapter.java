package com.ningchuang.youwuquan.ui.find.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30 0030.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mLists;

    public MyPagerAdapter(FragmentManager fm , ArrayList<Fragment> mLists) {
        super(fm);
        this.mLists = mLists;
    }


    @Override
    public Fragment getItem(int i) {
        return mLists.get(i);
    }

    @Override
    public int getCount() {
        return mLists.size();
    }
}
