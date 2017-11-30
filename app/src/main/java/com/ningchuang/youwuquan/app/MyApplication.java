package com.ningchuang.youwuquan.app;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.zqd.common.baseapp.BaseApplication;
import com.zqd.common.utils.MyCrashHandler;

/**
 * Created by Administrator on 2017/11/2.
 */

public class MyApplication extends BaseApplication {
    final static String MY_TAG = "LoggerTest";
    @Override
    public void onCreate() {
        super.onCreate();
        //打开错误日志，保存到sd卡
        MyCrashHandler myCrashHandler = MyCrashHandler.getInstance();
        myCrashHandler.init(getApplicationContext());
        Logger.init(MY_TAG).logLevel(LogLevel.FULL);
        initImageLoader();

    }

    private void initImageLoader() {
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
    }
}
