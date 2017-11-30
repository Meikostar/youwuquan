package com.ningchuang.youwuquan.ui.me.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.bean.SignBean;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-17.
 */

public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.MyViewholder> {

    private Context context;
    private List<SignBean> mList;

    private OnBtnClickLister onBtnClickLister;

    public interface OnBtnClickLister {
        void OnBtnClickLister(View view,Object o,int pos);
    }

    public void setOnBtnClickLister(OnBtnClickLister listener) {
        this.onBtnClickLister = listener;
    }


    public ChooseAdapter(Context context, List<SignBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(View.inflate(context, R.layout.choose_item, null));
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        SignBean signBean = mList.get(position);
        if (signBean.isSelect()){
            holder.mButton.setBackgroundResource(R.drawable.shape_next_red);
            holder.mButton.setTextColor(Color.parseColor("#ffffff"));
        }else {
            holder.mButton.setBackgroundResource(R.drawable.shape_next_hui);
            holder.mButton.setTextColor(Color.parseColor("#000000"));
        }
        holder.mButton.setText(mList.get(position).getName());
        holder.mButton.setOnClickListener(view -> onBtnClickLister.OnBtnClickLister(holder.mButton,mList,position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        private Button mButton;

        public MyViewholder(View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.choose_item_btn);

        }
    }
}
