package com.buy.web;

import com.buy.entity.EasyBuy_user;
import com.buy.service.user.IUserService;
import com.buy.service.user.UserServiceImpl;
import com.buy.utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @Author: Mr.Zhou
 * @Date 2020/2/26
 * @Explain:
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/Register")
public class RegisterServlet extends AbstractServlet {
    IUserService userService = null;

    @Override
    public Class getServletClass() {
        return RegisterServlet.class;
    }

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    public String toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/front/register";
    }

    public ReturnResult doRegister(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ReturnResult result = new ReturnResult();
        String login = request.getParameter("loginName");
        //检验loginName的唯一性
        EasyBuy_user oldUser = userService.getUserByName(login);
        if (EmptyUtils.isEmpty(oldUser)) {
            result.returnFail("用户已存在!");
            return result;
        }
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String pwd1 = request.getParameter("rePwd");
        String email = request.getParameter("email");
        String mobile = request.getParameter("phone");
        int sex = Integer.parseInt(request.getParameter("sex"));
        String identityCode = request.getParameter("identityCode");
        //验证码
        String verify = request.getParameter("verify");
        String ver = (String) request.getSession().getAttribute("CKECKCODE");
        //封装用户信息
        EasyBuy_user user = new EasyBuy_user();
        user.setPassword(SecurityUtils.md5Hex(pwd));
        user.setEmail(email);
        user.setMobile(mobile);
        user.setIdentityCode(identityCode);
        user.setSex(EmptyUtils.isEmpty(sex) ? 0 : 1);
        user.setLoginName(login);
        user.setUserName(userName);
        user.setType(Constants.UserType.PRE);

        //信息校验
        result = checkUser(user);
        if (result.getStatus() == Constants.ReturnResult.SUCCESS) {
            //注册用户
            boolean flag=userService.save(user);
            if (!flag){
                return  result.returnFail("注册失败!");
            }else{
                return result.returnSuccess("注册成功!");
            }
        }else{
            return result;
        }


    }

    public ReturnResult checkUser(EasyBuy_user user) {
        ReturnResult result = new ReturnResult();
        //正则表达式校验
        if (EmptyUtils.isNotEmpty(user.getMobile())) {
            if (!RegUtils.checkMobile(user.getIdentityCode())) {
                result.returnFail("身份证格式不正确!");
            }
        }
        if (EmptyUtils.isNotEmpty(user.getEmail())) {
            if (RegUtils.checkMobile(user.getEmail())) {
                result.returnFail("邮箱格式不正确!");
            }
        }
        return result.returnSuccess();
    }
}
