package com.buy.dao.product;

import com.buy.dao.product.IProductCategory;
import com.buy.entity.EasyBuy_product_category;
import com.buy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/19
 * @Explain:
 */
public class ProductCategoryImpl implements IProductCategory {
    @Override
    public List<EasyBuy_product_category> queryAllProductCategory(String parentId) {
        List<EasyBuy_product_category> productCategories = new ArrayList<EasyBuy_product_category>();
        EasyBuy_product_category productCategory = null;

        try {
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM easybuy_product_category WHERE 1=1");
            //判断parentID的值，如果为0，显示是一级分类
            if ((!"".equals(parentId)) && null != parentId) {
                sql.append(" and parentId=?");
            }
            //获取连接
            Connection conn = DataSourceUtil.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            if (!"".equals(parentId) && null != parentId) {
                pstmt.setObject(1, parentId);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //实例化对象
                productCategory = new EasyBuy_product_category();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentId(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconClass(rs.getString(5));
                productCategories.add(productCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productCategories;
    }
}
