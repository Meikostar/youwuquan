package com.zqd.common.baseapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.zqd.common.utils.MyCrashHandler;


/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    public static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;

    }

    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }



}
