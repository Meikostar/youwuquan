package com.ningchuang.youwuquan.ui.me.bean;

import java.util.List;

/**
 * Created by ${diego} on 2017/11/20.
 */

public class UserDataBean {

    /**
     * appBean : {"data":[{"birthday":"1991-03-19","bwh":"xx,xx,xx","constellation":"双鱼座","height":180,"id":1,"labelList":[{"id":1,"labelName":"英俊","labelNo":"1"},{"id":2,"labelName":"潇洒","labelNo":"2"},{"id":3,"labelName":"很大","labelNo":"3"}],"labels":"1,2,3","roleList":[{"id":1,"roleDescr":"演员的职责就是要会演","roleName":"演员","roleNo":"1"}],"roleNos":"1","synopsis":"vbvbvb","userNike":"scary","userNo":"18376772633","weight":62,"weixin":"weixinNo"}],"msg":"success","sign":"666"}
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
         * data : [{"birthday":"1991-03-19","bwh":"xx,xx,xx","constellation":"双鱼座","height":180,"id":1,"labelList":[{"id":1,"labelName":"英俊","labelNo":"1"},{"id":2,"labelName":"潇洒","labelNo":"2"},{"id":3,"labelName":"很大","labelNo":"3"}],"labels":"1,2,3","roleList":[{"id":1,"roleDescr":"演员的职责就是要会演","roleName":"演员","roleNo":"1"}],"roleNos":"1","synopsis":"vbvbvb","userNike":"scary","userNo":"18376772633","weight":62,"weixin":"weixinNo"}]
         * msg : success
         * sign : 666
         */

        private String msg;
        private String sign;
        private List<DataBean> data;

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

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * birthday : 1991-03-19
             * bwh : xx,xx,xx
             * constellation : 双鱼座
             * height : 180
             * id : 1
             * labelList : [{"id":1,"labelName":"英俊","labelNo":"1"},{"id":2,"labelName":"潇洒","labelNo":"2"},{"id":3,"labelName":"很大","labelNo":"3"}]
             * labels : 1,2,3
             * roleList : [{"id":1,"roleDescr":"演员的职责就是要会演","roleName":"演员","roleNo":"1"}]
             * roleNos : 1
             * synopsis : vbvbvb
             * userNike : scary
             * userNo : 18376772633
             * weight : 62
             * weixin : weixinNo
             */

            private String birthday;
            private String bwh;
            private String constellation;
            private int height;
            private int id;
            private String labels;
            private String roleNos;
            private String synopsis;
            private String userNike;
            private String userNo;
            private int weight;
            private String weixin;
            private List<LabelListBean> labelList;
            private List<RoleListBean> roleList;

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getBwh() {
                return bwh;
            }

            public void setBwh(String bwh) {
                this.bwh = bwh;
            }

            public String getConstellation() {
                return constellation;
            }

            public void setConstellation(String constellation) {
                this.constellation = constellation;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLabels() {
                return labels;
            }

            public void setLabels(String labels) {
                this.labels = labels;
            }

            public String getRoleNos() {
                return roleNos;
            }

            public void setRoleNos(String roleNos) {
                this.roleNos = roleNos;
            }

            public String getSynopsis() {
                return synopsis;
            }

            public void setSynopsis(String synopsis) {
                this.synopsis = synopsis;
            }

            public String getUserNike() {
                return userNike;
            }

            public void setUserNike(String userNike) {
                this.userNike = userNike;
            }

            public String getUserNo() {
                return userNo;
            }

            public void setUserNo(String userNo) {
                this.userNo = userNo;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
            }

            public List<LabelListBean> getLabelList() {
                return labelList;
            }

            public void setLabelList(List<LabelListBean> labelList) {
                this.labelList = labelList;
            }

            public List<RoleListBean> getRoleList() {
                return roleList;
            }

            public void setRoleList(List<RoleListBean> roleList) {
                this.roleList = roleList;
            }

            public static class LabelListBean {
                /**
                 * id : 1
                 * labelName : 英俊
                 * labelNo : 1
                 */

                private int id;
                private String labelName;
                private String labelNo;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getLabelName() {
                    return labelName;
                }

                public void setLabelName(String labelName) {
                    this.labelName = labelName;
                }

                public String getLabelNo() {
                    return labelNo;
                }

                public void setLabelNo(String labelNo) {
                    this.labelNo = labelNo;
                }
            }

            public static class RoleListBean {
                /**
                 * id : 1
                 * roleDescr : 演员的职责就是要会演
                 * roleName : 演员
                 * roleNo : 1
                 */

                private int id;
                private String roleDescr;
                private String roleName;
                private String roleNo;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getRoleDescr() {
                    return roleDescr;
                }

                public void setRoleDescr(String roleDescr) {
                    this.roleDescr = roleDescr;
                }

                public String getRoleName() {
                    return roleName;
                }

                public void setRoleName(String roleName) {
                    this.roleName = roleName;
                }

                public String getRoleNo() {
                    return roleNo;
                }

                public void setRoleNo(String roleNo) {
                    this.roleNo = roleNo;
                }
            }
        }
    }
}
