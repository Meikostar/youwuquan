package com.ningchuang.youwuquan.ui.news.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.news.adapter.MessageAdapter;
import com.ningchuang.youwuquan.ui.news.adapter.PlayAdapter;
import com.ningchuang.youwuquan.ui.news.bean.MessageBean;
import com.ningchuang.youwuquan.ui.news.bean.PlayBeans;
import com.zqd.common.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends BaseFragment implements PlayAdapter.SetOnPlayClick ,MessageAdapter.SetMessageClick{


    @Bind(R.id.iv_news_gg)
    ImageView ivNewsGg;
    @Bind(R.id.tv_news_notice_name)
    TextView tvNewsNoticeName;
    @Bind(R.id.tv_news_notice_context)
    TextView tvNewsNoticeContext;
    @Bind(R.id.rlv_news_play)
    RecyclerView rlvNewsPlay;
    @Bind(R.id.rlv_news_message)
    RecyclerView rlvNewsMessage;

    private MessageAdapter messageAdapter = null;
    private List<MessageBean> messageList = null;
    private PlayAdapter playAdapter = null;
    private List<PlayBeans> playList = null;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_new;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        playList = new ArrayList<>();
        playList.add(new PlayBeans());
        playList.add(new PlayBeans());
        playList.add(new PlayBeans());
        playList.add(new PlayBeans());

        messageList = new ArrayList<>();
        messageList.add(new MessageBean());
        messageList.add(new MessageBean());
        messageList.add(new MessageBean());
        messageList.add(new MessageBean());
        messageList.add(new MessageBean());
        messageList.add(new MessageBean());
        messageList.add(new MessageBean());
        messageList.add(new MessageBean());
        initRec();
    }

    private void initRec() {
        playAdapter = new PlayAdapter(playList,this);
        LinearLayoutManager playLineraManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rlvNewsPlay.setLayoutManager(playLineraManager);
        rlvNewsPlay.setAdapter(playAdapter);

        messageAdapter = new MessageAdapter(messageList,this);
        rlvNewsMessage.setNestedScrollingEnabled(false);
        rlvNewsMessage.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvNewsMessage.setAdapter(messageAdapter);


    }

    @Override
    protected void lazyLoad() {

    }
    @OnClick(R.id.rll_news_notice)
    public void onViewClicked() {
    }

    @Override
    public void onPlayClick(View view, Object o, int pos) {

    }

    @Override
    public void onMessageClick(View view, Object o, int pos) {

    }
}
