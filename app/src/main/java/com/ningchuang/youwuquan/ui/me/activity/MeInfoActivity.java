package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeInfoActivity extends BaseActivity {
    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.me_info_name)
    EditText meInfoName;
    @Bind(R.id.me_info_birthday)
    TextView meInfoBirthday;
    @Bind(R.id.me_info_bust)
    EditText meInfoBust;
    @Bind(R.id.me_info_waist)
    EditText meInfoWaist;
    @Bind(R.id.me_info_hipline)
    EditText meInfoHipline;
    @Bind(R.id.me_info_height)
    EditText meInfoHeight;
    @Bind(R.id.me_info_wechat)
    EditText meInfoWechat;
    @Bind(R.id.me_info_phone)
    EditText meInfoPhone;
    @Bind(R.id.me_info_save)
    Button meInfoSave;
    @Bind(R.id.me_info_constellation)
    AppCompatSpinner meInfoConstellation;

    @Override
    public int getLayoutId() {
        return R.layout.activity_me_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        navigationBar.setNavigationBarListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, R.layout.simple_spinner_item);
        String level[] = getResources().getStringArray(R.array.constellation_array);//资源文件
        for (int i = 0; i < level.length; i++) {
            adapter.add(level[i]);
        }
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        meInfoConstellation.setAdapter(adapter);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.me_info_name, R.id.me_info_birthday
            , R.id.me_info_bust, R.id.me_info_waist, R.id.me_info_hipline
            , R.id.me_info_height, R.id.me_info_wechat, R.id.me_info_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.me_info_name:
                break;
            case R.id.me_info_birthday:
                getBrithDay();
                break;
            case R.id.me_info_bust:
                break;
            case R.id.me_info_waist:
                break;
            case R.id.me_info_hipline:
                break;
            case R.id.me_info_height:
                break;
            case R.id.me_info_wechat:
                break;
            case R.id.me_info_phone:
                break;
            case R.id.me_info_save:
                break;
        }
    }

    private void getBrithDay() {

        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                LogUtils.e(date.getTime() + "");
                LogUtils.e(date.toString());


            }
        }).isDialog(true).setType(new boolean[]{true, true, true, false, false, false})
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }
}
