package com.ningchuang.youwuquan.ui.home.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.home.bean.SearchHotBean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/14.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder> {
    private List<SearchHotBean> mList;
    private SetOnSearchClick setOnSearchClick;

    public SearchAdapter(List<SearchHotBean> mList, SetOnSearchClick setOnSearchClick) {
        this.mList = mList;
        this.setOnSearchClick = setOnSearchClick;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_home_search,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
       holder.itemView.setOnClickListener(view -> setOnSearchClick.onSearchClick(holder.itemView,mList,position));
    }

    @Override
    public int getItemCount() {
        return mList == null?0:mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(View itemView) {
            super(itemView);

        }
    }

    public interface SetOnSearchClick{
        void onSearchClick(View view , Object o, int pos);
    }
}
