package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.base.TranBaseActivity;
import com.ningchuang.youwuquan.ui.me.adapter.VipRowAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VipRowActivity extends TranBaseActivity {


    @Bind(R.id.top_view_back)
    ImageView topViewBack;
    @Bind(R.id.topview_left_layout)
    LinearLayout topviewLeftLayout;
    @Bind(R.id.iv_second)
    ImageView ivSecond;
    @Bind(R.id.tv_second)
    TextView tvSecond;
    @Bind(R.id.iv_first)
    ImageView ivFirst;
    @Bind(R.id.tv_first)
    TextView tvFirst;
    @Bind(R.id.iv_thrid)
    ImageView ivThrid;
    @Bind(R.id.tv_third)
    TextView tvThird;
    @Bind(R.id.list_view)
    ListView listView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_vip_row;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        topviewLeftLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        VipRowAdapter vipRowAdapter = new VipRowAdapter(this);
        listView.setAdapter(vipRowAdapter);
    }


}
