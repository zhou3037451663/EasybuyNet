package com.buy.test;

import com.aliyuncs.exceptions.ClientException;
import com.buy.dao.product.AddUser;
import com.buy.dao.product.AddUserImpl;
import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.EasyBuy_user;
import com.buy.utils.SecurityUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/24
 * @Explain:
 */
public class AddTest {
    @Test
    public static void main(String[] args) throws ClientException, InterruptedException {
//        Scanner input=new Scanner(System.in);
//        System.out.println("请输入手机号:");
//        String sms=input.next();
//        boolean flag=SVerification.verification(sms);
//        if (flag=true){
//            System.out.println("验证成功");
//        }else{
//            System.out.println("验证失败");
//        }
//        AddUser addUser=new AddUserImpl();
//        List<EasyBuy_user> list=addUser.find();
//        for (int i = 0; i <list.size() ; i++) {
//            EasyBuy_user user=list.get(i);
//            System.out.println(user.getLoginName());
//        }
        IUser iw=new EasybuyUserImpl();
        try {
            EasyBuy_user user=iw.getUserByLoginName("admin");
            System.out.println(user.getPassword().equals(SecurityUtils.md5Hex("123456")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
