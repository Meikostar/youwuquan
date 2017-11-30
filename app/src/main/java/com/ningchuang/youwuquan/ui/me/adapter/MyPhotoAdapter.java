package com.ningchuang.youwuquan.ui.me.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.activity.PublicAlbumActivity;
import com.ningchuang.youwuquan.ui.me.bean.AlbumBean;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-14.
 */

public class MyPhotoAdapter extends RecyclerView.Adapter<MyPhotoAdapter.MyViewHolder> {
    private Context context;
    private List<AlbumBean> mList;

    public MyPhotoAdapter(Context context, List<AlbumBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(context, R.layout.album_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.mIcon

        holder.mText.setText(mList.get(position).getAlbumName());
        if(position==0){
            Glide.with(context).load(R.mipmap.me_tu1).error(R.mipmap.ic_launcher_round).into(holder.mIcon);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }else if(position==1){
            Glide.with(context).load(R.mipmap.me_tu2).error(R.mipmap.ic_launcher_round).into(holder.mIcon);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PublicAlbumActivity.class);
                    intent.putExtra("type",1);
                    context.startActivity(intent);
                }
            });
        }else {
            Glide.with(context).load(R.mipmap.me_tu3).error(R.mipmap.ic_launcher_round).into(holder.mIcon);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PublicAlbumActivity.class);
                    intent.putExtra("type",2);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mText;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.album_item_icon);
            mText = itemView.findViewById(R.id.album_item_class);
        }
    }
}
