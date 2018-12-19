<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%--%>
    <%--pageContext.setAttribute("APP_PATH", request.getContextPath());--%>

<%--//	org.jboss.logging.Logger.getLogger("").debug("======="+request.getContextPath());--%>
<%--%>--%>
<html>
<head>
    <title>后台登录</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
//	org.jboss.logging.Logger.getLogger("").debug("======="+request.getContextPath());
    %>
</head>
<%--<link rel="stylesheet" href="/asset/css/style.css"/>--%>
<script type="text/javascript" src="${APP_PATH}/plugs/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/login.js"></script>
<%--<link href="/static/css/login2.css" rel="stylesheet" type="text/css"/>--%>
  <style>
      span a{
          border: 1px solid red;
          width: 100px;
          height: 20px;
          display: inline-block;
          text-align: center;
      }

  </style>
<body>

<span class="sp_login"><a href="/user/login">登陆</a></span>

<span class=""><a href="/emp/getEmp">员工列表1</a></span>

<span class=""><a href="/user/empList">员工列表2</a></span>
<span class=""><a href="/view/manage/index">后台管理</a></span>
<script>
    $(function () {
        $(".sp_login a").click(function () {
//              alert("======")
         <%--$(this).attr("href","${APP_PATH}/user/login");//这样做可以实现跳转--%>


        });

    })

</script>


<%--<form id="userForm" action="/user/find" method="post">--%>
<%--用户名：<input type="text" name="username"><br>--%>
<%--密码：<input type="password" name="password">--%>
<%--<button type="button" onclick="login()">登录</button>--%>
<%--</form>--%>

<%--<div class="wrap">--%>

<%--<h1>后台登录<sup>2017</sup></h1>--%>
<%--<div class="login" style="margin-top:50px;">--%>

    <%--<div class="header">--%>
        <%--<div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);"--%>
                                           <%--tabindex="7">快速登录</a>--%>
            <%--<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>--%>

            <%--<div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">--%>
        <%--<!--登录-->--%>
        <%--<div class="web_login" id="web_login">--%>
            <%--<div class="login-box">--%>
                <%--<div class="login_form">--%>
                    <%--&lt;%&ndash;    <%=request.getContextPath()%>/userAction/login&ndash;%&gt;--%>
                    <%--<form action="<%=request.getContextPath()%>/user/login" name="userForm"--%>
                          <%--accept-charset="utf-8" id="login_form" class="loginForm"--%>
                          <%--method="post"><input type="hidden" name="did" value="0"/>--%>
                        <%--<input type="hidden" name="to" value="log"/>--%>

                        <%--<div class="uinArea" id="uinArea">--%>
                            <%--<label class="input-tips" for="u">帐号：</label>--%>

                            <%--<div class="inputOuter" id="uArea">--%>

                                <%--<input type="text" id="u" name="username" class="inputstyle" />--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="pwdArea" id="pwdArea">--%>
                            <%--<label class="input-tips" for="p">密码：</label>--%>

                            <%--<div class="inputOuter" id="pArea">--%>

                                <%--<input type="password" id="p" name="password" class="inputstyle"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div style="padding-left:50px;margin-top:20px;">--%>
                            <%--<input type="submit" value="登 录"--%>
                                   <%--style="width:150px;"--%>
                                   <%--class="button_blue" onclick="login()"/></div>--%>
                    <%--</form>--%>
                <%--</div>--%>

            <%--</div>--%>

        <%--</div>--%>
        <%--<!--登录end-->--%>
    <%--</div>--%>

    <%--<!--注册-->--%>
    <%--<div class="qlogin" id="qlogin" style="display: none; ">--%>

        <%--<div class="web_login">--%>
            <%--<form name="form2" id="regUser" accept-charset="utf-8" action="<%=request.getContextPath()%>/userAction/reg"--%>
                  <%--method="post">--%>
                <%--<input type="hidden" name="to" value="reg"/>--%>
                <%--<input type="hidden" name="did" value="0"/>--%>
                <%--<ul class="reg_form" id="reg-ul">--%>
                    <%--<div id="userCue" class="cue">快速注册请注意格式</div>--%>
                    <%--<li>--%>

                        <%--<label for="user" class="input-tips2">用户名：</label>--%>

                        <%--<div class="inputOuter2">--%>
                            <%--<input type="text" id="user" name="loginId" maxlength="16" class="inputstyle2"/>--%>
                        <%--</div>--%>

                    <%--</li>--%>
                    <%--<li>--%>

                        <%--<label for="user" class="input-tips2">姓名：</label>--%>

                        <%--<div class="inputOuter2">--%>
                            <%--<input type="text" id="name" name="name" maxlength="16" class="inputstyle2"/>--%>
                        <%--</div>--%>

                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<label for="passwd" class="input-tips2">密码：</label>--%>

                        <%--<div class="inputOuter2">--%>
                            <%--<input type="password" id="passwd" name="pwd" maxlength="16" class="inputstyle2"/>--%>
                        <%--</div>--%>

                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<label for="passwd2" class="input-tips2">确认密码：</label>--%>

                        <%--<div class="inputOuter2">--%>
                            <%--<input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2"/>--%>
                        <%--</div>--%>

                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<label for="cellNumber" class="input-tips2">手机号：</label>--%>

                        <%--<div class="inputOuter2">--%>

                            <%--<input type="text" id="cellNumber" name="cellNumber" maxlength="18" class="inputstyle2"/>--%>
                        <%--</div>--%>

                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<label for="sex" class="input-tips2">性别：</label>--%>

                        <%--<div class="inputOuter2">--%>

                            <%--<input type="text" id="sex" name="sex" maxlength="18" class="inputstyle2"/>--%>
                        <%--</div>--%>

                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<label for="age" class="input-tips2">年龄：</label>--%>

                        <%--<div class="inputOuter2">--%>

                            <%--<input type="age" id="age" name="age" maxlength="18" class="inputstyle2"/>--%>
                        <%--</div>--%>

                    <%--</li>--%>

                    <%--<li>--%>
                        <%--<div class="inputArea">--%>
                            <%--<input type="button" id="reg" style="margin-top:10px;margin-left:85px;" class="button_blue"--%>
                                   <%--value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>--%>
                        <%--</div>--%>

                    <%--</li>--%>
                    <%--<div class="cl"></div>--%>
                <%--</ul>--%>
            <%--</form>--%>


        <%--</div>--%>


    <%--</div>--%>
    <%--<!--注册end-->--%>
<%--</div>--%>
<%--<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>--%>

<%--</div>--%>




</body>
</html>
