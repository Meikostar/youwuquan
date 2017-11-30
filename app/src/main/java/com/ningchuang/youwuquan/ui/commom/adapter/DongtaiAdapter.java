package com.ningchuang.youwuquan.ui.commom.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.commom.activity.DetailsActivity;
import com.ningchuang.youwuquan.ui.find.activity.ModelInfoActivity;
import com.ningchuang.youwuquan.ui.find.bean.Model_Find_Bean;
import com.ningchuang.youwuquan.utils.AnimationUtils;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.ningchuang.youwuquan.view.GlideCircleTransform;
import com.ningchuang.youwuquan.view.NinePic.NineGridPicView;
import com.ningchuang.youwuquan.view.NinePic.model.NineGridPicShowModel;

import java.util.List;

/**
 * Created by wuLiang  on 17-10-31.
 */

public class DongtaiAdapter extends RecyclerView.Adapter {
    /**
     * 纯文字
     * <p>
     * 文字加图片  只有图片就显示文字控件 gone
     * <p>
     * 文字加视频  只有视频就显示文字控件 gone
     */

    private int NULL_TYPE = -1;
    private final int TEXT_TYPE = 0;
    private final int IMAGE_TEXT_TYPE = 1;
    private final int VIDEO_TEXT_TYPE = 2;

    private Context context;
    private List<Model_Find_Bean> mLists;
    private Model_Find_Bean bean_text,bean_iamge_text;


    public DongtaiAdapter(Context context, List<Model_Find_Bean> mDongtaiList) {
        this.context = context;
        this.mLists = mDongtaiList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TEXT_TYPE:

                return new MyTextViewHolder(LayoutInflater.from(context).inflate(R.layout.item_dongtai_text, null));

            case IMAGE_TEXT_TYPE:
//                return new MyTextImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_text_image_find, null));

                return new MyTextImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_dongtai_tuwen, null));
//
//            case VIDEO_TEXT_TYPE:
//                return null;

        }

        return null;
    }


    @Override
    public int getItemViewType(int position) {

        if (mLists.get(position).getType() == TEXT_TYPE) {
            LogUtils.e("getItemViewType  TEXT_TYPE    " + position);
            return TEXT_TYPE;

        } else if (mLists.get(position).getType() == IMAGE_TEXT_TYPE) {
            LogUtils.e("getItemViewType  IMAGE_TEXT_TYPE    " + position);
            return IMAGE_TEXT_TYPE;
        } else if (mLists.get(position).getType() == VIDEO_TEXT_TYPE) {
            LogUtils.e("getItemViewType  VIDEO_TEXT_TYPE    " + position);
            return VIDEO_TEXT_TYPE;
        }
        return NULL_TYPE;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (mLists.get(position).getType()) {

            case TEXT_TYPE:
                LogUtils.e("纯文本：  \n" + mLists.get(position).toString());
                /**
                 *    只有文本
                 *
                 *    只实现了  点赞的次数显示    评论的次数显示
                 *    时间的话 还没有 转换
                 *    用户名
                 *    圆形头像加载
                 */

                bean_text = mLists.get(position);



                holder.itemView.setTag(bean_text);

                LogUtils.e("纯文本：  setTag  \n" + bean_text.toString());

                final MyTextViewHolder text_holder = (MyTextViewHolder) holder;
                //点赞次数
                text_holder.commentDongtaiPic.setText(bean_text.getModel_comment());

                //头像
                Glide.with(context).load(bean_text.getModel_Icon()).transform(new GlideCircleTransform(context)).into(text_holder.mIcon);
                //用户名
                text_holder.mName.setText(bean_text.getModel_Name());
                //时间
                text_holder.mTime.setText(bean_text.getModel_Time());
                //文本
                text_holder.etvDongtaiPic.setText(bean_text.getModel_TextString());
                //点赞
                text_holder.mLikes_text.setText(bean_text.getModel_like());
                //评论
                text_holder.commentDongtaiPic.setText(bean_text.getModel_comment());

                break;

            case IMAGE_TEXT_TYPE:
                LogUtils.e("图文 ： \n" + mLists.get(position).toString());
                /**
                 * 图文
                 */
                bean_iamge_text = mLists.get(position);

                holder.itemView.setTag(bean_iamge_text);

                LogUtils.e("图文：  setTag  \n" + bean_iamge_text.toString());

                final MyTextImageViewHolder textIamge_holder = (MyTextImageViewHolder) holder;
                //点赞次数
                textIamge_holder.commentDongtaiPic.setText(bean_iamge_text.getModel_comment());

                //头像
                Glide.with(context).load(bean_iamge_text.getModel_Icon()).transform(new GlideCircleTransform(context)).into(textIamge_holder.mIcon);
                //用户名
                textIamge_holder.mName.setText(bean_iamge_text.getModel_Name());
                //时间
                textIamge_holder.mTime.setText(bean_iamge_text.getModel_Time());
                //文本
                textIamge_holder.etvDongtaiPic.setText(bean_iamge_text.getModel_TextString());
                //九宫格
                List<NineGridPicShowModel> image_List = bean_iamge_text.getModel_ImageString();

                for (NineGridPicShowModel i : image_List) {
                    textIamge_holder.ninePicDongtaiPic.setIsShowAll(i.isShowAll);
                    textIamge_holder.ninePicDongtaiPic.setUrlList(i.urlList);
                }

                //打赏

                //点赞
                textIamge_holder.mLikes_text.setText(bean_iamge_text.getModel_like());
                //评论
                textIamge_holder.commentDongtaiPic.setText(bean_iamge_text.getModel_comment());
                break;


            case VIDEO_TEXT_TYPE:
                /**
                 * 图 片
                 */
                break;

            default:
                break;


        }


    }


    @Override
    public int getItemCount() {
        return mLists.size();
    }

    private class MyTextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RadioButton commentDongtaiPic;
        private ImageView mIcon, mShare, mLikes_image;
        private com.lcodecore.extextview.ExpandTextView etvDongtaiPic;
        private TextView mName, mTime, mLikes_text;
        private Button mGunazhu;
        private CardView mCardView;

        public MyTextViewHolder(View itemView) {

            super(itemView);

            bean_text= (Model_Find_Bean) itemView.getTag();

//            LogUtils.e("纯文字 "+ bean.toString());

            etvDongtaiPic = itemView.findViewById(R.id.etv_dongtai_pic);
            mIcon = itemView.findViewById(R.id.icon_item_image);
            mName = itemView.findViewById(R.id.name_item_text);
            mTime = itemView.findViewById(R.id.time_item_text);
            mShare = itemView.findViewById(R.id.share_item_text);
            mGunazhu = itemView.findViewById(R.id.guanzhu_item_btn);
            commentDongtaiPic = itemView.findViewById(R.id.comment_item_radiobtn);
            mLikes_image = itemView.findViewById(R.id.likes_item_image);
            mLikes_text = itemView.findViewById(R.id.liskes_item_text);
            mCardView=itemView.findViewById(R.id.cardView);

            mIcon.setOnClickListener(this);
            mLikes_image.setOnClickListener(this);
            mCardView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //头像
                case R.id.icon_item_image:
                    context.startActivity(new Intent(context, ModelInfoActivity.class));
                    //图片点赞
                case R.id.likes_item_image:

                    AnimationUtils.scaleAnimator(mLikes_image);
                    break;

                case R.id.cardView:

                    LogUtils.e("测试测试  "+bean_text.toString());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("details", bean_text);
                    intent.putExtras(bundle);
                    intent.setClass(context, DetailsActivity.class);
                    context.startActivity(intent);

                    break;
            }
        }
    }

    private class MyTextImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private NineGridPicView ninePicDongtaiPic;
        private RadioButton commentDongtaiPic;
        private ImageView dashangDongtaiPic, mIcon, mShare, mLikes_image;
        private com.lcodecore.extextview.ExpandTextView etvDongtaiPic;
        private TextView mName, mTime, mLikes_text;
        private Button mGunazhu;
        private CardView mCardView;


        public MyTextImageViewHolder(View itemView) {

            super(itemView);

            bean_iamge_text = (Model_Find_Bean) itemView.getTag();


            ninePicDongtaiPic = itemView.findViewById(R.id.ninePic_dongtai_pic);
            dashangDongtaiPic = itemView.findViewById(R.id.dashang_dongtai_pic);
            etvDongtaiPic = itemView.findViewById(R.id.etv_dongtai_pic);
            mCardView = itemView.findViewById(R.id.cardView);

            mIcon = itemView.findViewById(R.id.icon_item_image);
            mName = itemView.findViewById(R.id.name_item_text);
            mTime = itemView.findViewById(R.id.time_item_text);
            mShare = itemView.findViewById(R.id.share_item_text);
            mGunazhu = itemView.findViewById(R.id.guanzhu_item_btn);
            commentDongtaiPic = itemView.findViewById(R.id.comment_item_radiobtn);
            mLikes_image = itemView.findViewById(R.id.likes_item_image);
            mLikes_text = itemView.findViewById(R.id.liskes_item_text);

            dashangDongtaiPic.setOnClickListener(this);
            mIcon.setOnClickListener(this);
            mLikes_image.setOnClickListener(this);
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                //打赏
                case R.id.dashang_dongtai_pic:
                    LogUtils.e("图文 item  点击了打赏" + bean_iamge_text.getModel_Name() + "的收钱号" + bean_iamge_text.getModel_PayID());
                    break;
                case R.id.icon_item_image:
                    context.startActivity(new Intent(context, ModelInfoActivity.class));
                    break;
                //图片点赞
                case R.id.likes_item_image:
                    AnimationUtils.scaleAnimator(mLikes_image);
                    break;
                //点击图片跳转
                case R.id.cardView:
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("details", bean_iamge_text);
                    intent.putExtras(bundle);
                    intent.setClass(context, DetailsActivity.class);
                    context.startActivity(intent);

                    LogUtils.e( "putExtras" + bean_iamge_text.toString());

                    break;
            }
        }
    }
}
