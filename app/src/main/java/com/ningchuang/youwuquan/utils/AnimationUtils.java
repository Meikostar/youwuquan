package com.ningchuang.youwuquan.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by wuLiang  on 17-11-9.
 */

public class AnimationUtils {



    public static void scaleAnimator(final View view) {
        ValueAnimator vValue = ValueAnimator.ofFloat(1.0f, 0.6f, 1.2f, 1.0f, 0.6f, 1.2f, 1.0f);
        vValue.setDuration(1000L);
        vValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (Float) animation.getAnimatedValue();
                view.setScaleX(scale);
                view.setScaleY(scale);
            }
        });
        vValue.setInterpolator(new LinearInterpolator());
        vValue.start();
    }

}
