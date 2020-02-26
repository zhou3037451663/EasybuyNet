package com.buy.dao.product;

import com.buy.dao.product.AddUser;
import com.buy.entity.EasyBuy_user;
import com.buy.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/24
 * @Explain:
 */
public class AddUserImpl implements AddUser {
    @Override
    public int saveUser(EasyBuy_user user) {
        String sql="INSERT INTO`easybuy_user`(`loginName`,`userName`,`password`,`sex`,`email`,`mobile`) VALUES(?,?,?,?,?,?)";
        Object[] param={user.getLoginName(),user.getLoginName(),user.getPassword(),user.getSex(),user.getEmail(),user.getMobile()};
        return DataSourceUtil.execaUpdate(sql,param);
    }

    @Override
    public List<EasyBuy_user> find() {
        List<EasyBuy_user> findName=new ArrayList<EasyBuy_user>();
        EasyBuy_user user=null;
        try {
            Connection conn=DataSourceUtil.getConn();
            String sql="SELECT loginName FROM easybuy_user";
            PreparedStatement pstm=conn.prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {
                user=new EasyBuy_user();
               user.setLoginName(rs.getString(1));
               findName.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findName;
    }


}
