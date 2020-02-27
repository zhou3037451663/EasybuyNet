package com.buy.service.user;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.EasyBuy_user;

import java.sql.SQLException;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/25
 * @Explain:
 */
public class UserServiceImpl implements IUserService {
    IUser uDao=new EasybuyUserImpl();
    @Override
    public EasyBuy_user getUserByName(String loginName) throws SQLException {
        return this.uDao.getUserByLoginName(loginName);
    }

    @Override
    public boolean save(EasyBuy_user user) {
        return this.uDao.save(user)>0?true:false;
    }
}
