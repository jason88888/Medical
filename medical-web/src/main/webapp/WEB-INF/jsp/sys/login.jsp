<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="${basePath}assets/js/lib/dwz-ria/themes/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="login">
    <div id="login_header">
        <h1 class="login_logo">
            <a href="http://demo.dwzjs.com"><img src="${basePath}assets/js/lib/dwz-ria/themes/default/images/login_logo.gif" /></a>
        </h1>
        <div class="login_headerContent">
            <div class="navList">
                <ul>
                    <li><a href="#"></a></li>
                    <li><a href="http://bbs.dwzjs.com"></a></li>
                    <li><a href="${basePath}assets/js/lib/dwz-ria/doc/dwz-user-guide.pdf" target="_blank"></a></li>
                </ul>
            </div>
            <h2 class="login_title"><img src="${basePath}assets/js/lib/dwz-ria/themes/default/images/login_title.png" /></h2>
        </div>
    </div>
    <div id="login_content">
        <div class="loginForm">
            <form action="${basePath}login" method="post">
                <p>
                    <label>用户名：</label>
                    <input type="text" name="username" size="20" class="login_input" />
                </p>
                <p>
                    <label>密码：</label>
                    <input type="password" name="password" size="20" class="login_input" />
                </p>
                <%--<p>--%>
                    <%--<label>验证码：</label>--%>
                    <%--<input class="code" type="text" size="5" />--%>
                    <%--<span><img src="${basePath}assets/js/lib/dwz-ria/themes/default/images/header_bg.png" alt="" width="75" height="24" /></span>--%>
                <%--</p>--%>
                <div class="login_bar">
                    <input class="sub" type="submit" value=" " />
                </div>
            </form>
        </div>
        <div class="login_banner"><img src="${basePath}assets/js/lib/dwz-ria/themes/default/images/login_banner.jpg" /></div>
        <div class="login_main">
            <ul class="helpList">

            </ul>
            <div class="login_inner">

            </div>
        </div>
    </div>
    <div id="login_footer">
<%--    版权所有：杭州简学科技--%>
        <%--p;浙ICP备15007838号&nbsp;&nbsp;
   --%>
            Copyright © 2015 taotao-tech团队 Tel：15158121565>
</body>
</html>
