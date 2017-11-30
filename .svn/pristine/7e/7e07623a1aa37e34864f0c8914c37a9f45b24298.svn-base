package com.ningchuang.youwuquan.ui.commom.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lcodecore.extextview.ExpandTextView;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.commom.adapter.DianzanAdapter;
import com.ningchuang.youwuquan.ui.commom.adapter.ImageAdapter;
import com.ningchuang.youwuquan.ui.find.bean.Model_Find_Bean;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.ningchuang.youwuquan.view.FullyLinearLayoutManager;
import com.ningchuang.youwuquan.view.GlideCircleTransform;
import com.ningchuang.youwuquan.view.NinePic.model.NineGridPicShowModel;
import com.zqd.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity {

    @Bind(R.id.dongtai_back)
    ImageView dongtaiBack;
    @Bind(R.id.details_head_icon)
    ImageView detailsHeadIcon;
    @Bind(R.id.details_guanzhu)
    Button detailsGuanzhu;
    @Bind(R.id.details_text)
    ExpandTextView detailsText;
    @Bind(R.id.details_image)
    RecyclerView detailsImage;
    @Bind(R.id.details_dianzan)
    RecyclerView detailsDianzan;
    @Bind(R.id.details_comment)
    RecyclerView detailsComment;
    @Bind(R.id.details_input)
    EditText detailsInput;
    @Bind(R.id.details_head_name)
    TextView detailsHeadName;
    @Bind(R.id.details_head_time)
    TextView detailsHeadTime;


    private Model_Find_Bean details;

    private List<String> url_List = null;
    private FullyLinearLayoutManager linearLayoutManager;

    //用的本地数据
    private List<Integer> dianzan_list = null;

    private boolean isImageModel = true;


    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    public void initPresenter() {
        details = (Model_Find_Bean) getIntent().getSerializableExtra("details");
        List<NineGridPicShowModel> model_imageString = details.getModel_ImageString();

        url_List = new ArrayList<>();

//传递九宫格的数据
        List<NineGridPicShowModel> image_List = details.getModel_ImageString();

        //为了判断是否图片为空  毕竟还有纯文字和小视频
        if (image_List != null) {
            for (NineGridPicShowModel i : image_List) {

                for (String j : i.urlList) {
                    url_List.add(j);
                }
//            textIamge_holder.ninePicDongtaiPic.setIsShowAll(i.isShowAll);
//            textIamge_holder.ninePicDongtaiPic.setUrlList(i.urlList);
            }
        } else {
            isImageModel = false;
        }


        dianzan_list = new ArrayList<>();

        dianzan_list.add(R.mipmap.ic_home_liked);

        for (int i = 0; i < 15; i++) {
            dianzan_list.add(R.mipmap.pingluntou);
        }

        LogUtils.e(" 点赞 " + dianzan_list.size());
    }

    @Override
    public void initView() {
//        RecyclerView detailsImage;
//        RecyclerView detailsDianzan;
//        RecyclerView detailsComment;


        //设置头部的 用户图片 用户名  发布时间
        Glide.with(this).load(details.getModel_Icon()).transform(new GlideCircleTransform(this)).error(R.mipmap.ic_launcher_round).into(detailsHeadIcon);
        detailsHeadName.setText(details.getModel_Name());
        detailsHeadTime.setText(details.getModel_Time());
        detailsText.setText("\t\t\t\t" + details.getModel_TextString());

        linearLayoutManager = new FullyLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10);


        if (isImageModel == true) {
            // 图片显示列表
            detailsImage.setLayoutManager(linearLayoutManager);
            detailsImage.setNestedScrollingEnabled(false);
            detailsImage.setAdapter(new ImageAdapter(this, url_List));
        } else {
            detailsImage.setVisibility(View.GONE);
        }

        //点赞列表
        detailsDianzan.setLayoutManager(gridLayoutManager);
        detailsDianzan.setNestedScrollingEnabled(false);
        detailsDianzan.setAdapter(new DianzanAdapter(this, dianzan_list));

//        //评论列表
//        detailsComment.setLayoutManager(linearLayoutManager);
//        detailsComment.setAdapter();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.dongtai_back, R.id.details_head_icon, R.id.details_guanzhu, R.id.details_input})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dongtai_back:
                break;
            case R.id.details_head_icon:
                break;
            case R.id.details_guanzhu:
                break;
            case R.id.details_input:
                break;
        }
    }

}