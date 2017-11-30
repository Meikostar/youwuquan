package com.ningchuang.youwuquan.ui.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.news.bean.PlayBeans;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/14.
 */

public class PlayAdapter extends RecyclerView.Adapter<PlayAdapter.MyHolder> {
    private List<PlayBeans> mList;
    private SetOnPlayClick setOnPlayClick;

    public PlayAdapter(List<PlayBeans> mList, SetOnPlayClick setOnPlayClick) {
        this.mList = mList;
        this.setOnPlayClick = setOnPlayClick;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_news_play,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList == null?0:mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private ImageView ivHead;
        private TextView tvName;
        public MyHolder(View itemView) {
            super(itemView);
            ivHead = itemView.findViewById(R.id.iv_play_head);
            tvName = itemView.findViewById(R.id.tv_play_name);
        }
    }

    public interface SetOnPlayClick{
        void onPlayClick(View view , Object o, int pos);
    }
}
