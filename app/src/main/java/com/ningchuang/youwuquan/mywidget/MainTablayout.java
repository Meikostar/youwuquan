package com.ningchuang.youwuquan.mywidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.ningchuang.youwuquan.R;

/**
 * Created by Administrator on 2017/11/2.
 */

public class MainTablayout extends RelativeLayout {
    public MainTablayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_tablayout_main,this,false);


    }
}
