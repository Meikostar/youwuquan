package com.ningchuang.youwuquan.ui.me.fragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.activity.ActorCardActivity;
import com.ningchuang.youwuquan.ui.me.activity.AuthenticationActivity;
import com.ningchuang.youwuquan.ui.me.activity.DownActivity;
import com.ningchuang.youwuquan.ui.me.activity.LoginActivity;
import com.ningchuang.youwuquan.ui.me.activity.MeAlbumActivity;
import com.ningchuang.youwuquan.ui.me.activity.MeInfoActivity;
import com.ningchuang.youwuquan.ui.me.activity.MeMoneyActivity;
import com.ningchuang.youwuquan.ui.me.activity.SettingActivity;
import com.ningchuang.youwuquan.ui.me.activity.SkillActivity;
import com.ningchuang.youwuquan.ui.me.activity.TaskActivity;
import com.ningchuang.youwuquan.ui.me.activity.VipRowActivity;
import com.zqd.common.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.image_me_background)
    ImageView imageMeBackground;
    @Bind(R.id.text_me_userName)
    TextView textMeUserName;
    @Bind(R.id.text_me_gift)
    TextView textMeGift;
    @Bind(R.id.image_me_rw)
    ImageView imageMeRw;
    @Bind(R.id.image_me_xz)
    ImageView imageMeXz;
    @Bind(R.id.text_me_xz)
    TextView textMeXz;
    @Bind(R.id.image_me_sz)
    ImageView imageMeSz;
    @Bind(R.id.money_me)
    LinearLayout moneyMe;
    @Bind(R.id.money_me_info)
    LinearLayout moneyMeInfo;
    @Bind(R.id.photo_me)
    LinearLayout photoMe;
    @Bind(R.id.relat_me_set)
    RelativeLayout relatMeSet;
    @Bind(R.id.image_me_icon)
    ImageView imageMeIcon;
    @Bind(R.id.authentication_me)
    LinearLayout authenticationMe;
    @Bind(R.id.llt_me_approve)
    LinearLayout lltMeApprove;
    @Bind(R.id.rll_me_card)
    RelativeLayout rllMeCard;
    @Bind(R.id.ll_task)
    RelativeLayout ll_task;
    @Bind(R.id.ll_vip)
    LinearLayout ll_vip;
    @Bind(R.id.rl_down)
    RelativeLayout rl_down;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_me;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        textMeUserName.setOnClickListener(this);
        moneyMe.setOnClickListener(this);
        moneyMeInfo.setOnClickListener(this);
        photoMe.setOnClickListener(this);
        relatMeSet.setOnClickListener(this);
        imageMeIcon.setOnClickListener(this);
        authenticationMe.setOnClickListener(this);
        lltMeApprove.setOnClickListener(this);
        rllMeCard.setOnClickListener(this);
        ll_vip.setOnClickListener(this);
        ll_task.setOnClickListener(this);
        rl_down.setOnClickListener(this);

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_me_userName:

                break;
            case R.id.image_me_icon:
                // TODO: 2017/11/20 登录
                startActivity(LoginActivity.class);
                break;
            case R.id.money_me:
                // TODO: 2017/11/20 我的财富
                startActivity(MeMoneyActivity.class);
                break;
            case R.id.money_me_info:
                // TODO: 2017/11/20 我的资料
                startActivity(MeInfoActivity.class);
                break;
            case R.id.photo_me:
                // TODO: 2017/11/20 我的相册
                startActivity(MeAlbumActivity.class);
                break;
            case R.id.authentication_me:
                // TODO: 2017/11/20 我的技能
                startActivity(SkillActivity.class);
                break;
            case R.id.relat_me_set:
                // TODO: 2017/11/20 设置
                startActivity(SettingActivity.class);
                break;
            case R.id.llt_me_approve:
                // TODO: 2017/11/20 认证
                startActivity(AuthenticationActivity.class);
                break;
            case R.id.rll_me_card:
                startActivity(ActorCardActivity.class);
                break;
            case R.id.ll_vip:
                startActivity(VipRowActivity.class);
                break;
            case R.id.ll_task:
                startActivity(TaskActivity.class);
                break;
            case R.id.rl_down:
                startActivity(DownActivity.class);
                break;

        }
    }


}
