package com.ningchuang.youwuquan.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.home.bean.NearbyPeopleBean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/16.
 */

public class NearbyPeopleAdapter extends RecyclerView.Adapter<NearbyPeopleAdapter.MyHolder>{
    private List<NearbyPeopleBean> mList;
    private SetOnNearbyPeopleClick setOnNearbyPeopleClick;

    public NearbyPeopleAdapter(List<NearbyPeopleBean> mList, SetOnNearbyPeopleClick setOnNearbyPeopleClick) {
        this.mList = mList;
        this.setOnNearbyPeopleClick = setOnNearbyPeopleClick;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_nearby_people,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(View itemView) {
            super(itemView);

        }
    }

    public interface SetOnNearbyPeopleClick{
        void onNearbyPeopleClick(View view , Object o, int pos);
    }
}
