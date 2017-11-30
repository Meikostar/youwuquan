package com.ningchuang.youwuquan.ui.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.find.activity.ModelInfoActivity;
import com.ningchuang.youwuquan.ui.home.bean.NearbyBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.MyHolder> {
    private List<NearbyBean> mList;
    private SetOnNearbyClick setOnNearbyClick;
    private Context context;
    public NearbyAdapter(List<NearbyBean> mList, SetOnNearbyClick setOnNearbyClick) {
        this.mList = mList;
        this.setOnNearbyClick = setOnNearbyClick;

    }
    public void setContext(Context context){
        this.context=context;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_home_nearby,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (position == 0){
            setMargins(holder.itemView,30,0,16,40);
        }else if (position == mList.size()-1){
            setMargins(holder.itemView,0,0,30,40);
        }else {
            setMargins(holder.itemView,0,0,16,40);
        }
        holder.itemView.setOnClickListener(view -> setOnNearbyClick.onNearbyClick(holder.itemView,mList,position));
        holder.iv_home_nearby.setOnClickListener(new View.OnClickListener() {
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
        RelativeLayout rltXu;
        CardView cardView;
        ImageView iv_home_nearby;
        public MyHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_home);
            iv_home_nearby = itemView.findViewById(R.id.iv_home_nearby);
        }
    }

    public interface SetOnNearbyClick{
        void onNearbyClick(View view , Object o, int pos);
    }

    public static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }
}
