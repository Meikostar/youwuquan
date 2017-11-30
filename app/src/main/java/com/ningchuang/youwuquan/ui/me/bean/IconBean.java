package com.ningchuang.youwuquan.ui.me.bean;

/**
 * Created by wuLiang  on 17-11-16.
 */

public class IconBean {
    private Integer icon;
    private String text;

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public IconBean(Integer icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    @Override
    public String toString() {
        return "IconBean{" +
                "icon=" + icon +
                ", text='" + text + '\'' +
                '}';
    }
}
