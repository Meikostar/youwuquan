package com.zqd.common.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zqd.common.R;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/**
 * Description : 图片加载工具类 使用glide框架封装
 */
public class ImageLoaderUtils {

    public static void display(Context context, ImageView imageView, String url, int placeholder, int error) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).placeholder(placeholder)
                .error(error).crossFade()
                .skipMemoryCache(true)
                .into(imageView);
    }

    public static void display(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .signature( new SignKey(url))
                .crossFade()
                .skipMemoryCache(true)
                .into(imageView);
    }

    public static void display(Context context, ImageView imageView, File url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade()
                .skipMemoryCache(true)
                .into(imageView);
    }

    public static void displaySmallPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .thumbnail(0.5f)
                .skipMemoryCache(true)
                .into(imageView);
    }
    public static void displayBigPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .skipMemoryCache(true)
                .into(imageView);
    }
    public static void display(Context context, ImageView imageView, int url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.ic_empty_picture)
                .skipMemoryCache(true)
                .crossFade().into(imageView);
    }
    public static void displayRound(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .signature(new SignKey(url))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.toux2)
                .skipMemoryCache(true)
                .centerCrop().transform(new GlideRoundTransformUtil(context)).into(imageView);
    }

    static class SignKey implements Key {
        private String filepath;

        public SignKey(String filepath) {
            this.filepath = filepath;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof SignKey){
                SignKey o1 = (SignKey) o;
                return filepath == o1.filepath;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return filepath.hashCode()*12;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
            messageDigest.update(ByteBuffer.allocate(Integer.SIZE).putInt(filepath.hashCode()*12).array());
        }
    }
}
