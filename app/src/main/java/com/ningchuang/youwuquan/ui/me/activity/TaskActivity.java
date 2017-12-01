package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TaskActivity extends BaseActivity implements View.OnClickListener{


    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.ll_content)
    LinearLayout llContent;
    @Bind(R.id.tv_sign)
    TextView tvSign;
    @Bind(R.id.ll_sign)
    LinearLayout llSign;
    @Bind(R.id.tv_comment)
    TextView tvComment;
    @Bind(R.id.ll_comment)
    LinearLayout llComment;
    @Bind(R.id.tv_like)
    TextView tvLike;
    @Bind(R.id.ll_like)
    LinearLayout llLike;
    @Bind(R.id.tv_welafe)
    TextView tvWelafe;
    @Bind(R.id.ll_wefle)
    LinearLayout llWefle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_task;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
     navigationBar.setNavigationBarListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_content:
                //  内容
                break;
            case R.id.ll_sign:
                // 签到

                break;
            case R.id.ll_comment:
                // 评论

                break;
            case R.id.ll_like:
                // 点赞

                break;
            case R.id.ll_wefle:
                // 福利

                break;


        }
    }
}
