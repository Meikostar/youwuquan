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

public class DianzanAdapter extends RecyclerView.Adapter<DianzanAdapter.MyViewHolder> {

    private List<Integer> list;
    private Context context;

    public DianzanAdapter(Context context, List<Integer> dianzan_list) {
        this.list = dianzan_list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new MyViewHolder(View.inflate(context, R.layout.details_item_dianzan, null));
        return new MyViewHolder(View.inflate(context, R.layout.details_item_dianzan, null));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).error(R.mipmap.zhanweitu4).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.details_item_image);
        }
    }
}
