package com.buy.service.product;

import com.buy.entity.EasyBuy_product_category;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/20
 * @Explain:
 */
public interface IProductCategoryService {
    //查询一级标题
    List<EasyBuy_product_category> queryAllProductCategory(String parentId);
}
