package com.ningchuang.youwuquan.ui.find.bean;

/**
 * Created by wuLiang  on 17-11-7.
 */

public class Renzheng_Bean {
    private String renzheng;
    private int icon;
    private boolean succeed;

    public String getRenzheng() {
        return renzheng;
    }

    public void setRenzheng(String renzheng) {
        this.renzheng = renzheng;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public Renzheng_Bean(String renzheng, int icon, boolean succeed) {
        this.renzheng = renzheng;
        this.icon = icon;
        this.succeed = succeed;
    }

    @Override
    public String toString() {
        return "Renzheng_Bean{" +
                "renzheng='" + renzheng + '\'' +
                ", icon=" + icon +
                ", succeed=" + succeed +
                '}';
    }
}
