<%@ page import="com.buy.utils.SVerification" %><%--
  Created by IntelliJ IDEA.
  User: 30374
  Date: 2020/2/24
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" href="${ctx}/front/css/style.css"/>
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->

    <script type="text/javascript" src="${ctx}/front/js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/jquery.bxslider_e88acd1b.js"></script>

    <script type="text/javascript" src="${ctx}/front/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/menu.js"></script>

    <script type="text/javascript" src="${ctx}/front/js/select.js"></script>

    <script type="text/javascript" src="${ctx}/front/js/lrscroll.js"></script>

    <script type="text/javascript" src="${ctx}/front/js/iban.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/fban.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/f_ban.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/mban.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/bban.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/hban.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/tban.js"></script>

    <script type="text/javascript" src="${ctx}/front/js/lrscroll_1.js"></script>


    <title>注册页面</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <span class="fr">
        	<span class="fl">你好，请<a href="${ctx}/front/Login.jsp">登录</a>&nbsp; <a href="${ctx}/front/Regist.jsp"
                                                                      style="color:#ff4e00;">免费注册</a>&nbsp; </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="${ctx}/front/images/s_tel.png" align="absmiddle"/></a></span>
        </span>
    </div>
</div>
<!--End Header End-->
<!--Begin Login Begin-->
<div class="log_bg">
    <div class="top">
        <div class="logo"><a href="${ctx}/front/home.jsp"><img src="${ctx}/front/images/logo.png"/></a></div>
    </div>
    <div class="regist">
        <div class="log_img"><img src="${ctx}/front/images/l_img.png" width="611" height="425"/></div>
        <div class="reg_c">
            <form>
                <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="95">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">注册</span>
                            <span class="fr">已有商城账号，<a href="${ctx}/front/Login.jsp" style="color:#ff4e00;">我要登录</a></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                        <td><input type="text" value="" class="l_user"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                        <td><input type="password" value="" class="l_pwd"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                        <td><input type="password" value="" class="l_pwd" id="l_pwd"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                        <td><input type="text" value="" class="l_email"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                        <td><input type="text" value="" class="l_tel"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right">邀请人会员名 &nbsp;</td>
                        <td><input type="text" value="" class="l_mem"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right">邀请人ID号 &nbsp;</td>
                        <td><input type="text" value="" class="l_num"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;验证码 &nbsp;</td>
                        <td>
                            <input type="text" value="" class="l_ipt"/>
                            <a href=#"><img src="image.jsp" id="img" style="position: relative; top: 10px;"></a>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox"/></label><label class="r_txt">我已阅读并接受《用户协议》</label>
                    </span>
                        </td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="submit" value="立即注册" class="log_btn1"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<!--End Login End-->
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical
        Support: Dgg Group <br/>
        <img src="${ctx}/front/images/b_1.gif" width="98" height="33"/><img src="${ctx}/front/images/b_2.gif" width="98"
                                                                            height="33"/><img
            src="${ctx}/front/images/b_3.gif" width="98" height="33"/><img src="${ctx}/front/images/b_4.gif" width="98"
                                                                           height="33"/><img
            src="${ctx}/front/images/b_5.gif" width="98" height="33"/><img src="${ctx}/front/images/b_6.gif" width="98"
                                                                           height="33"/>
    </div>
</div>
<!--End Footer End -->

</body>
<!--[if IE 6]>
<![endif]-->
</html>

