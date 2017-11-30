package com.ningchuang.youwuquan.ui.home.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.adapter.SearchAdapter;
import com.ningchuang.youwuquan.ui.home.bean.SearchHotBean;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.widget.ShowDilog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements SearchAdapter.SetOnSearchClick,ShowDilog.SetOnDilogClick {


    @Bind(R.id.et_search_context)
    EditText etSearchContext;
    @Bind(R.id.rll_search_context)
    RelativeLayout rllSearchContext;
    @Bind(R.id.rlv_search_history)
    RecyclerView rlvSearchHistory;
    @Bind(R.id.rlv_search_hot)
    RecyclerView rlvSearchHot;

    private SearchAdapter searchAdapter = null;
    private List<SearchHotBean> searchList = null;
    private ShowDilog showDilog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        searchList = new ArrayList<>();
        searchList.add(new SearchHotBean());
        searchList.add(new SearchHotBean());
        searchList.add(new SearchHotBean());
        searchList.add(new SearchHotBean());
        initRec();
        etSearchContext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchActivity.this.getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    //进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
                    search();
                }
                return false;
            }
        });
    }

    // 搜索功能

    private void search() {
         startActivity(SearchResultActivity.class);
    }
    private void initRec() {


        searchAdapter = new SearchAdapter(searchList, this);
        rlvSearchHistory.setLayoutManager(new GridLayoutManager(this, 3));
        rlvSearchHistory.setNestedScrollingEnabled(false);
        rlvSearchHistory.setAdapter(searchAdapter);


        rlvSearchHot.setLayoutManager(new GridLayoutManager(this, 3));
        rlvSearchHot.setNestedScrollingEnabled(false);
        rlvSearchHot.setAdapter(searchAdapter);
    }


    @Override
    public void onSearchClick(View view, Object o, int pos) {
          startActivity(SearchResultActivity.class);
    }



    @OnClick({R.id.rll_search_cancle, R.id.iv_search_history_cancle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rll_search_cancle:
                finish();
                break;
            case R.id.iv_search_history_cancle:
                showDilog = new ShowDilog(this,this,"取消","确定","提示","\n确定删除全部历史记录?\n");
                showDilog.showDilog();
                break;
        }
    }

    @Override
    public void OnCancleClick() {
        showDilog.cancle();
    }

    @Override
    public void OnSureClick() {
        searchList.clear();
        searchAdapter.notifyDataSetChanged();
        showDilog.cancle();
    }
}
