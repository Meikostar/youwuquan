package com.ningchuang.youwuquan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.find.activity.ModelInfoActivity;
import com.ningchuang.youwuquan.ui.home.bean.WanghBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class WangHAdapter extends RecyclerView.Adapter<WangHAdapter.MyHolder> {
    private List<WanghBean> mList;
    private SetOnWanghClick setOnWanghClick;
    private Context context;

    public WangHAdapter(List<WanghBean> mList, SetOnWanghClick setOnWanghClick) {
        this.mList = mList;
        this.setOnWanghClick = setOnWanghClick;

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
         holder.itemView.setOnClickListener(view -> setOnWanghClick.onWanghClick(holder.itemView,mList,position));
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
        return mList == null?0:mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv_home_backgroud;
        public MyHolder(View itemView) {
            super(itemView);
            iv_home_backgroud = itemView.findViewById(R.id.iv_home_backgroud);
        }
    }

    public interface SetOnWanghClick{
        void onWanghClick(View view , Object o, int pos);
    }
}
