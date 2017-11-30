package com.ningchuang.youwuquan.ui.me.bean;

/**
 * Created by ${diego} on 2017/11/21.
 */

public class CardSelectBean {
    private int tu;
    private String nub;

    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public String getNub() {
        return nub;
    }

    public void setNub(String nub) {
        this.nub = nub;
    }

    public CardSelectBean(int tu, String nub) {
        this.tu = tu;
        this.nub = nub;
    }
}
