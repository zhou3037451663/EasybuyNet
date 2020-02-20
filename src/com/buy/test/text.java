package com.buy.test;

import com.buy.dao.product.IProductCategory;
import com.buy.dao.product.ProductCategoryImpl;
import com.buy.entity.EasyBuy_product_category;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.product.ProductCategoryServiceImpl;
import com.buy.utils.DataSourceUtil;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/19
 * @Explain:
 */
public class text {
    @Test
    public void testFor() {
        IProductCategoryService service=new ProductCategoryServiceImpl();
        List<EasyBuy_product_category> list=service.queryAllProductCategory("0");
        for (EasyBuy_product_category easybuy:list){
            System.out.print(easybuy.getName()+"\t");
        }
    }
}
