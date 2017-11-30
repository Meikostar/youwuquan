package com.ningchuang.youwuquan.utils;

import com.google.gson.Gson;

/**
 * Created by ${diego} on 2017/11/20.
 */

public class GsonUtils {
    public static String getJson(Object o){
        Gson gson = new Gson();
        String s = gson.toJson(o);
        return s;
    }
}
