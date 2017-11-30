package com.ningchuang.youwuquan.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.home.bean.SearchHotBean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/14.
 */

public class FlagAdapter extends RecyclerView.Adapter<FlagAdapter.MyHolder> {
    private List<String> mList;
    private SetOnSearchClick setOnSearchClick;

    public FlagAdapter(List<String> mList, SetOnSearchClick setOnSearchClick) {
        this.mList = mList;
        this.setOnSearchClick = setOnSearchClick;
    }
   public void setData(List<String> mList){
       this.mList = mList;
   }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_home_search,parent,false));
    }
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if(!TextUtils.isEmpty(mList.get(position))){
            holder.name.setText(mList.get(position));
        }
       holder.itemView.setOnClickListener(view -> setOnSearchClick.onSearchClick(holder.itemView,mList.get(position),position));
    }

    @Override
    public int getItemCount() {
        return mList == null?0:mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView name;
        public MyHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv_search_history_name);
        }
    }

    public interface SetOnSearchClick{
        void onSearchClick(View view, String name, int pos);
    }
}
