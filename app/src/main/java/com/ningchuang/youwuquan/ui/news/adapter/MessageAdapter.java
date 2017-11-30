package com.ningchuang.youwuquan.ui.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.news.bean.MessageBean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/14.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyHolder> {
    private List<MessageBean> mList;
    private SetMessageClick setMessageClick;

    public MessageAdapter(List<MessageBean> mList, SetMessageClick setMessageClick) {
        this.mList = mList;
        this.setMessageClick = setMessageClick;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_news_message,parent,false));
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

    public interface SetMessageClick{
        void onMessageClick(View view , Object o, int pos);
    }
}
