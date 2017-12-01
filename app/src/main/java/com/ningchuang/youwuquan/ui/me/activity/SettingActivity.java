package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.Api;
import com.ningchuang.youwuquan.utils.CacheUtils;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.setting_clear_cache)
    RelativeLayout settingClearCache;
    @Bind(R.id.setting_update)
    RelativeLayout settingUpdate;
    @Bind(R.id.setting_abou)
    RelativeLayout settingAbou;
    @Bind(R.id.setting_statement)
    RelativeLayout settingStatement;
    @Bind(R.id.setting_help)
    RelativeLayout settingHelp;
    @Bind(R.id.setting_out)
    Button settingOut;
    @Bind(R.id.setting_get_cache)
    TextView settingGetCache;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        navigationBar.setNavigationBarListener(this);
        try {
            settingGetCache.setText(CacheUtils.getTotalCacheSize(getApplicationContext())+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.setting_me_back, R.id.setting_clear_cache
            , R.id.setting_update, R.id.setting_abou
            , R.id.setting_statement, R.id.setting_help, R.id.setting_out})

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_me_back:
                break;
            case R.id.setting_clear_cache:
                CacheUtils.clearAllCache(getApplicationContext());
                try {
                    settingGetCache.setText(CacheUtils.getTotalCacheSize(getApplicationContext()) + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.setting_update:
                break;
            case R.id.setting_abou:
                break;
            case R.id.setting_statement:
                break;
            case R.id.setting_help:
                break;
            case R.id.setting_out:
                break;
        }
    }
}
