package com.ningchuang.youwuquan.ui.me.contract;

import com.ningchuang.youwuquan.ui.me.bean.GetSmsBean;
import com.ningchuang.youwuquan.ui.me.bean.LoginBean;
import com.ningchuang.youwuquan.ui.me.bean.RegisterBean;
import com.ningchuang.youwuquan.ui.me.bean.UserDataBean;
import com.zqd.common.base.BaseModel;
import com.zqd.common.base.BasePresenter;
import com.zqd.common.base.BaseView;

import rx.Observable;

/**
 * Created by ${diego} on 2017/11/20.
 */

public interface MeContracts {

    //LoginActivity
   interface LoginModeData extends BaseModel{
       Observable<LoginBean> loadLogin(String userNo, String loginPsw, String pswLogin);
       Observable<UserDataBean> loadUserData(String token,String userNo);
   }

   interface LoginView extends BaseView{
       void getLogin(LoginBean loginBean);
       void getUserData(UserDataBean userDataBean);
   }
   abstract class LoginPresenterData extends BasePresenter<LoginView,LoginModeData>{
        public abstract void loadLoginReq(String userNo,String loginPsw ,String pswLogin);
        public abstract void loadUserDatReq(String token,String userNo);
   }

   //RegisterActivity

    interface RegisterModeData extends BaseModel{
        Observable<GetSmsBean> loadSms(String phone,String register);
        Observable<RegisterBean> loadRegister(String userNo,String loginPsw,String vcNum,String platform, String register);
    }

    interface RegisterView extends BaseView{
         void getSms(GetSmsBean getSmsBean);
         void getRegister(RegisterBean registerBean);
    }
    abstract class RegisterPresenterData extends BasePresenter<RegisterView,RegisterModeData>{
         public abstract void loadSmsReq(String phone,String register);
         public abstract void loadRegisterReq(String userNo,String loginPsw,String vcNum,String platform, String register);
    }
}
