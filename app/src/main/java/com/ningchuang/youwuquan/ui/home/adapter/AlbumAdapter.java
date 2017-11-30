package com.ningchuang.youwuquan.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.home.bean.NearbyPeopleBean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/16.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyHolder>{
    private List<NearbyPeopleBean> mList;
    private Context context;
    private SetOnNearbyPeopleClick setOnNearbyPeopleClick;

    public AlbumAdapter(List<NearbyPeopleBean> mList, SetOnNearbyPeopleClick setOnNearbyPeopleClick,Context context) {
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
           if(position%2==0){
               holder.ivFlag.setImageResource(R.mipmap.home_video);
           }else {
               holder.ivFlag.setImageResource(R.mipmap.home_picture);
           }
        holder.itemView.setOnClickListener(view -> setOnNearbyPeopleClick.onNearbyPeopleClick(holder.itemView,mList,position));
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

    public interface SetOnNearbyPeopleClick{
        void onNearbyPeopleClick(View view, Object o, int pos);
    }
}
