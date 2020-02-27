package com.buy.test;

import com.buy.dao.news.INewDao;
import com.buy.dao.news.NewsDaoImpl;
import com.buy.entity.EasyBuy_news;
import com.buy.service.news.INewDaoService;
import com.buy.service.news.NewsDaoImplService;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/27
 * @Explain:
 */
public class TestNews {
    public static void main(String[] args) {
        INewDaoService newDaoService=new NewsDaoImplService();
        List<EasyBuy_news> list=newDaoService.getAllNewsList();
        for (EasyBuy_news news : list) {
            System.out.println(news.getTitle());
        }
    }
}
