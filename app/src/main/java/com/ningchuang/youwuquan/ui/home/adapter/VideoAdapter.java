package com.ningchuang.youwuquan.ui.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ningchuang.youwuquan.ui.home.fragment.HDVFragment;
import com.ningchuang.youwuquan.ui.home.fragment.VRFragment;

/**
 * Created by ${diego} on 2017/11/21.
 */

public class VideoAdapter extends FragmentPagerAdapter{
    private String[] title;
    private FragmentManager fm;
    public VideoAdapter(FragmentManager fm , String[] title) {
        super(fm);
        this.fm = fm;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return  new HDVFragment();
        }
        return new VRFragment();
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
