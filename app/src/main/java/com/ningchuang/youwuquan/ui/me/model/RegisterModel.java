package com.ningchuang.youwuquan.ui.me.model;

import com.ningchuang.youwuquan.app.Api;
import com.ningchuang.youwuquan.ui.me.bean.GetSmsBean;
import com.ningchuang.youwuquan.ui.me.bean.RegisterBean;
import com.ningchuang.youwuquan.ui.me.contract.MeContracts;
import com.zqd.common.baserx.RxSchedulers;

import rx.Observable;

/**
 * Created by ${diego} on 2017/11/20.
 */

public class RegisterModel implements MeContracts.RegisterModeData {

    @Override
    public Observable<GetSmsBean> loadSms(String phone, String register) {
        return Api.getDefault().getSmsResponse(phone,register).map(getSmsBean -> getSmsBean).
                compose(new RxSchedulers().io_main());
    }

    @Override
    public Observable<RegisterBean> loadRegister(String userNo, String loginPsw, String vcNum, String platform, String register) {
        return Api.getDefault().getRegisterResponse(userNo,loginPsw,vcNum,platform,register).map(registerBean -> registerBean).
                compose(new RxSchedulers().io_main());
    }
}
