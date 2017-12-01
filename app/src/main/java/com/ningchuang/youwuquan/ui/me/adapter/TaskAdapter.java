package com.ningchuang.youwuquan.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.bean.SkillBean;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-14.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    private Context context;
    private List<SkillBean> mList;

    public TaskAdapter(Context context, List<SkillBean> mList, SetItemClick itemClick) {
        this.itemClick = itemClick;
        this.context = context;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(context, R.layout.task_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.mIcon

        holder.mText.setText(mList.get(position).name);
        Glide.with(context).load(mList.get(position).id).error(R.mipmap.ic_launcher_round).into(holder.mIcon);
        if(position==0||position==3){
            holder.mSkil.setText("编辑");
            holder.ll_bg.setBackgroundResource(R.mipmap.light);

        }else {
            holder.mSkil.setText("点亮技能");
            holder.ll_bg.setBackgroundResource(R.mipmap.nolight);

        }
        holder.mSkil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onItemClick(holder.itemView,mList,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mText;
        private TextView mSkil;
        private LinearLayout ll_bg;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.iv_icon);
            mText = itemView.findViewById(R.id.tv_name);
            mSkil = itemView.findViewById(R.id.tv_skill);
            ll_bg = itemView.findViewById(R.id.ll_bg);
        }
    }

    private SetItemClick itemClick;
    public interface SetItemClick{
        void onItemClick(View view, Object o, int pos);
    }
}
