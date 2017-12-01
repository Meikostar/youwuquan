package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.view.MarkaEditText;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EditSkillActivity extends BaseActivity {


    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.et_time)
    MarkaEditText etTime;
    @Bind(R.id.et_address)
    MarkaEditText etAddress;
    @Bind(R.id.et_price)
    MarkaEditText etPrice;
    @Bind(R.id.et_requst)
    MarkaEditText etRequst;
    @Bind(R.id.tv_save)
    TextView tvSave;

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_skill;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        navigationBar.setNavigationBarListener(this);
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
