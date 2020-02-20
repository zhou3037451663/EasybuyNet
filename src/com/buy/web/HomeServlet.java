package com.buy.web;

import com.buy.entity.EasyBuy_product_category;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/20
 * @Explain:
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //从service获取数据
        IProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
        List<EasyBuy_product_category> categoryList = productCategoryService.queryAllProductCategory("0");
        //存储数据
        request.setAttribute("categoryList",categoryList);
        //携带数据跳转home.jsp
        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
