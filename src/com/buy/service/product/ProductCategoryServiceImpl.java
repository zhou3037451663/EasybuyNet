package com.buy.service.product;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.EasyBuy_product_category;
import com.buy.service.product.IProductCategoryService;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/20
 * @Explain:
 */
public class ProductCategoryServiceImpl implements IProductCategoryService {
    private IProductCategory productCategory=new ProductCategoryImpl();
    @Override
    public List<EasyBuy_product_category> queryAllProductCategory(String parentId) {
        parentId="0";
        return productCategory.queryAllProductCategory(parentId);
    }
}
