package com.buy.service.news;

import com.buy.dao.news.INewDao;
import com.buy.dao.news.NewsDaoImpl;
import com.buy.entity.EasyBuy_news;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/27
 * @Explain:
 */
public class NewsDaoImplService implements INewDaoService {
    INewDao newDao=new NewsDaoImpl();
    @Override
    public List<EasyBuy_news> getAllNewsList() {
        return this.newDao.getAllNewsList();
    }
}
