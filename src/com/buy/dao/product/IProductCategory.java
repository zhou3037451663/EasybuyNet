package com.buy.dao.product;

import com.buy.entity.EasyBuy_product_category;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/19
 * @Explain:
 */
public interface IProductCategory {
    //查询一级标题
    List<EasyBuy_product_category> queryAllProductCategory(String parentId);
}
