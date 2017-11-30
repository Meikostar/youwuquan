package com.ningchuang.youwuquan.ui.me.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.activity.Applying_for_certificateActivity;
import com.ningchuang.youwuquan.ui.me.bean.IconBean;
import com.zqd.common.widget.ShowDilog;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-16.
 */

public class Icon_me_Adapter extends RecyclerView.Adapter<Icon_me_Adapter.MyViewholder> {
    private List<IconBean> list;
    private Context context;

    public Icon_me_Adapter(Context context, List<IconBean> icon_pic) {
        this.context = context;
        this.list = icon_pic;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewholder(View.inflate(context, R.layout.item_authentication, null));
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        Glide.with(context).load(list.get(position).getIcon()).error(R.mipmap.zhanweitu4).into(holder.mIcon);
        holder.mText.setText(list.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        private ImageView mIcon;
        private TextView mText;
        private LinearLayout mView;

        ShowDilog mDilog = new ShowDilog(context, new ShowDilog.SetOnDilogClick() {
            @Override
            public void OnCancleClick() {
                mDilog.cancle();
            }

            @Override
            public void OnSureClick() {

                context.startActivity(new Intent(context, Applying_for_certificateActivity.class));
                mDilog.cancle();

            }
        }, "取消", "确认", "申请需知", "\n\n*\t\t认证尤物女神需缴1500元；\n*\t\t1500元我们将为您拍摄1—10张 精美写真。\n\n");

        public MyViewholder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.authentication_item_icon);
            mText = itemView.findViewById(R.id.authentication_item_text);
            mView = itemView.findViewById(R.id.authentication_item_view);

//                public ShowDilog(Context context, ShowDilog.SetOnDilogClick setOnDilogClick, String cancle, String sure, String title, String content) {

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDilog.showDilog();
                }


            });
        }

    }
}
