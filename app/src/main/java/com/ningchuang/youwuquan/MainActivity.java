package com.ningchuang.youwuquan;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ningchuang.youwuquan.bean.TabEntity;
import com.ningchuang.youwuquan.ui.find.fragment.FindFragment;
import com.ningchuang.youwuquan.ui.home.fragment.HomeFragment;
import com.ningchuang.youwuquan.ui.me.fragement.MeFragment;
import com.ningchuang.youwuquan.ui.news.fragment.NewFragment;
import com.ningchuang.youwuquan.ui.upload.fragment.UpLoadFragment;
import com.ningchuang.youwuquan.utils.AnimationUtil;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.baseapp.AppConfig;

import java.util.ArrayList;

import rx.functions.Action1;

public class MainActivity extends BaseActivity {

    private String[] mTitles = {"首页", "发现", "上传", "消息", "我的"};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_ture, R.mipmap.ic_find_ture, R.mipmap.ic_upload, R.mipmap.ic_new_ture, R.mipmap.ic_me_ture};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_false, R.mipmap.ic_find_false, R.mipmap.ic_upload, R.mipmap.ic_new_false, R.mipmap.ic_me_false};
    private ViewStub content_viewstub;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View inflate;
    private CommonTabLayout tabLayout;
    private Bundle savedInstanceState1;

    private FindFragment findFragment;
    private HomeFragment homeFragment;
    private MeFragment meFragment;
    private UpLoadFragment upLoadFragment;
    private NewFragment newFragment;

    @Override
    public int getLayoutId() {

        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

//        StatusBarUtils.transparencyBar(this);

//        StatusBarUtils.StatusBarDarkMode(this,2);

        content_viewstub = (ViewStub) findViewById(R.id.content_viewstub);
        inflate = content_viewstub.inflate();
        init(inflate);
    }

    private void init(View view) {
        tabLayout = (CommonTabLayout) view.findViewById(R.id.tab_layout);
        mRxManager.mRxBus.register("bottom");
        mRxManager.on("bottom", new Action1<String>() {
            @Override
            public void call(String o) {
                if (o.equals("bottom")){

                    tabLayout.setAnimation(AnimationUtil.moveToViewLocation());
                    tabLayout.setVisibility(View.VISIBLE);
                }else {
                    tabLayout.setVisibility(View.GONE);
                    tabLayout.setAnimation(AnimationUtil.moveToViewBottom());
                }
            }
        });
        initTab();
        initFragment(savedInstanceState1);
        tabLayout.measure(0, 0);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstanceState1 = savedInstanceState;


    }

    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听

        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

                SwitchTo(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
                    mRxManager.post("home", AppConfig.RX_HOME);
                }
            }
        });
    }

    /**
     * 初始化碎片
     */
    private void initFragment(Bundle savedInstanceState) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("homeFragment");
            findFragment = (FindFragment) getSupportFragmentManager().findFragmentByTag("findFragment");
            newFragment = (NewFragment) getSupportFragmentManager().findFragmentByTag("newFragment");
            meFragment = (MeFragment) getSupportFragmentManager().findFragmentByTag("meFragment");
            upLoadFragment = (UpLoadFragment) getSupportFragmentManager().findFragmentByTag("upLoadFragment");
//            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            homeFragment = new HomeFragment();
            findFragment = new FindFragment();
            newFragment = new NewFragment();
            meFragment = new MeFragment();
            upLoadFragment = new UpLoadFragment();

            transaction.add(R.id.fl_body, homeFragment, "homeFragment");
            transaction.add(R.id.fl_body, findFragment, "findFragment");
            transaction.add(R.id.fl_body, newFragment, "newFragment");
            transaction.add(R.id.fl_body, meFragment, "meFragment");
            transaction.add(R.id.fl_body, upLoadFragment, "upLoadFragment");
        }
        transaction.commitAllowingStateLoss();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }

    /**
     * 切换
     */
    private void SwitchTo(int position) {


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (position) {
            //首页
            case 0:
                transaction.hide(newFragment);
                transaction.hide(meFragment);
                transaction.hide(findFragment);
                transaction.hide(upLoadFragment);
                transaction.show(homeFragment);
                transaction.commitAllowingStateLoss();
                break;
            //发现
            case 1:
                transaction.hide(newFragment);
                transaction.hide(meFragment);
                transaction.hide(homeFragment);
                transaction.hide(upLoadFragment);
                transaction.show(findFragment);
                transaction.commitAllowingStateLoss();
                break;
            //上传
            case 2:
                transaction.hide(homeFragment);
                transaction.hide(meFragment);
                transaction.hide(findFragment);
                transaction.hide(newFragment);
                transaction.show(upLoadFragment);
                transaction.commitAllowingStateLoss();
                break;
            //消息
            case 3:
                transaction.hide(upLoadFragment);
                transaction.hide(meFragment);
                transaction.hide(findFragment);
                transaction.hide(homeFragment);
                transaction.show(newFragment);
                transaction.commitAllowingStateLoss();
                break;
            //我的
            case 4:
                transaction.hide(newFragment);
                transaction.hide(homeFragment);
                transaction.hide(findFragment);
                transaction.hide(upLoadFragment);
                transaction.show(meFragment);
                transaction.commitAllowingStateLoss();
                break;
            default:
                break;
        }
    }


}
