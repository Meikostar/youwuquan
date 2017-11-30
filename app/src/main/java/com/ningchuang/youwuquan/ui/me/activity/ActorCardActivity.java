package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mcxtzhang.commonadapter.rv.CommonAdapter;
import com.mcxtzhang.commonadapter.rv.ViewHolder;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.adapter.CardSelectAdapter;
import com.ningchuang.youwuquan.ui.me.bean.CardBean;
import com.ningchuang.youwuquan.ui.me.bean.CardSelectBean;
import com.ningchuang.youwuquan.ui.me.contract.TanTanCallback;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.utils.ImageLoaderUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActorCardActivity extends BaseActivity implements CardSelectAdapter.SetOnCardSelectClick {


    @Bind(R.id.top_home_black)
    ImageView topHomeBlack;
    @Bind(R.id.top_home_title)
    TextView topHomeTitle;
    @Bind(R.id.top_home_filtrate)
    ImageView topHomeFiltrate;
    @Bind(R.id.rlv_actor_card)
    RecyclerView rlvActorCard;
    CommonAdapter<CardBean> mAdapter;
    List<CardBean> mDatas = new ArrayList<>();
    @Bind(R.id.rlv_actor_card_select)
    RecyclerView rlvActorCardSelect;

    private List<CardSelectBean> cardSelectBeanList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_actor_card;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mDatas.add(new CardBean(R.mipmap.three_one));
        mDatas.add(new CardBean(R.mipmap.three_two));
        mDatas.add(new CardBean(R.mipmap.three_three));

        topHomeTitle.setText("模版");
        topHomeFiltrate.setVisibility(View.GONE);
        cardSelectBeanList.add(new CardSelectBean(R.mipmap.off3, "三张"));
        cardSelectBeanList.add(new CardSelectBean(R.mipmap.off4, "四张"));
        cardSelectBeanList.add(new CardSelectBean(R.mipmap.off5, "五张"));
        cardSelectBeanList.add(new CardSelectBean(R.mipmap.off6, "六张"));
        cardSelectBeanList.add(new CardSelectBean(R.mipmap.off7, "七张"));
        cardSelectBeanList.add(new CardSelectBean(R.mipmap.off8, "八张"));

        rlvActorCard.setLayoutManager(new OverLayCardLayoutManager());
        rlvActorCardSelect.setLayoutManager(new LinearLayoutManager(ActorCardActivity.this, LinearLayoutManager.HORIZONTAL, false));
        rlvActorCardSelect.setAdapter(new CardSelectAdapter(cardSelectBeanList, this));
        rlvActorCard.setAdapter(mAdapter = new CommonAdapter<CardBean>(this, mDatas, R.layout.item_actor_card) {


            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                return super.onCreateViewHolder(parent, viewType);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {

                super.onBindViewHolder(holder, position);
            }

            @Override
            public void convert(ViewHolder viewHolder, CardBean cardBean) {
                ImageLoaderUtils.display(ActorCardActivity.this, viewHolder.getView(R.id.iv_card_tou), cardBean.getTu());
            }
        });

        CardConfig.initConfig(this);

        final TanTanCallback callback = new TanTanCallback(rlvActorCard, mAdapter, mDatas);

        //测试竖直滑动是否已经不会被移除屏幕
        //callback.setHorizontalDeviation(Integer.MAX_VALUE);

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(rlvActorCard);
    }


    @Override
    public void onCardSelectClick(int pos) {
        switch (pos) {
            case 0:
                mDatas.clear();
                mDatas.add(new CardBean(R.mipmap.three_one));
                mDatas.add(new CardBean(R.mipmap.three_two));
                mDatas.add(new CardBean(R.mipmap.three_three));
                mAdapter.notifyDataSetChanged();
                break;
            case 1:
                mDatas.clear();
                mDatas.add(new CardBean(R.mipmap.four_one));
                mDatas.add(new CardBean(R.mipmap.four_two));
                mDatas.add(new CardBean(R.mipmap.four_three));
                mAdapter.notifyDataSetChanged();
                break;
            case 2:
                mDatas.clear();
                mDatas.add(new CardBean(R.mipmap.five_one));
                mDatas.add(new CardBean(R.mipmap.five_two));
                mDatas.add(new CardBean(R.mipmap.five_three));
                mAdapter.notifyDataSetChanged();
                break;
            case 3:
                mDatas.clear();
                mDatas.add(new CardBean(R.mipmap.six_one));
                mDatas.add(new CardBean(R.mipmap.six_two));
                mDatas.add(new CardBean(R.mipmap.six_three));
                mAdapter.notifyDataSetChanged();
                break;
            case 4:
                mDatas.clear();
                mDatas.add(new CardBean(R.mipmap.seven_one));
                mDatas.add(new CardBean(R.mipmap.seven_two));
                mDatas.add(new CardBean(R.mipmap.seven_three));
                mAdapter.notifyDataSetChanged();
                break;
            case 5:
                mDatas.clear();
                mDatas.add(new CardBean(R.mipmap.eight_one));
                mDatas.add(new CardBean(R.mipmap.eight_two));
                mDatas.add(new CardBean(R.mipmap.eight_three));
                mAdapter.notifyDataSetChanged();
                break;
        }
    }


    @OnClick(R.id.top_home_black)
    public void onViewClicked() {
        finish();
    }
}
