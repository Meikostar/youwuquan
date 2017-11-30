package com.ningchuang.youwuquan.ui.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.find.bean.Renzheng_Bean;
import com.ningchuang.youwuquan.utils.LogUtils;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-7.
 */

public class RenzhengAdapater extends RecyclerView.Adapter<RenzhengAdapater.MyViewHolder> {
    private Context context;
    private List<Renzheng_Bean> list;

    public RenzhengAdapater(Context context, List<Renzheng_Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_renzheng, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mIcon.setImageResource(list.get(position).getIcon());
        holder.mContent.setText(list.get(position).getRenzheng());

        boolean succeed = list.get(position).isSucceed();
        if (succeed == true) {
            holder.mView.setBackgroundResource(R.mipmap.find_rzred);
            LogUtils.e(position + " succeed==true     " );
        }else if (succeed==false){
            holder.mView.setBackgroundResource(R.mipmap.find_rzgray);
            LogUtils.e(position + " succeed==false    " );
        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mContent;
        private ImageView mIcon;
        private LinearLayout mView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView.findViewById(R.id.backGround_renzhen);
            mContent = itemView.findViewById(R.id.content_renzhen);
            mIcon = itemView.findViewById(R.id.icon_renzhen);


        }
    }
}
