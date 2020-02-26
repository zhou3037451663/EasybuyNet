package com.buy.dao.product;

import com.buy.entity.EasyBuy_user;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/24
 * @Explain:
 */
public interface AddUser {
    //注册用户
    int saveUser(EasyBuy_user user);
    //查找用户登录名
   List<EasyBuy_user> find();
}
