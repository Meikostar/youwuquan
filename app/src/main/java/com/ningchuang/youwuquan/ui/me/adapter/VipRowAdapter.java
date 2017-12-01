package com.ningchuang.youwuquan.ui.me.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.bean.VipBean;
import com.ningchuang.youwuquan.view.GlideCircleTransform;

import java.util.List;


public class VipRowAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<VipBean> list;
    private int type = 0;//0 表示默认使用list数据
    private String types;


    public void setType(int type) {
        this.type = type;
        notifyDataSetChanged();
    }

    public void setTypes(String types) {
        this.types = types;
        notifyDataSetChanged();
    }

    public VipRowAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<VipBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list != null ? list.size() :19;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.vip_row_itme, null);
            holder.txt_name = (TextView) view.findViewById(R.id.tv_name);
            holder.img = (ImageView) view.findViewById(R.id.img);
            holder.tv_row = (TextView) view.findViewById(R.id.tv_row);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(R.mipmap.me_tu1).transform(new GlideCircleTransform(context)).into(holder.img);
        //用户名
        holder.tv_row.setText((i+1)+"");
        // PROFILE_ITEM item = list.get(i);
        return view;
    }


    class ViewHolder {
        TextView txt_name;
        ImageView img;
        TextView tv_row;
        LinearLayout ll_bg;
    }
}
