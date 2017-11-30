package com.ningchuang.youwuquan.ui.me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ningchuang.youwuquan.R;
import com.zqd.common.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MeMoneyActivity extends BaseActivity {
    @Bind(R.id.money_me_back)
    ImageView moneyMeBack;
    @Bind(R.id.money_me_record)
    TextView moneyMeRecord;
    @Bind(R.id.money_me_sum)
    TextView moneyMeSum;
    @Bind(R.id.money_me_withdraw_over)
    TextView moneyMeWithdrawOver;
    @Bind(R.id.money_me_withdraw_hava)
    TextView moneyMeWithdrawHava;
    @Bind(R.id.moeny_me_masonry)
    Button moenyMeMasonry;
    @Bind(R.id.money_me_masonry_my)
    TextView moneyMeMasonryMy;
    @Bind(R.id.moeny_me_gold)
    Button moenyMeGold;
    @Bind(R.id.money_me_gold_my)
    TextView moneyMeGoldMy;
    @Bind(R.id.money_me_withdraw)
    Button moneyMeWithdraw;

    @Override
    public int getLayoutId() {
        return R.layout.activity_me_money;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.money_me_back, R.id.money_me_record, R.id.money_me_sum
            , R.id.money_me_withdraw_over, R.id.money_me_withdraw_hava
            , R.id.moeny_me_masonry, R.id.money_me_masonry_my
            , R.id.moeny_me_gold, R.id.money_me_gold_my, R.id.money_me_withdraw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.money_me_back:
                break;
            case R.id.money_me_record:
                startActivity(RecodeActivity.class);
                break;
            case R.id.money_me_sum:
                break;
            case R.id.money_me_withdraw_over:
                break;
            case R.id.money_me_withdraw_hava:
                break;
            case R.id.moeny_me_masonry:
                break;
            case R.id.money_me_masonry_my:
                break;
            case R.id.moeny_me_gold:
                break;
            case R.id.money_me_gold_my:
                break;
            case R.id.money_me_withdraw:
                break;
        }
    }
}
