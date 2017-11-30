package com.ningchuang.youwuquan.view.NinePic;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;

import com.ningchuang.youwuquan.utils.ImageLoaderUtils;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * 描述：
 * 作者：HMY
 * 时间：2016/5/12
 */
public class NineGridPicView extends NineGridLayout {
    private Context context;


    protected static final int MAX_W_H_RATIO = 3;

    public NineGridPicView(Context context) {

        super(context);
        this.context = context;
    }

    public NineGridPicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean displayOneImage(final RatioImageView imageView, String url, final int parentWidth) {


        ImageLoaderUtils.displayImage(mContext, imageView, url, ImageLoaderUtils.getPhotoImageOption(), new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap bitmap) {
                int w = bitmap.getWidth();
                int h = bitmap.getHeight();

                int newW;
                int newH;
                if (h > w * MAX_W_H_RATIO) {//h:w = 5:3
                    newW = parentWidth / 2;
                    newH = newW * 5 / 3;
                } else if (h < w) {//h:w = 2:3
                    newW = parentWidth * 2 / 3;
                    newH = newW * 2 / 3;
                } else {//newH:h = newW :w
                    newW = parentWidth / 2;
                    newH = h * newW / w;
                }
                setOneImageLayoutParams(imageView, newW, newH);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
        return false;
    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
        ImageLoaderUtils.getImageLoader(mContext).displayImage(url, imageView, ImageLoaderUtils.getPhotoImageOption());

    }

    @Override
    protected void onClickImage(int i, String url, List<String> urlList) {


        LogUtils.e("做了点击图片的点击事件");
//        Bundle bundle = new Bundle();
//        bundle.putStringArrayList("key", (ArrayList<String>) urlList);
//        Intent intent = new Intent();
//        intent.putStringArrayListExtra("key", (ArrayList<String>) urlList);
//        intent.setClass(getContext(), ViewPagerActivity.class);

        /**
         *
         */


    }
}
