package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ningchuang.youwuquan.MainActivity;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.adapter.ChooseAdapter;
import com.ningchuang.youwuquan.ui.me.bean.SignBean;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.baseapp.AppManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BoyChooseActivity extends BaseActivity implements ChooseAdapter.OnBtnClickLister {

    @Bind(R.id.choosee_Recyc)
    RecyclerView chooseeRecyc;
    @Bind(R.id.choosee_btn)
    Button chooseeBtn;

    private List<SignBean> signBeanList,SelcetBeanList;

    private ChooseAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_boy_choose;
    }

    @Override
    public void initPresenter() {


    }

    @Override
    public void initView() {
        signBeanList = new ArrayList<>();

        signBeanList.add(new SignBean(false,"大长腿"));
        signBeanList.add(new SignBean(false,"大长腿"));
        signBeanList.add(new SignBean(false,"大长腿"));
        signBeanList.add(new SignBean(false,"大长腿"));
        signBeanList.add(new SignBean(false,"大长腿"));
        signBeanList.add(new SignBean(false,"大长腿"));
        signBeanList.add(new SignBean(false,"大长腿"));
        signBeanList.add(new SignBean(false,"大长腿"));

        chooseeRecyc.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new ChooseAdapter(this, signBeanList);
        chooseeRecyc.setAdapter(mAdapter);
        mAdapter.setOnBtnClickLister(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.choosee_btn)
    public void onViewClicked() {
        AppManager.getAppManager().returnToActivity(MainActivity.class);

    }

    @Override
    public void OnBtnClickLister(View view,Object o,int pos) {

        List<SignBean> beanList = new ArrayList<>();
        beanList.addAll((Collection<? extends SignBean>) o);
        if (beanList.get(pos).isSelect()){
            beanList.get(pos).setSelect(false);
        }else {
            beanList.get(pos).setSelect(true);
        }

        signBeanList.clear();
        signBeanList.addAll(beanList);
        com.orhanobut.logger.Logger.e(beanList.size()+"---"+signBeanList.size());

       mAdapter.notifyDataSetChanged();


    }
}
