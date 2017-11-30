package com.ningchuang.youwuquan.ui.me.model;

import com.ningchuang.youwuquan.app.Api;
import com.ningchuang.youwuquan.ui.me.bean.LoginBean;
import com.ningchuang.youwuquan.ui.me.bean.UserDataBean;
import com.ningchuang.youwuquan.ui.me.contract.MeContracts;
import com.zqd.common.baserx.RxSchedulers;

import rx.Observable;

/**
 * Created by ${diego} on 2017/11/20.
 */

public class LoginModel implements MeContracts.LoginModeData{


    @Override
    public Observable<LoginBean> loadLogin(String userNo, String loginPsw, String pswLogin) {
        return Api.getDefault().getLoginResponse(userNo,loginPsw,pswLogin).map(loginBean -> loginBean).compose(new RxSchedulers().io_main());
    }

    @Override
    public Observable<UserDataBean> loadUserData(String token, String userNo) {
        return Api.getDefault().getUserDataResponse(token,userNo).map(userDataBean -> userDataBean).compose(new RxSchedulers().io_main());
    }
}
