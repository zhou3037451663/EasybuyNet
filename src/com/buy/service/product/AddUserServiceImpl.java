package com.buy.service.product;

import com.buy.dao.product.AddUser;
import com.buy.dao.product.AddUserImpl;
import com.buy.entity.EasyBuy_user;
import com.buy.service.product.AddUserService;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/24
 * @Explain:
 */
public class AddUserServiceImpl implements AddUserService {
    AddUser user=new AddUserImpl();
    @Override
    public int saveUser(EasyBuy_user user) {
        return this.user.saveUser(user);
    }

    @Override
    public List<EasyBuy_user> find() {
        return this.user.find();
    }
}
