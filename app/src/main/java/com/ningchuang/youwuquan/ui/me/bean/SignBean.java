package com.ningchuang.youwuquan.ui.me.bean;

/**
 * Created by ${diego} on 2017/11/20.
 */

public class SignBean {
    private boolean isSelect;
    private String name;

    public SignBean(boolean isSelect, String name) {
        this.isSelect = isSelect;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
