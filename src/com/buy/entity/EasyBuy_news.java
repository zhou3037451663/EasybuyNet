package com.buy.entity;

import java.io.Serializable;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/18
 * @Explain:
 */
public class EasyBuy_news implements Serializable {
    private int id;
    private String title;
    private String content;
    private String createTime;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
