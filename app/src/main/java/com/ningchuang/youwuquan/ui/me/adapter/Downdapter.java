package com.ningchuang.youwuquan.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.home.bean.NearbyPeopleBean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/16.
 */

public class Downdapter extends RecyclerView.Adapter<Downdapter.MyHolder>{
    private List<NearbyPeopleBean> mList;
    private Context context;
    private SetOnPhotoClick setOnNearbyPeopleClick;

    public Downdapter(List<NearbyPeopleBean> mList, SetOnPhotoClick setOnNearbyPeopleClick, Context context) {
        this.context = context;
        this.mList = mList;
        this.setOnNearbyPeopleClick = setOnNearbyPeopleClick;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.ablum_item,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.ivFlag.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(view -> setOnNearbyPeopleClick.onPhotoClick(holder.itemView,mList,position));
    }

    @Override
    public int getItemCount() {
        return mList==null?13:mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView ivPhoto;
        ImageView ivFlag;
        public MyHolder(View itemView) {
            super(itemView);
           ivPhoto=itemView.findViewById(R.id.iv_photo);
           ivFlag=itemView.findViewById(R.id.iv_fag);
        }
    }

    public interface SetOnPhotoClick{
        void onPhotoClick(View view, Object o, int pos);
    }
}
