package com.buy.web;

import com.buy.entity.EasyBuy_product_category;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/20
 * @Explain:
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends AbstractServlet {

//    //从service获取数据
//        IProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
//    List<EasyBuy_product_category> categoryList = productCategoryService.queryAllProductCategory("0");
//    //存储数据
//        request.setAttribute("categoryList",categoryList);
//    //携带数据跳转home.jsp
//        request.getRequestDispatcher("/front/home.jsp").forward(request,response);


//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
IProductCategoryService productCategoryService;
    public void init()throws ServletException{
        //从server层获取数据
        productCategoryService=new ProductCategoryServiceImpl();
    }
    public String index(HttpServletRequest request,HttpServletResponse response){
        //从service获取数据
        List<EasyBuy_product_category> categoryList = productCategoryService.queryAllProductCategory("0");
        //存储数据
         request.setAttribute("categoryList",categoryList);
         //页面跳转
        return  "/front/home";
    }

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
}
