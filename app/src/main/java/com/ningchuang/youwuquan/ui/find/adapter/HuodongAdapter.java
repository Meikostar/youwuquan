package com.ningchuang.youwuquan.ui.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.find.bean.HuodongBean;
import com.ningchuang.youwuquan.utils.LogUtils;

import java.util.List;

/**
 * Created by wuLiang  on 17-10-31.
 */

public class HuodongAdapter extends RecyclerView.Adapter<HuodongAdapter.MyViewHolder> {
    private Context context;
    private List<HuodongBean> mList;

    public HuodongAdapter(Context context, List<HuodongBean> mHuodongList) {
        this.context = context;
        this.mList = mHuodongList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_huodong, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.content_Text.setText(mList.get(position).getContent());
        holder.title_Text.setText(mList.get(position).getTitle());
        holder.jion_Text.setText(mList.get(position).getJion());


        holder.itemView.setTag((int) position);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView huoDong_Iamge;
        private TextView title_Text, content_Text, jion_Text;

        public MyViewHolder(final View itemView) {
            super(itemView);
            huoDong_Iamge = itemView.findViewById(R.id.image_item_huodong);
            title_Text = itemView.findViewById(R.id.title_item_huodong);
            content_Text = itemView.findViewById(R.id.content_item_huodong);
            jion_Text = itemView.findViewById(R.id.jion_item_huodong);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogUtils.e(" 活动界面 点击了 ==》 "+ itemView.getTag());
                }
            });
        }

    }
}
