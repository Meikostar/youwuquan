package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.me.adapter.MyPhotoAdapter;
import com.ningchuang.youwuquan.ui.me.adapter.SkillAdapter;
import com.ningchuang.youwuquan.ui.me.bean.AlbumBean;
import com.ningchuang.youwuquan.ui.me.bean.SkillBean;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SkillActivity extends BaseActivity implements SkillAdapter.SetItemClick {


    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.photo_me_recyc)
    RecyclerView photoMeRecyc;

    @Override
    public int getLayoutId() {
        return R.layout.activity_skill;
    }

    @Override
    public void initPresenter() {

    }
  private List<SkillBean> list=new ArrayList<>();
    @Override
    public void initView() {
        navigationBar.setNavigationBarListener(this);
        SkillBean sb = new SkillBean();
        SkillBean sb1 = new SkillBean();
        SkillBean sb2 = new SkillBean();
        SkillBean sb3 = new SkillBean();
        SkillBean sb4 = new SkillBean();
        SkillBean sb5 = new SkillBean();
        SkillBean sb6 = new SkillBean();
        SkillBean sb7 = new SkillBean();
        sb.id=R.mipmap.yuepai;
        sb1.id=R.mipmap.kge;
        sb2.id=R.mipmap.meishi;
        sb3.id=R.mipmap.heyibei;
        sb4.id=R.mipmap.kandianying;
        sb5.id=R.mipmap.xiawucha;
        sb6.id=R.mipmap.yingchou;
        sb7.id=R.mipmap.dayouxi;
        sb.name="约拍";
        sb1.name="K歌";
        sb2.name="吃美食";
        sb3.name="喝一杯";
        sb4.name="看电影";
        sb5.name="下午茶";
        sb6.name="应酬饭局";
        sb7.name="打游戏";
        list.add(sb);
        list.add(sb1);
        list.add(sb2);
        list.add(sb3);
        list.add(sb4);
        list.add(sb5);
        list.add(sb6);
        list.add(sb7);
        //设置item间距，30dp

        photoMeRecyc.setLayoutManager(new GridLayoutManager(this, 2));
        SkillAdapter mAdapter = new SkillAdapter(this, list,this);
        //设置item间距，30dp
        photoMeRecyc.setAdapter(mAdapter);
    }


    @Override
    public void onItemClick(View view, Object o, int pos) {
          startActivity(EditSkillActivity.class);
    }
}
