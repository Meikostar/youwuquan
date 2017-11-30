package com.ningchuang.youwuquan.ui.find.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.commom.adapter.DongtaiAdapter;
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

public class Guanzhu_fragment_Find extends BaseFragment {
    @Bind(R.id.recyc_guanzhu)
    RecyclerView recyc_Guanzhu;

    public List<Model_Find_Bean> mGuanzhuList = null;

    // 九宫格用的
    private String[] mUrls,mUrls2;
    private NineGridPicShowModel showModel,showModel2;
    private List<NineGridPicShowModel> pic_List,pic_List2;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragmnet_guanzhu;
    }

    @Override
    public void initPresenter() {

        mGuanzhuList = new ArrayList<>();

        mUrls = new String[]{
                "http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
                "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
                "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg",
                "http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg",
                "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
                "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg",
                "http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg",
                "http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
                "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg"};

        mUrls2 = new String[]{
                "http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
                "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
                "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
                "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg",
                "http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
                "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg"};


        pic_List = new ArrayList<>();

        showModel = new NineGridPicShowModel();
        for (int i = 0; i < mUrls.length; i++) {
            showModel.urlList.add(mUrls[i]);
        }
        pic_List.add(showModel);

        pic_List2 = new ArrayList<>();

        showModel2 = new NineGridPicShowModel();
        for (int i = 0; i < mUrls2.length; i++) {
            showModel2.urlList.add(mUrls2[i]);
        }
        pic_List2.add(showModel2);




        mGuanzhuList.add(new Model_Find_Bean("http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg", "A模特", "2017/10/24"
                , "这个是文本", null, null, null, "30", "100", 0));

        mGuanzhuList.add(new Model_Find_Bean("http://img4.imgtn.bdimg.com/it/u=2770691011,100164542&fm=214&gp=0.jpg", "B模特", "2017/10/24"
                , "2017 Google 开发者大会为期两天，将于 12 月 13 日和 14 日在上海举办，主题将涵盖机器学习 (Machine Learning)、Android、移动网络" +
                "（Mobile Web)、Firebase、云服务 (Cloud)、AR/VR、设计 (Design) 以及更多。我们非常高兴与您分享我们关于创新技术的想法，鼓励广大开发者着手构建下一个精彩的移动应用或网络体验。"
                , pic_List, null, null, "40", "200", 1));
        mGuanzhuList.add(new Model_Find_Bean("http://img4.imgtn.bdimg.com/it/u=2770691011,100164542&fm=214&gp=0.jpg", "B模特", "2017/10/24"
                , "2017 Google 开发者大会为期两天，将于 12 月 13 日和 14 日在上海举办，主题将涵盖机器学习 (Machine Learning)、Android、移动网络" +
                "（Mobile Web)、Firebase、云服务 (Cloud)、AR/VR、设计 (Design) 以及更多。我们非常高兴与您分享我们关于创新技术的想法，鼓励广大开发者着手构建下一个精彩的移动应用或网络体验。"
                , pic_List2, null, null, "40", "200", 1));

    }

    @Override
    protected void initView() {
        recyc_Guanzhu.setLayoutManager(new FullyLinearLayoutManager(getContext(), FullyLinearLayoutManager.VERTICAL, false));
        DongtaiAdapter mDongtaiAdapter = new DongtaiAdapter(getContext(), mGuanzhuList);

        //设置item间距，30dp

        recyc_Guanzhu.setAdapter(mDongtaiAdapter);

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
