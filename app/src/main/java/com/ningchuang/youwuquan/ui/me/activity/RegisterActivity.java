package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.Api;
import com.ningchuang.youwuquan.ui.me.bean.GetSmsBean;
import com.ningchuang.youwuquan.ui.me.bean.RegisterBean;
import com.ningchuang.youwuquan.ui.me.contract.MeContracts;
import com.ningchuang.youwuquan.ui.me.model.RegisterModel;
import com.ningchuang.youwuquan.ui.me.presenter.RegisterPresenter;
import com.ningchuang.youwuquan.utils.GsonUtils;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.baseapp.BaseApplication;
import com.zqd.common.baserx.RxSchedulers;
import com.zqd.common.baserx.RxSubscriber;
import com.zqd.common.utils.FormatUtil;

import java.util.logging.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.util.Log.e;

public class RegisterActivity extends BaseActivity<RegisterPresenter,RegisterModel> implements MeContracts.RegisterView{

    @Bind(R.id.register_inputNum)
    EditText registerInputNum;
    @Bind(R.id.register_getVcNum)
    TextView registerGetVcNum;
    @Bind(R.id.register_inputVcNum)
    EditText registerInputVcNum;
    @Bind(R.id.register_inputPwd)
    EditText registerInputPwd;
    @Bind(R.id.register_agreenment)
    TextView registerAgreenment;
    @Bind(R.id.register_register)
    Button registerRegister;
    @Bind(R.id.register_toLogin)
    TextView registerToLogin;

    private String register_Phone, register_Pwd, register_Vc;
    private String sms = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initPresenter() {
       mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.register_getVcNum, R.id.register_agreenment, R.id.register_register, R.id.register_toLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //请求验证码
            case R.id.register_getVcNum:
                register_Phone = registerInputNum.getText().toString();
                if (!FormatUtil.isMobileNO(register_Phone)){
                    showShortToast("请输入正确的手机号码");
                    return;
                }
                mPresenter.loadSmsReq(register_Phone,"register");
                break;
            //查看同意协议
            case R.id.register_agreenment:
                break;
            //注册
            case R.id.register_register:
                //注册动作
                register_Phone = registerInputNum.getText().toString();
                register_Pwd = registerInputPwd.getText().toString();
                register_Vc = registerInputVcNum.getText().toString();
                if (mPresenter.register(register_Phone, register_Pwd, sms,register_Vc)){
                    startProgressDialog("正在注册...");
                     mPresenter.loadRegisterReq(register_Phone,register_Pwd,register_Vc,"APP","register");
                }
                break;
            //已有账号，跳转至登录界面
            case R.id.register_toLogin:
                break;
        }
    }



    @Override
    public void getSuccess(Object o) {

    }

    @Override
    public void showErrorTip(String msg) {
        stopProgressDialog();
        showShortToast(msg);
    }

    @Override
    public void getSms(GetSmsBean getSmsBean) {
        Log.e("zhou",GsonUtils.getJson(getSmsBean));
          if (getSmsBean.isSuccess()){
              GetSmsBean.AppBeanBean appBeanBean = getSmsBean.getAppBean();
              if (appBeanBean.getMsg().equals("success")){
                  sms = appBeanBean.getData().get(0);
                  showShortToast("获取验证码成功");
              }
          }
    }

    @Override
    public void getRegister(RegisterBean registerBean) {
            stopProgressDialog();
        Log.e("zhou",GsonUtils.getJson(registerBean));
            if (registerBean.isSuccess()){
                RegisterBean.AppBeanBean dataBean = registerBean.getAppBean();
                if (dataBean.getMsg().equals("success")){
                    startActivity(PerfectionInfoActivity.class);
                }
            }
    }
}
