package com.zqd.common.widget;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zqd.common.R;

/**
 * Created by ${diego} on 2017/11/15.
 */

public class ShowDilog {
    private AlertDialog.Builder builder;
    private Context context;
    private SetOnDilogClick setOnDilogClick;
    private AlertDialog alertDialog;
    private String cancle, sure, title, content;

    public ShowDilog(Context context, SetOnDilogClick setOnDilogClick, String cancle, String sure, String title, String content) {
        this.context = context;
        this.setOnDilogClick = setOnDilogClick;
        this.cancle = cancle;
        this.sure = sure;
        this.title = title;
        this.content = content;
    }

    public void showDilog() {
        builder = new AlertDialog.Builder(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dailog_style, null);
        ((TextView) inflate.findViewById(R.id.dailog_title)).setText(title);
        ((TextView) inflate.findViewById(R.id.dailog_content)).setText(content);
        TextView viewById = (TextView) inflate.findViewById(R.id.shaohou);
        viewById.setText(cancle);
        viewById.setOnClickListener(view -> setOnDilogClick.OnCancleClick());
        TextView viewById1 = ((TextView) inflate.findViewById(R.id.sure));
        viewById1.setText(sure);
        viewById1.setOnClickListener(view -> setOnDilogClick.OnSureClick());
        builder.setView(inflate);
        alertDialog = builder.create();
        alertDialog.show();
    }

    public interface SetOnDilogClick {
        void OnCancleClick();

        void OnSureClick();
    }

    public void cancle() {
        alertDialog.dismiss();
    }
}
