package com.ningchuang.youwuquan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.find.activity.ModelInfoActivity;
import com.ningchuang.youwuquan.ui.home.bean.ActorBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.MyHolder> {
    private List<ActorBean> mList;
    private SetOnActorClick setOnActorClick;
    private Context context;
    public ActorAdapter(List<ActorBean> mList, SetOnActorClick setOnActorClick) {
        this.mList = mList;
        this.setOnActorClick = setOnActorClick;

    }
    public void setContext(Context context){
        this.context=context;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_home_wangh,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.rltXu.setBackgroundResource(R.mipmap.home_jianbian2);
        holder.itemView.setOnClickListener(view -> setOnActorClick.onActorClick(holder.itemView,mList,position));
        holder.iv_home_backgroud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ModelInfoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0: mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        RelativeLayout rltXu;
        TextView tv_name;
        ImageView iv_home_backgroud;
        public MyHolder(View itemView) {
            super(itemView);
            rltXu = itemView.findViewById(R.id.rlt_home_actor_xu);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_home_backgroud = itemView.findViewById(R.id.iv_home_backgroud);
        }
    }

    public interface SetOnActorClick{
        void onActorClick(View view , Object o, int pos);
    }

}
