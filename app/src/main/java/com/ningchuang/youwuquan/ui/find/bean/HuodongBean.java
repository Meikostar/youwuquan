package com.ningchuang.youwuquan.ui.find.bean;

/**
 * Created by wuLiang  on 17-10-31.
 */

public class HuodongBean {
    private String imageUrl;
    private String title;
    private String content;
    private String jion;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getJion() {
        return jion;
    }

    public void setJion(String jion) {
        this.jion = jion;
    }

    public HuodongBean(String imageUrl, String title, String content, String jion) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.jion = jion;
    }

    @Override
    public String toString() {
        return "HuodongBean{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", jion='" + jion + '\'' +
                '}';
    }
}
