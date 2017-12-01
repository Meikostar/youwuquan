package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.bean.RecodeBean;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecodeActivity extends BaseActivity {

    private List<RecodeBean> mList = null;

    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.recode_me_recycle)
    RecyclerView recodeMeRecycle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_recode;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        navigationBar.setNavigationBarListener(this);
        mList = new ArrayList<>();
        mList.add(new RecodeBean("提现", "2017-09-3 08:33:15", "-3000"));
        mList.add(new RecodeBean("充值", "2017-09-3 08:33:15", "-3000"));
        mList.add(new RecodeBean("打赏", "2017-09-3 08:33:15", "-3000"));
        mList.add(new RecodeBean("收到打赏", "2017-09-3 08:33:15", "+9000"));


        recodeMeRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recodeMeRecycle.setAdapter(new MyRecodeAdapter());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.recode_me_back, R.id.recode_me_recycle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recode_me_back:
                break;
            case R.id.recode_me_recycle:
                break;
        }
    }

    private class MyRecodeAdapter extends RecyclerView.Adapter<MyRecodeAdapter.MyViewHolder> {
        @Override
        public MyRecodeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(View.inflate(RecodeActivity.this, R.layout.recode_item, null));
        }

        @Override
        public void onBindViewHolder(MyRecodeAdapter.MyViewHolder holder, int position) {

            holder.mRecode_Action.setText(mList.get(position).getAction());
            holder.mRecode_Time.setText(mList.get(position).getTime());
            holder.mRecode_Money.setText(mList.get(position).getMoney());


        }

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView mRecode_Action, mRecode_Time, mRecode_Money;

            public MyViewHolder(View itemView) {
                super(itemView);
                mRecode_Action = itemView.findViewById(R.id.recode_item_action);
                mRecode_Time = itemView.findViewById(R.id.recode_item_time);
                mRecode_Money = itemView.findViewById(R.id.recode_item_money);

            }
        }
    }
}
