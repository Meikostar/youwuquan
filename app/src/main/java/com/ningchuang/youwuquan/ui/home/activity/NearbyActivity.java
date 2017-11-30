package com.ningchuang.youwuquan.ui.home.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.home.adapter.NearbyPeopleAdapter;
import com.ningchuang.youwuquan.ui.home.bean.NearbyPeopleBean;
import com.ningchuang.youwuquan.view.PhotoPopupWindow;
import com.zqd.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class NearbyActivity extends BaseActivity implements NearbyPeopleAdapter.SetOnNearbyPeopleClick {


    @Bind(R.id.rlv_nearby_people)
    RecyclerView rlvNearbyPeople;


    private NearbyPeopleAdapter nearbyPeopleAdapter = null;
    private List<NearbyPeopleBean> peopleBeanList = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_nearby;
    }

    @Override
    public void initPresenter() {

    }
    private PhotoPopupWindow mWindowAddPhoto;
    public void showPopwindow(){
        if(mWindowAddPhoto==null){

                mWindowAddPhoto = new PhotoPopupWindow(this);
                mWindowAddPhoto.setListener(new PhotoPopupWindow.ItemClick() {
                    @Override
                    public void click(int type) {
                        mWindowAddPhoto.dismiss();
                    }
                });
                mWindowAddPhoto.showAtLocation(rlvNearbyPeople, Gravity.BOTTOM, 0, 0);

        }else {
              if(!mWindowAddPhoto.isShowing()){
                  mWindowAddPhoto.showAtLocation(rlvNearbyPeople, Gravity.BOTTOM, 0, 0);
              }else {
                  mWindowAddPhoto.dismiss();
            }
        }

    }
    @Override
    public void initView() {
//        navigationBar.setNavigationBarListener(this);
        peopleBeanList = new ArrayList<>();
        peopleBeanList.add(new NearbyPeopleBean());
        peopleBeanList.add(new NearbyPeopleBean());
        peopleBeanList.add(new NearbyPeopleBean());
        peopleBeanList.add(new NearbyPeopleBean());
        nearbyPeopleAdapter = new NearbyPeopleAdapter(peopleBeanList, this);
        rlvNearbyPeople.setLayoutManager(new GridLayoutManager(this, 2));
        rlvNearbyPeople.setAdapter(nearbyPeopleAdapter);
    }


    @OnClick({R.id.top_home_black, R.id.top_home_filtrate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_home_black:
                finish();
                break;
            case R.id.top_home_filtrate:
                showPopwindow();
                break;
        }
    }

    @Override
    public void onNearbyPeopleClick(View view, Object o, int pos) {

    }


}
