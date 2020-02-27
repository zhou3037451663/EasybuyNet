package com.buy.dao.news;

import com.buy.entity.EasyBuy_news;
import com.buy.utils.DataSourceUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/27
 * @Explain:
 */
public class NewsDaoImpl extends DataSourceUtil implements INewDao {
    ResultSet rs;
    public EasyBuy_news tiTableClass(ResultSet rs)throws SQLException{
        EasyBuy_news news=new EasyBuy_news();
        news.setId(rs.getInt("id"));
        news.setTitle(rs.getString("title"));
        news.setContent(rs.getString("content"));
        news.setCreateTime(rs.getString("createTime"));
        return news;
    }
    @Override
    public List<EasyBuy_news> getAllNewsList() {
        List<EasyBuy_news> newsList=new ArrayList<EasyBuy_news>();
        EasyBuy_news news=null;
        try {
            StringBuffer sql=new StringBuffer("SELECT * FROM easybuy_news");
            sql.append(" limit 0,5");
            rs=this.executeQuery(sql.toString());
            while (rs.next()){
                news=tiTableClass(rs);
                newsList.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return newsList;
    }
}
