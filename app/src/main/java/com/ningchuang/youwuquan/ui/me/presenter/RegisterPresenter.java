package com.ningchuang.youwuquan.ui.me.presenter;

import com.ningchuang.youwuquan.ui.me.bean.GetSmsBean;
import com.ningchuang.youwuquan.ui.me.bean.RegisterBean;
import com.ningchuang.youwuquan.ui.me.contract.MeContracts;
import com.zqd.common.baserx.RxSubscriber;
import com.zqd.common.utils.FormatUtil;

/**
 * Created by ${diego} on 2017/11/20.
 */

public class RegisterPresenter extends MeContracts.RegisterPresenterData {
    @Override
    public void loadSmsReq(String phone, String register) {
       mRxManage.add(mModel.loadSms(phone,register).subscribe(new RxSubscriber<GetSmsBean>(mContext,false) {
           @Override
           protected void _onNext(GetSmsBean getSmsBean) {
               mView.getSms(getSmsBean);
           }

           @Override
           protected void _onError(String message) {
              mView.showErrorTip(message);
           }
       }));
    }

    @Override
    public void loadRegisterReq(String userNo, String loginPsw, String vcNum, String platform, String register) {
        mRxManage.add(mModel.loadRegister(userNo,loginPsw,vcNum,platform,register).subscribe(new RxSubscriber<RegisterBean>(mContext,false) {
            @Override
            protected void _onNext(RegisterBean registerBean) {
                mView.getRegister(registerBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
    //注册判断
    public boolean register(String register_Phone,String register_Pwd,String sms,String register_Vc) {
        if (!FormatUtil.isMobileNO(register_Phone)){
            showShortToast("请输入正确的手机号码");
            return false;
        }
        if (register_Pwd.length()<6){
            showShortToast("请输入大于6位的密码");
            return false;
        }
        if (sms == null){
            showShortToast("请获取短信验证码");
            return false;
        }
        if (register_Vc == null){
            showShortToast("请输入验证码");
        }
        return true;
    }


}
