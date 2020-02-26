package com.buy.dao.user;

import com.buy.entity.EasyBuy_user;

import java.sql.SQLException;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/25
 * @Explain:
 */
public interface IUser {
    EasyBuy_user getUserByLoginName(String loginName)throws SQLException;
}
