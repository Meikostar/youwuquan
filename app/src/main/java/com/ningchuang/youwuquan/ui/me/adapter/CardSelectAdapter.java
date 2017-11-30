package com.ningchuang.youwuquan.ui.me.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.app.MyApplication;
import com.ningchuang.youwuquan.ui.home.adapter.ActorAdapter;
import com.ningchuang.youwuquan.ui.me.bean.CardSelectBean;
import com.zqd.common.utils.ImageLoaderUtils;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/21.
 */

public class CardSelectAdapter extends RecyclerView.Adapter<CardSelectAdapter.MyHolder> {
    private List<CardSelectBean> mList;
    private SetOnCardSelectClick setOnCardSelectClick;

    public CardSelectAdapter(List<CardSelectBean> mList, SetOnCardSelectClick setOnCardSelectClick) {
        this.mList = mList;
        this.setOnCardSelectClick = setOnCardSelectClick;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(MyApplication.getAppContext()).inflate(R.layout.item_card_select,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        ImageLoaderUtils.display(MyApplication.getAppContext(),holder.ivTu,mList.get(position).getTu());
        holder.tvNub.setText(mList.get(position).getNub());
        holder.itemView.setOnClickListener(view -> setOnCardSelectClick.onCardSelectClick(position));
    }

    @Override
    public int getItemCount() {
        return mList == null?0:mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        private ImageView ivTu;
        private TextView tvNub;
        public MyHolder(View itemView) {
            super(itemView);
            ivTu = itemView.findViewById(R.id.iv_card_select_tu);
            tvNub = itemView.findViewById(R.id.tv_card_select_nub);
        }
    }

    public interface SetOnCardSelectClick{
       void onCardSelectClick(int pos);
    }
}
