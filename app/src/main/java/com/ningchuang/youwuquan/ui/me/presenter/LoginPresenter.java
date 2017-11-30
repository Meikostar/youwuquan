package com.ningchuang.youwuquan.ui.me.presenter;

import com.ningchuang.youwuquan.app.Api;
import com.ningchuang.youwuquan.ui.me.bean.LoginBean;
import com.ningchuang.youwuquan.ui.me.bean.UserDataBean;
import com.ningchuang.youwuquan.ui.me.contract.MeContracts;
import com.zqd.common.base.BasePresenter;
import com.zqd.common.baserx.RxSchedulers;
import com.zqd.common.baserx.RxSubscriber;

/**
 * Created by ${diego} on 2017/11/20.
 */

public class LoginPresenter extends MeContracts.LoginPresenterData{
    @Override
    public void loadLoginReq(String userNo, String loginPsw, String pswLogin) {
        mRxManage.add(mModel.loadLogin(userNo,loginPsw,pswLogin).subscribe(new RxSubscriber<LoginBean>(mContext,false) {
            @Override
            protected void _onNext(LoginBean loginBean) {
            mView.getLogin(loginBean);
            }

            @Override
            protected void _onError(String message) {
              mView.showErrorTip(message);
            }
        }));
    }

    @Override
    public void loadUserDatReq(String token, String userNo) {
        mRxManage.add(mModel.loadUserData(token,userNo).subscribe(new RxSubscriber<UserDataBean>(mContext,false) {
            @Override
            protected void _onNext(UserDataBean userDataBean) {

            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
