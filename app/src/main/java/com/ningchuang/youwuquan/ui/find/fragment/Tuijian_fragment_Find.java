package com.ningchuang.youwuquan.ui.find.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.commom.adapter.DongtaiAdapter;
import com.ningchuang.youwuquan.ui.find.adapter.HuodongAdapter;
import com.ningchuang.youwuquan.ui.find.bean.HuodongBean;
import com.ningchuang.youwuquan.ui.find.bean.Model_Find_Bean;
import com.ningchuang.youwuquan.view.FullyLinearLayoutManager;
import com.ningchuang.youwuquan.view.NinePic.model.NineGridPicShowModel;
import com.zqd.common.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/30 0030.
 */

public class Tuijian_fragment_Find extends BaseFragment {
    @Bind(R.id.recyc_huodong_tuijian)
    RecyclerView recycHuodongTuijian;
    @Bind(R.id.text_more_tuijian)
    TextView textMoreTuijian;
    @Bind(R.id.linenr_gengduo_tuijian)
    LinearLayout linenrGengduoTuijian;
    @Bind(R.id.recyc_dongtai_tuijian)
    RecyclerView recycDongtaiTuijian;


    public List<HuodongBean> mHuodongList;

    public List<Model_Find_Bean> mDongtaiList = null;

    // 九宫格用的
    private String[] mUrls;
    private NineGridPicShowModel showModel;
    private List<NineGridPicShowModel> pic_List;


    private FullyLinearLayoutManager linearLayoutManager_Huodong ,linearLayoutManager_Dongtai;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_tuijian;
    }

    @Override
    public void initPresenter() {
        mHuodongList = new ArrayList<>();
        mHuodongList.add(new HuodongBean(null, "这个是标题 0", "这个是内容 0", "这个是立即参与 o"));
        mHuodongList.add(new HuodongBean(null, "这个是标题 1", "这个是内容 1", "这个是立即参与 1"));




        mUrls = new String[]{
                "http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
                "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
                "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg",
                "http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg",
                "http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",

        };
        pic_List = new ArrayList<>();

        showModel = new NineGridPicShowModel();
        for (int i = 0; i<mUrls.length;i++){
            showModel.urlList.add(mUrls[i]);
        }
        pic_List.add(showModel);





        mDongtaiList = new ArrayList<>();

        mDongtaiList.add(new Model_Find_Bean("http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg", "A模特", "2017/10/24"
                , "这个是文本", null, null, null, "30", "100", 0));

        mDongtaiList.add(new Model_Find_Bean("http://img4.imgtn.bdimg.com/it/u=2770691011,100164542&fm=214&gp=0.jpg", "B模特", "2017/10/24"
                , "2017 Google 开发者大会为期两天，将于 12 月 13 日和 14 日在上海举办，主题将涵盖机器学习 (Machine Learning)、Android、移动网络" +
                "（Mobile Web)、Firebase、云服务 (Cloud)、AR/VR、设计 (Design) 以及更多。我们非常高兴与您分享我们关于创新技术的想法，鼓励广大开发者着手构建下一个精彩的移动应用或网络体验。"
                ,pic_List , null, null, "40", "200", 1));

//
//        for (Model_Find_Bean  i : mDongtaiList){
//            LogUtils.e(i.toString()+"\n");
//        }

//        mDongtaiList.add(new Model_Find_Bean("http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg", "C模特", "2017/10/24"
//                , "null", null, null, null, 30, 100, 2));
//
//        mDongtaiList.add(new Model_Find_Bean("http://img1.skqkw.cn:888/2014/11/26/08/fgzaxeigbs1-71580.jpg", "D模特", "2017/10/24"
//                , "这个是文本", "http://pic.qqtn.com/up/2017-10/15079519633602903.jpg/http://pic.qqtn.com/up/2017-10/15079519633602903.jpg/http://pic.qqtn.com/up/2017-10/15079519633602903.jpg"
//                , null, null, 30, 100, 0));
//
//        mDongtaiList.add(new Model_Find_Bean("http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg", "E模特", "2017/10/24"
//                , "这个是文本", null, null, null, 30, 100, 0));
//

    }

    @Override
    protected void initView() {
        linearLayoutManager_Huodong = new FullyLinearLayoutManager(getContext(), FullyLinearLayoutManager.VERTICAL, false);
        recycHuodongTuijian.setNestedScrollingEnabled(false);
        recycHuodongTuijian.setLayoutManager(linearLayoutManager_Huodong);


        linearLayoutManager_Dongtai = new FullyLinearLayoutManager(getContext(), FullyLinearLayoutManager.VERTICAL, false);
        recycDongtaiTuijian.setNestedScrollingEnabled(false);
        recycDongtaiTuijian.setLayoutManager(linearLayoutManager_Dongtai);



        HuodongAdapter mHuodongAdapter = new HuodongAdapter(getContext(), mHuodongList);
        DongtaiAdapter mDongtaiAdapter = new DongtaiAdapter(getContext(), mDongtaiList);

        recycHuodongTuijian.setAdapter(mHuodongAdapter);
        recycDongtaiTuijian.setAdapter(mDongtaiAdapter);

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
