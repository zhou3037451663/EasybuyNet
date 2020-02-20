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
        IProductCategoryService service = new ProductCategoryServiceImpl();
        List<EasyBuy_product_category> list = service.queryAllProductCategory("0");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(0).getName());
            System.out.println(list.get(1).getName());
            System.out.println(list.get(2).getName());
            System.out.println(list.get(3).getName());
            System.out.println(list.get(4).getName());
            System.out.println(list.get(5).getName());
            break;
        }
    }
}
