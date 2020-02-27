package com.buy.dao.news;

import com.buy.entity.EasyBuy_news;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/27
 * @Explain:
 */
public interface INewDao {
    public List<EasyBuy_news> getAllNewsList();
}
