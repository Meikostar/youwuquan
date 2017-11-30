package com.ningchuang.youwuquan.ui.upload.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.adapter.FlagAdapter;
import com.ningchuang.youwuquan.ui.home.adapter.SearchAdapter;
import com.ningchuang.youwuquan.ui.home.bean.SearchHotBean;
import com.ningchuang.youwuquan.utils.DensityUtil;
import com.ningchuang.youwuquan.view.Custom_TagBtn;
import com.ningchuang.youwuquan.view.FlexboxLayout;
import com.ningchuang.youwuquan.view.MarkaEditText;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.widget.ShowDilog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FlagActivity extends BaseActivity implements FlagAdapter.SetOnSearchClick ,ShowDilog.SetOnDilogClick {


    @Bind(R.id.ll_cancel)
    LinearLayout llCancel;
    @Bind(R.id.tv_sure)
    TextView tvSure;
    @Bind(R.id.fbl_tag)
    FlexboxLayout flexboxLayout;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv_search_history_cancle)
    ImageView ivSearchHistoryCancle;
    @Bind(R.id.rlv_search_history)
    RecyclerView rlvSearchHistory;
    @Bind(R.id.rlv_search_hot)
    RecyclerView rlvSearchHot;
    @Bind(R.id.ll_click)
    LinearLayout llClick;
    private FlagAdapter searchAdapter;
    private List<String> searchList;
    private List<String> hotList;
    private ShowDilog showDilog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_flag;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        searchList = new ArrayList<>();
        hotList = new ArrayList<>();
        searchList.add("软妹子");
        hotList.add("软妹子");
        searchList.add("");
        searchList.add("");
        searchList.add("Lxm");
        hotList.add("Lxm");
        searchList.add("Meiko");
        hotList.add("Meiko");
        searchList.add("");
        searchList.add("LM");
        hotList.add("LM");
        searchList.add("小米");
        hotList.add("小米");
        searchList.add("伟大");
        hotList.add("伟大");
        hotList.add("daye");
        hotList.add("号上");
        hotList.add("大哥");
        initRec();
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxManager.post("flag", addmap);
                finish();
            }
        });
        llCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        llClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addmap.add("#"+edit_tag.getText().toString().trim()+"#");
                setTagAdapter(addmap);
                edit_tag.setText("");
            }
        });
        ivSearchHistoryCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyBoard();
                showDilog = new ShowDilog(FlagActivity.this,FlagActivity.this,"取消","确定","提示","\n确定删除全部历史记录?\n");
                showDilog.showDilog();
            }
        });
        if(ReleaseActivity.addmap.size()>0){
            addmap.addAll(ReleaseActivity.addmap);
            setTagAdapter(ReleaseActivity.addmap);
        }

    }

    private void initRec() {
        setTagAdapter(addmap);
        searchAdapter = new FlagAdapter(searchList, this);
        rlvSearchHistory.setLayoutManager(new GridLayoutManager(this, 3));
        rlvSearchHistory.setNestedScrollingEnabled(false);
        rlvSearchHistory.setAdapter(searchAdapter);

        rlvSearchHot.setLayoutManager(new GridLayoutManager(this, 3));
        rlvSearchHot.setNestedScrollingEnabled(false);
        searchAdapter.setData(hotList);
        rlvSearchHot.setAdapter(searchAdapter);
    }
    public  List<String> addmap=new ArrayList<>();
    private Map<String,String> map=new HashMap<>();
    /**
     * 初始化标签适配器
     */
    private boolean first;
    private MarkaEditText edit_tag;
    private void setTagAdapter(final List<String> list) {
        if(list.size()>0){
            tvSure.setTextColor(getResources().getColor(R.color.choose));
        }else {
            tvSure.setTextColor(getResources().getColor(R.color.unchoose));
        }
        flexboxLayout.removeAllViews();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                final Custom_TagBtn tagBtn = createBaseFlexItemTextView(list.get(i));
                final int position = i;
                tagBtn.setCustom_TagBtnListener(new Custom_TagBtn.Custom_TagBtnListener() {
                    @Override
                    public void clickDelete() {
                        for (int j = 0; j < list.size(); j++) {
                            if (j == position) {
                                map.remove(addmap.get(j));
                                addmap.remove(j);
                                setTagAdapter(addmap);
//                                index = j;
//                                model.deletescreenDel(list.get(j).screen_id, ShieldOrderActivity.this);
                            }
                        }
                    }
                });
                flexboxLayout.addView(tagBtn, i);
            }
        }
         edit_tag = createBaseFlexItemEditText();

        edit_tag.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE && edit_tag.getText().length() > 0) {
                 addmap.add("#"+edit_tag.getText().toString().trim()+"#");
                    setTagAdapter(addmap);
                    edit_tag.setText("");
                }
                return false;
            }
        });


        edit_tag.setChangeListener(new MarkaEditText.ChangeListener() {
            @Override
            public void change(String s) {
                if(!TextUtils.isEmpty(s)){
                    tvName.setText(s);
                }
            }
        });
        flexboxLayout.addView(edit_tag);
        edit_tag.setFocusable(true);
        edit_tag.setFocusableInTouchMode(true);
        InputMethodManager inputManager = (InputMethodManager) edit_tag.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(edit_tag, 0);
        closeKeyBoard();
        if (!first){
            first=true;
            edit_tag.requestFocus();
        }
    }

    /**
     * 创建流式布局item
     *
     * @return
     */
    public MarkaEditText createBaseFlexItemEditText() {
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin = DensityUtil.dip2px(this, 10);
        lp.leftMargin = DensityUtil.dip2px(this, 15);

        MarkaEditText view = (MarkaEditText) LayoutInflater.from(this).inflate(R.layout.tag_write, null);
        view.setLayoutParams(lp);
        return view;
    }

    public Custom_TagBtn createBaseFlexItemTextView(String content) {
        FlexboxLayout.LayoutParams lp = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin = DensityUtil.dip2px(this, 1);
        lp.leftMargin = DensityUtil.dip2px(this, 2);
        Custom_TagBtn view = null;
        view = (Custom_TagBtn) LayoutInflater.from(this).inflate(R.layout.flag_views, null);
        view.setLayoutParams(lp);
        view.setCustomText(content);

        return view;
    }




    @Override
    public void onSearchClick(View view, String name, int pos) {
        String content = map.get(name);

        if(TextUtils.isEmpty(content)){
            map.put(name,name);
            addmap.add("#"+name+"#");
            setTagAdapter(addmap);
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
