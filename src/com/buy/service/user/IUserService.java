package com.buy.service.user;

import com.buy.entity.EasyBuy_user;

import java.sql.SQLException;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/25
 * @Explain:
 */
public interface IUserService {
    EasyBuy_user getUserByName(String loginName) throws SQLException;
}
