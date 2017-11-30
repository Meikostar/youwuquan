package com.ningchuang.youwuquan.ui.find.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.find.bean.Model_Find_Bean;
import com.ningchuang.youwuquan.utils.AnimationUtils;
import com.ningchuang.youwuquan.utils.LogUtils;
import com.ningchuang.youwuquan.view.NinePic.NineGridPicView;
import com.ningchuang.youwuquan.view.NinePic.model.NineGridPicShowModel;

import java.util.List;

/**
 * Created by wuLiang  on 17-11-8.
 */

public class InfoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Model_Find_Bean> mList;

    private int NULL_TYPE = -1;
    private final int TEXT_TYPE = 0;
    private final int IMAGE_TEXT_TYPE = 1;
    private final int VIDEO_TEXT_TYPE = 2;

    private Model_Find_Bean bean;

    public InfoAdapter(Context context, List<Model_Find_Bean> mList) {
        this.context = context;
        this.mList = mList;
    }


    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TEXT_TYPE:

                LogUtils.e(" InfoAdapter  模特个人 动态 纯文本  ");
                return new MyTextViewHolder(LayoutInflater.from(context).inflate(R.layout.item_info_text, null));

            case IMAGE_TEXT_TYPE:
                LogUtils.e(" InfoAdapter 模特个人 动态 文本和图片  ");
//                return new MyTextImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_text_image_find, null));

                return new MyTextImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_info_text_pic, null));

//            case VIDEO_TEXT_TYPE:
//                return null;

        }

        return null;

    }


    @Override
    public int getItemViewType(int position) {

        if (mList.get(position).getType() == TEXT_TYPE) {
            LogUtils.e("InfoAdapter  getItemViewType  TEXT_TYPE    " + position);
            return TEXT_TYPE;

        } else if (mList.get(position).getType() == IMAGE_TEXT_TYPE) {
            LogUtils.e("InfoAdapter  getItemViewType  IMAGE_TEXT_TYPE    " + position);
            return IMAGE_TEXT_TYPE;
        } else if (mList.get(position).getType() == VIDEO_TEXT_TYPE) {
            LogUtils.e("InfoAdapter getItemViewType  VIDEO_TEXT_TYPE    " + position);
            return VIDEO_TEXT_TYPE;
        }
        return NULL_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (mList.get(position).getType()) {

            case TEXT_TYPE:

                /**
                 *    只有文本
                 *
                 *    只实现了  点赞的次数显示    评论的次数显示
                 *    时间的话 还没有 转换
                 *    用户名
                 *    圆形头像加载
                 */

                bean = mList.get(position);

                LogUtils.e("InfoAdapter 模特纯文本：  \n" + bean.toString());


                holder.itemView.setTag(bean);

                final MyTextViewHolder text_holder = (MyTextViewHolder) holder;
                //点赞次数
                text_holder.commentDongtaiPic.setText(bean.getModel_comment());

                //用户名
                //时间
                text_holder.mTime.setText(bean.getModel_Time());
                //文本
                text_holder.etvDongtaiPic.setText(bean.getModel_TextString());
                //点赞
                text_holder.mLikes_text.setText(bean.getModel_like());
                //评论
                text_holder.commentDongtaiPic.setText(bean.getModel_comment());

                break;

            case IMAGE_TEXT_TYPE:
                /**
                 * 图文
                 */
                bean = mList.get(position);

                LogUtils.e("InfoAdapter 模特图文 ： \n" + bean.toString());


                holder.itemView.setTag(bean);

                final MyTextImageViewHolder textIamge_holder = (MyTextImageViewHolder) holder;
                //点赞次数
                textIamge_holder.commentDongtaiPic.setText(bean.getModel_comment());

                //时间
                textIamge_holder.mTime.setText(bean.getModel_Time());
                //文本
                textIamge_holder.etvDongtaiPic.setText(bean.getModel_TextString());
                //九宫格
                List<NineGridPicShowModel> image_List = bean.getModel_ImageString();

                for (NineGridPicShowModel i : image_List) {
                    textIamge_holder.ninePicDongtaiPic.setIsShowAll(i.isShowAll);
                    textIamge_holder.ninePicDongtaiPic.setUrlList(i.urlList);
                }

                //打赏

                //点赞
                textIamge_holder.mLikes_text.setText(bean.getModel_like());
                //评论
                textIamge_holder.commentDongtaiPic.setText(bean.getModel_comment());
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
        LogUtils.e("InfoAdapter  模特个人信息  数目   " + mList.size());
        return mList == null ? 0 : mList.size();
    }

    private class MyTextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RadioButton commentDongtaiPic;
        private ImageView mLikes_image;
        private com.lcodecore.extextview.ExpandTextView etvDongtaiPic;
        private TextView mTime, mLikes_text;


        public MyTextViewHolder(View itemView) {

            super(itemView);

            bean = (Model_Find_Bean) itemView.getTag();

            etvDongtaiPic = itemView.findViewById(R.id.etv_dongtai_pic);
            mTime = itemView.findViewById(R.id.time_item_text);
            commentDongtaiPic = itemView.findViewById(R.id.comment_item_radiobtn);
            mLikes_image = itemView.findViewById(R.id.likes_item_image);
            mLikes_text = itemView.findViewById(R.id.liskes_item_text);


            mLikes_image.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.likes_item_image:
                    AnimationUtils.scaleAnimator(mLikes_image);
                    break;
            }
        }
    }

    private class MyTextImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private NineGridPicView ninePicDongtaiPic;
        private RadioButton commentDongtaiPic;
        private ImageView dashangDongtaiPic, mLikes_image;
        private com.lcodecore.extextview.ExpandTextView etvDongtaiPic;
        private TextView mTime, mLikes_text;

        public MyTextImageViewHolder(View itemView) {

            super(itemView);

            bean = (Model_Find_Bean) itemView.getTag();

            ninePicDongtaiPic = itemView.findViewById(R.id.ninePic_dongtai_pic);
            dashangDongtaiPic = itemView.findViewById(R.id.dashang_dongtai_pic);
            etvDongtaiPic = itemView.findViewById(R.id.etv_dongtai_pic);

            mTime = itemView.findViewById(R.id.time_item_text);
            commentDongtaiPic = itemView.findViewById(R.id.comment_item_radiobtn);
            mLikes_image = itemView.findViewById(R.id.likes_item_image);
            mLikes_text = itemView.findViewById(R.id.liskes_item_text);

            dashangDongtaiPic.setOnClickListener(this);
            mLikes_image.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                //打赏
                case R.id.dashang_dongtai_pic:
                    LogUtils.e("InfoAdapter 图文 item  点击了打赏" + bean.getModel_Name() + "的收钱号" + bean.getModel_PayID());
                    break;
                case R.id.likes_item_image:
                    AnimationUtils.scaleAnimator(mLikes_image);
                    break;
            }
        }


    }
}
