package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.zqd.common.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerfectionInfoActivity extends BaseActivity {

    @Bind(R.id.perfetopn_InputName)
    EditText perfetopnInputName;
    @Bind(R.id.perfetopn_inputBrith)
    TextView perfetopnInputBrith;
    @Bind(R.id.perfetopn_Boy)
    RadioButton perfetopnBoy;
    @Bind(R.id.perfetopn_Girl)
    RadioButton perfetopnGirl;
    @Bind(R.id.perfetopn_Next)
    Button perfetopnNext;

    @Override
    public int getLayoutId() {
        return R.layout.activity_perfection_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.perfetopn_inputBrith, R.id.perfetopn_Next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.perfetopn_inputBrith:
                break;
            case R.id.perfetopn_Next:
                if (perfetopnBoy.isChecked()) {
                    LogUtils.e("选中的是男生");

                    startActivity(BoyChooseActivity.class);

                } else if (perfetopnGirl.isChecked()) {
                    LogUtils.e("选中的是女生");
                } else {
                    LogUtils.e("RadioGrounp  异常");
                }
                break;
        }
    }
}
