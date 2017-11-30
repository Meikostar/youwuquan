package com.ningchuang.youwuquan.ui.home.bean;

/**
 * Created by Administrator on 2017/11/7.
 */

public class ActorBean {


    /**
     * data : {"registerState":"already exist","token":null}
     * success : true
     */

    private DataBean data;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * registerState : already exist
         * token : null
         */

        private String registerState;
        private Object token;

        public String getRegisterState() {
            return registerState;
        }

        public void setRegisterState(String registerState) {
            this.registerState = registerState;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }
    }
}
