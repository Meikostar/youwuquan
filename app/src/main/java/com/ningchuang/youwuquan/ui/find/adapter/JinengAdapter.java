package com.ningchuang.youwuquan.ui.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ningchuang.youwuquan.R;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-7.
 */

public class JinengAdapter extends RecyclerView.Adapter<JinengAdapter.MyViewHolder> {
    private Context context;
    private List<Integer> list;

    public JinengAdapter(Context context, List<Integer> jinengList) {

        this.list = jinengList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_jineng, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.jineng_iamge.setImageResource(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView jineng_iamge;

        public MyViewHolder(View itemView) {
            super(itemView);
            jineng_iamge = itemView.findViewById(R.id.jineng);
        }
    }
}
