package com.ningchuang.youwuquan.ui.upload.activity;


import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningchuang.youwuquan.PermissionConst;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.utils.DensityUtil;
import com.ningchuang.youwuquan.view.Custom_TagBtn;
import com.ningchuang.youwuquan.view.FlexboxLayout;
import com.ningchuang.youwuquan.view.ImageUploadView;
import com.ningchuang.youwuquan.view.MarkaEditText;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.permission.PermissionGen;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class ReleaseActivity extends BaseActivity {


    @Bind(R.id.tv_cancel)
    TextView tvCancel;
    @Bind(R.id.tv_send)
    TextView tvSend;
    @Bind(R.id.et_content)
    MarkaEditText etContent;
    @Bind(R.id.tv_flag)
    TextView tvFlag;
    @Bind(R.id.fbl_tag)
    FlexboxLayout flexboxLayout;
    @Bind(R.id.iv_add_photo)
    ImageView ivAddPhoto;
    @Bind(R.id.piuv_remark_image)
    ImageUploadView piuvRemarkImage;
    @Bind(R.id.iv_pri_add_photo)
    ImageView ivPriAddPhoto;
    @Bind(R.id.piuv_pri_remark_image)
    ImageUploadView piuvPriRemarkImage;
    public static List<String> addmap=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_release;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mRxManager.mRxBus.register("flag");
        mRxManager.on("flag", new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {
                addmap.clear();
                addmap.addAll(strings);
                flexboxLayout.setVisibility(View.VISIBLE);
                tvFlag.setVisibility(View.GONE);
                setTagAdapter(addmap);
            }
        });
        piuvRemarkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPhoto();
            }
        });
        piuvPriRemarkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPhoto();
            }
        });
     tvFlag.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(FlagActivity.class);
         }
     });
     flexboxLayout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(FlagActivity.class);
         }
     });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void addPhoto() {
        closeKeyBoard();
        PermissionGen.with(ReleaseActivity.this)
                .addRequestCode(PermissionConst.REQUECT_CODE_CAMERA)
                .permissions(Manifest.permission.CAMERA)
                .request();
    }

    /**
     * 初始化标签适配器
     */
    private void setTagAdapter(final List<String> list) {
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


}
