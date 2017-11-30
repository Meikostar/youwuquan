package com.ningchuang.youwuquan.ui.me.bean;

/**
 * Created by wuLiang  on 17-11-14.
 */

public class RecodeBean {
    private String action;
    private String time;
    private String money;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public RecodeBean(String action, String time, String money) {
        this.action = action;
        this.time = time;
        this.money = money;
    }

    @Override
    public String toString() {
        return "RecodeBean{" +
                "action='" + action + '\'' +
                ", time='" + time + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
