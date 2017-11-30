package com.ningchuang.youwuquan.ui.find.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.extextview.ExpandTextView;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.find.adapter.InfoAdapter;
import com.ningchuang.youwuquan.ui.find.adapter.JinengAdapter;
import com.ningchuang.youwuquan.ui.find.adapter.RenzhengAdapater;
import com.ningchuang.youwuquan.ui.find.bean.Model_Find_Bean;
import com.ningchuang.youwuquan.ui.find.bean.Renzheng_Bean;
import com.ningchuang.youwuquan.utils.GlideImageLoader;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.ningchuang.youwuquan.view.NinePic.model.NineGridPicShowModel;
import com.youth.banner.Banner;
import com.zqd.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ModelInfoActivity extends BaseActivity {

    @Bind(R.id.share_text_modelInfo)
    TextView shareTextModelInfo;
    @Bind(R.id.modelName_text_modelInfo)
    TextView modelNameTextModelInfo;
    @Bind(R.id.back_Iamge_modelInfo)
    ImageView backIamgeModelInfo;
    @Bind(R.id.juli_text_modelInfo)
    TextView juliTextModelInfo;
    @Bind(R.id.xingzuo_text_modelInfo)
    TextView xingzuoTextModelInfo;
    @Bind(R.id.xingzuo_image_modelInfo)
    ImageView xingzuoImageModelInfo;
    @Bind(R.id.guanzhu_button_modelInfo)
    Button guanzhuButtonModelInfo;
    @Bind(R.id.shenao_text_modelInfo)
    TextView shenaoTextModelInfo;
    @Bind(R.id.sanwei_text_modelInfo)
    TextView sanweiTextModelInfo;
    @Bind(R.id.tizhong_text_modelInfo)
    TextView tizhongTextModelInfo;
    @Bind(R.id.jianjie_text_modelInfo)
    ExpandTextView jianjieTextModelInfo;
    @Bind(R.id.rennzheng_recyc_modelInfo)
    RecyclerView rennzhengRecycModelInfo;
    @Bind(R.id.wechat_text_modelInfo)
    RelativeLayout wechatTextModelInfo;
    @Bind(R.id.phone_text_modelInfo)
    RelativeLayout phoneTextModelInfo;
    @Bind(R.id.dongtai_recyc_mopdelInfo)
    RecyclerView dongtaiRecycMopdelInfo;
    @Bind(R.id.jineng_recyc_modelInfo)
    RecyclerView jinengRecycModelInfo;
    @Bind(R.id.radio_modeInfo)
    LinearLayout radioModeInfo;
    @Bind(R.id.pic_viewpage_modelInfo)
    Banner picViewpageModelInfo;

    public List<Renzheng_Bean> renzhengList = null;

    public List<Integer> jinengList = null;

    public List<Model_Find_Bean> mList = null;
    private int type=0;
    private int[] icon = null;

    //Viewpager
    private String[] pic_Url = null;
    private List<String> view_List = null;

    // 九宫格用的
    private String[] mUrls;
    private NineGridPicShowModel showModel;
    private List<NineGridPicShowModel> pic_List;


    private ImageView imageView, radio;
    private Button button;


    @Override
    public int getLayoutId() {
        return R.layout.activity_model_info;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initPresenter() {
        renzhengList = new ArrayList<>();
        renzhengList.add(new Renzheng_Bean("尤物女神", R.mipmap.v1, true));
        renzhengList.add(new Renzheng_Bean("网红", R.mipmap.r1, true));
        renzhengList.add(new Renzheng_Bean("演员", R.mipmap.s1, true));
        renzhengList.add(new Renzheng_Bean("精舞达人", R.mipmap.d1, false));
        renzhengList.add(new Renzheng_Bean("嗨歌达人", R.mipmap.h1, false));
        renzhengList.add(new Renzheng_Bean("美妆达人", R.mipmap.m1, true));
        renzhengList.add(new Renzheng_Bean("美食达人", R.mipmap.f1, true));
        renzhengList.add(new Renzheng_Bean("旅游达人", R.mipmap.t1, true));
        renzhengList.add(new Renzheng_Bean("运动达人", R.mipmap.a1, false));
        renzhengList.add(new Renzheng_Bean("摄影达人", R.mipmap.p1, true));
        renzhengList.add(new Renzheng_Bean("穿搭达人", R.mipmap.c1, true));


        icon = new int[]{R.mipmap.find_food, R.mipmap.find_sing, R.mipmap.find_drink, R.mipmap.find_watch
                , R.mipmap.find_game, R.mipmap.find_party, R.mipmap.find_teatime, R.mipmap.find_photo};

        jinengList = new ArrayList<>();
        for (int i : icon) {

            LogUtils.w(" 技能  " + i);
            jinengList.add(i);

        }


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
        for (int i = 0; i < mUrls.length; i++) {
            showModel.urlList.add(mUrls[i]);
        }
        pic_List.add(showModel);


        LogUtils.e("   pic_List.add(showModel):  " + pic_List.size());


        mList = new ArrayList<>();

        mList.add(new Model_Find_Bean("http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg", "A模特", "2017/10/24"
                , "这个是文本", null, null, null, "30", "100", 0));

        mList.add(new Model_Find_Bean("http://img4.imgtn.bdimg.com/it/u=2770691011,100164542&fm=214&gp=0.jpg", "B模特", "2017/10/24"
                , "2017 Google 开发者大会为期两天，将于 12 月 13 日和 14 日在上海举办，主题将涵盖机器学习 (Machine Learning)、Android、移动网络" +
                "（Mobile Web)、Firebase、云服务 (Cloud)、AR/VR、设计 (Design) 以及更多。我们非常高兴与您分享我们关于创新技术的想法，鼓励广大开发者着手构建下一个精彩的移动应用或网络体验。"
                , pic_List, null, null, "40", "200", 1));


        pic_Url = new String[]{"http://img2.woyaogexing.com/2017/10/23/c3b79a207912d476!400x400_big.jpg"
                , "http://img2.woyaogexing.com/2017/10/23/43ffed087965b015!400x400_big.jpg"
                , "http://img2.woyaogexing.com/2017/11/10/fbe3413dcda08d58!400x400_big.jpg"};


        view_List = new ArrayList<>();
        for (int i = 0; i < pic_Url.length; i++) {
//            imageView = new ImageView(this);

//            Glide.with(ModelInfoActivity.this).load(pic_Url[i]).error(R.mipmap.ic_launcher).into(imageView);

//            view_List.add(imageView);

            view_List.add(pic_Url[i]);
        }


    }

    @Override
    public void initView() {
         type = getIntent().getIntExtra("type", 0);
         if(type!=0){
             guanzhuButtonModelInfo.setVisibility(View.INVISIBLE);
        }
        rennzhengRecycModelInfo.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        jinengRecycModelInfo.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        dongtaiRecycMopdelInfo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        RenzhengAdapater renzhengAdapater = new RenzhengAdapater(this, renzhengList);
        JinengAdapter jinengAdapter = new JinengAdapter(this, jinengList);
        InfoAdapter mAdapter = new InfoAdapter(this, mList);


        rennzhengRecycModelInfo.setAdapter(renzhengAdapater);
        rennzhengRecycModelInfo.setNestedScrollingEnabled(false);
        jinengRecycModelInfo.setAdapter(jinengAdapter);
        jinengRecycModelInfo.setNestedScrollingEnabled(false);
        dongtaiRecycMopdelInfo.setAdapter(mAdapter);
        dongtaiRecycMopdelInfo.setNestedScrollingEnabled(false);

        picViewpageModelInfo.setImageLoader(new GlideImageLoader());
        picViewpageModelInfo.setImages(view_List);
        //设置指示器位置（当banner模式中有指示器时）
//        picViewpageModelInfo.setIndicatorGravity(BannerConfig.RIGHT);
        picViewpageModelInfo.start();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
