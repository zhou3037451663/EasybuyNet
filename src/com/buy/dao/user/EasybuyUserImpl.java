package com.buy.dao.user;

import com.buy.entity.EasyBuy_user;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.EmptyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/25
 * @Explain:
 */
public class EasybuyUserImpl extends DataSourceUtil implements IUser {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;


    public EasyBuy_user TableClass(ResultSet rs) throws SQLException {
        EasyBuy_user  user = new EasyBuy_user();
        user.setId(rs.getInt("id"));
        user.setLoginName(rs.getString("loginName"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setIdentityCode(rs.getString("identityCode"));
        user.setEmail(rs.getString("email"));
        user.setMobile(rs.getString("mobile"));
        user.setType(rs.getInt("type"));
        return user;
    }

    @Override
    public EasyBuy_user getUserByLoginName(String loginName) throws SQLException {
        EasyBuy_user user = null;
        //编写sql语句
        StringBuffer sql = new StringBuffer("select * from easybuy_user where 1=1");
        //判断用户名是否为空
        if (!EmptyUtils.isEmpty(loginName)) {
            sql.append(" and loginName=?");
        }
        //执行sql

        conn = getConn();
        pstm = conn.prepareStatement(sql.toString());
        pstm.setObject(1,loginName);
        rs = pstm.executeQuery();
        while (rs.next()) {
            user = TableClass(rs);
        }
        return user;
    }

    @Override
    public int save(EasyBuy_user user) {
        StringBuffer sql = new StringBuffer("INSERT into easybuy_user");
        sql.append("(loginName,userName,password,sex,identityCode,email,mobile,type)");
        sql.append(" values(?,?,?,?,?,?,?,?)");
        Object[] param={user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile(),0};
        return this.executeInsert(sql.toString(),param);
    }
}
