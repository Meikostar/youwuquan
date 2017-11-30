package com.ningchuang.youwuquan.ui.upload.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ningchuang.youwuquan.R;
import com.ningchuang.youwuquan.ui.upload.activity.ReleaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpLoadFragment extends Fragment {


    @Bind(R.id.ll_word)
    LinearLayout llWord;
    @Bind(R.id.ll_photo)
    LinearLayout llPhoto;
    @Bind(R.id.ll_xc)
    LinearLayout llXc;
    @Bind(R.id.ll_video)
    LinearLayout llVideo;
    @Bind(R.id.iv_close)
    ImageView iv_close;
    public UpLoadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_up_load, container, false);
        ButterKnife.bind(this, view);
         llWord.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              startActivity(new Intent(getActivity(),ReleaseActivity.class));
             }
         });
        llPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ReleaseActivity.class));
            }
        });
        llXc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ReleaseActivity.class));
            }
        });
        llVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),ReleaseActivity.class));
            }
        });
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
