package com.ningchuang.youwuquan.ui.commom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-15.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewholder> {
    private Context context;
    private List<String> list;

    public ImageAdapter(Context context, List<String> model_imageString) {
        this.context = context;
        this.list = model_imageString;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(View.inflate(context, R.layout.details_images, null));
    }


    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        Glide.with(context).load(list.get(position)).error(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public MyViewholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.details_item_iamge);
        }
    }
}
