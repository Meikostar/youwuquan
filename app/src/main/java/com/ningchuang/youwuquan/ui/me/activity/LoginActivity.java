package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.Api;
import com.ningchuang.youwuquan.ui.me.bean.LoginBean;
import com.ningchuang.youwuquan.ui.me.bean.UserDataBean;
import com.ningchuang.youwuquan.ui.me.contract.MeContracts;
import com.ningchuang.youwuquan.ui.me.model.LoginModel;
import com.ningchuang.youwuquan.ui.me.presenter.LoginPresenter;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.baserx.RxSchedulers;
import com.zqd.common.baserx.RxSubscriber;
import com.zqd.common.utils.FormatUtil;
import com.zqd.common.utils.SPUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginPresenter,LoginModel> implements View.OnClickListener,MeContracts.LoginView {


    @Bind(R.id.login_register)
    TextView loginRegister;
    @Bind(R.id.login_fogetpwd)
    TextView loginFogetpwd;
    @Bind(R.id.login_me_weibo)
    ImageView loginMeWeibo;
    @Bind(R.id.login_me_qq)
    ImageView loginMeQq;
    @Bind(R.id.login_me_wechat)
    ImageView loginMeWechat;
    @Bind(R.id.login_set)
    Button loginSet;
    @Bind(R.id.login_user)
    EditText loginUser;
    @Bind(R.id.login_psw)
    EditText loginPsw;

    private String user,psw;
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
       mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        loginFogetpwd.setOnClickListener(this);

        loginRegister.setOnClickListener(this);

        loginSet.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.login_fogetpwd:
                startActivity(ForgetPwdActivity.class);
                break;

            case R.id.login_set:
                user = loginUser.getText().toString();
                psw = loginPsw.getText().toString();
                if (!FormatUtil.isMobileNO(user)){
                    showShortToast("输入正确的手机号码");
                    return;
                }
                if (psw == null){
                    showShortToast("密码不能为空");
                    return;
                }
                startProgressDialog("登录中...");
                mPresenter.loadLoginReq(user,psw,"pswLogin");
                break;
        }
    }


    @Override
    public void getSuccess(Object o) {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void getLogin(LoginBean loginBean) {

             if (loginBean.isSuccess()){
                 LoginBean.AppBeanBean appBeanBean = new LoginBean.AppBeanBean();

                 if ("success".equals(appBeanBean.getMsg())){
                     SPUtils.setSharedStringData(this,"token",appBeanBean.getData().get(0));
                     SPUtils.setSharedBooleanData(this,"login",true);
                     mPresenter.loadUserDatReq(appBeanBean.getData().get(0),user);
                 }
             }
    }

    @Override
    public void getUserData(UserDataBean userDataBean) {
        stopProgressDialog();
        if (userDataBean.isSuccess()){
            UserDataBean.AppBeanBean appBeanBean = new UserDataBean.AppBeanBean();
            if ("success".equals(appBeanBean.getMsg())){

            }
        }
    }
}