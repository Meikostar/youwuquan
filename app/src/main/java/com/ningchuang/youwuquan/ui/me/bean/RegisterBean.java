package com.ningchuang.youwuquan.ui.me.bean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/17.
 */

public class RegisterBean {

    /**
     * appBean : {"data":["581bd2b4e6d6cf5a446fb570a0acb8da"],"msg":"success","sign":"666"}
     * success : true
     */

    private AppBeanBean appBean;
    private boolean success;

    public AppBeanBean getAppBean() {
        return appBean;
    }

    public void setAppBean(AppBeanBean appBean) {
        this.appBean = appBean;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class AppBeanBean {
        /**
         * data : ["581bd2b4e6d6cf5a446fb570a0acb8da"]
         * msg : success
         * sign : 666
         */

        private String msg;
        private String sign;
        private List<String> data;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }
    }
}
