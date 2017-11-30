package com.ningchuang.youwuquan.app;


import com.ningchuang.youwuquan.ui.me.bean.GetSmsBean;
import com.ningchuang.youwuquan.ui.me.bean.LoginBean;
import com.ningchuang.youwuquan.ui.me.bean.RegisterBean;
import com.ningchuang.youwuquan.ui.me.bean.UserDataBean;

import java.io.File;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * //      ┏┛ ┻━━━━━┛ ┻┓
 * //      ┃　　　　　　 ┃
 * //      ┃　　　━　　　┃
 * //      ┃　┳┛　  ┗┳　┃
 * //      ┃　　　　　　 ┃
 * //      ┃　　　┻　　　┃
 * //      ┃　　　　　　 ┃
 * //      ┗━┓　　　┏━━━┛
 * //        ┃　　　┃   神兽保佑
 * //        ┃　　　┃   代码无BUG！
 * //        ┃　　　┗━━━━━━━━━┓
 * //        ┃　　　　　　　    ┣┓
 * //        ┃　　　　         ┏┛
 * //        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * //          ┃ ┫ ┫   ┃ ┫ ┫
 * //          ┗━┻━┛   ┗━┻━┛
 * Created by Administrator on 2017/2/21.
 */

public interface ApiManage {
    String baseUrl2 = "http://47.95.38.122/yby/";

    //注册
    @FormUrlEncoded
    @POST("login/userRegister?")
    Observable<RegisterBean> getRegisterResponse(@Field("userNo") String userNo,
                                                 @Field("loginPsw") String loginPsw,
                                                 @Field("vcNum") String vcNum,
                                                 @Field("platform") String platform,
                                                 @Field("register") String register
                                                 );
     //登录获取token
    @FormUrlEncoded
    @POST("login/userLogin")
    Observable<LoginBean> getLoginResponse(@Field("userNo") String userNo,
                                           @Field("loginPsw") String loginPsw,
                                           @Field("pswLogin") String vcNum

    );

    //通过token获取用户数据

    @FormUrlEncoded
    @POST("login/userLoginByToken")
    Observable<UserDataBean> getUserDataResponse(@Field("token") String token,
                                              @Field("userNo") String userNo
    );

    //获取短信验证码
    @FormUrlEncoded
    @POST("login/obtainVcNum")
    Observable<GetSmsBean> getSmsResponse(@Field("phone") String phone,
                                          @Field("register") String register
    );
}
