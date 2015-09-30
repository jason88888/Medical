<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="${basePath}assets/js/lib/dwz-ria/themes/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form id="slick-login" action="${basePath}login" method="post">
    <label for="username">username</label><input type="text" id="username" name="username" class="placeholder" placeholder="账号">
    <label for="password">password</label><input type="password" id="password" name="password" class="placeholder" placeholder="密码">
    <c:if test="${message != null}"><p class="${message.code}" style="margin: 5px 0; color: red;">${message.content}</p></c:if>
    <input type="submit" value="登录">
</form>
</body>
</html>
