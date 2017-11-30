package com.ningchuang.youwuquan.ui.me.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.find.activity.ModelInfoActivity;
import com.ningchuang.youwuquan.ui.home.bean.IMG;
import com.ningchuang.youwuquan.view.ViewPagerFixed;
import com.zqd.common.base.BaseActivity;
import com.zqd.common.base.NavigationBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

public class ImageListWitesActivity extends BaseActivity {


    @Bind(R.id.navigationBar)
    NavigationBar navigationBar;
    @Bind(R.id.image_pager)
    ViewPagerFixed viewPager;
    @Bind(R.id.iv_love)
    ImageView ivLove;
    @Bind(R.id.tv_loves)
    TextView tvLoves;
    @Bind(R.id.iv_messages)
    ImageView ivMessages;
    @Bind(R.id.tv_messages)
    TextView tvMessages;
    @Bind(R.id.backgroundLayout)
    RelativeLayout backgroundLayout;
    private IMG img;
    @Override
    public int getLayoutId() {
        return R.layout.activity_image_list_wites;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        navigationBar.setNavigationBarListener(this);
        img = (IMG) getIntent().getSerializableExtra("img");
        if(img==null){
            img=new IMG();
            IMG img = new IMG();
            img.img_url="http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg";
            this.img.child_list.add(img);
            IMG img1 = new IMG();
            img1.img_url="http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg";
            this.img.child_list.add(img1);
            IMG img2 = new IMG();
            img2.img_url="http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg";
            this.img.child_list.add(img2);
            IMG img3 = new IMG();
            img3.img_url="http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg";
            this.img.child_list.add(img3);
            IMG img4 = new IMG();
            img4.img_url="http://imgtu.5011.net/uploads/content/20170414/6256421492148399.jpg";
            this.img.child_list.add(img4);
        }
     adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        viewPager.setOnPageChangeListener(new ViewPagerFixed.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int new_position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ivMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageListWitesActivity.this, ModelInfoActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
    }
   private ViewPagerAdapter adapter;
    private void initMainView() {


    }

    @Override
    public void navigationimg() {

    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int new_position) {
            View view = LayoutInflater.from(ImageListWitesActivity.this).inflate(
                    R.layout.lp_pager_img_list, null);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.img_content);

//            int screenWidth = Win.getScreenWidth(ImageListWitesActivity.this); // 获取屏幕宽度
//            ViewGroup.LayoutParams lp = photoView.getLayoutParams();
//            lp.width = screenWidth;
//            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//            photoView.setLayoutParams(lp);
//            photoView.setMaxWidth(screenWidth);
//            photoView.setMaxHeight(screenWidth * 5); //这里其实可以根据需求而定，我这里测试为最大宽度的5倍
            Glide.with(ImageListWitesActivity.this).load(img.child_list.get(new_position).img_url).asBitmap()
                    .placeholder(R.mipmap.beijing).into(photoView);

//            photoView.setImageWithURL(ImageListWitesActivity.this, img.child_list.get(new_position).img_url);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return img.child_list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
    }
