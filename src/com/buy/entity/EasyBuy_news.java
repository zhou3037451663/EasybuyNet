package com.buy.entity;

import java.io.Serializable;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/18
 * @Explain:
 */
public class EasyBuy_news implements Serializable {
    private int id;
    private String content;
    private String createTime;

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
