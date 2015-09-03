<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="user/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>用户编号：</label>
                <input name="code" type="text" size="30" value="A000002"/>
            </p>
            <p>
                <label>用户名：</label>
                <input name="username" class="required" type="text" size="30" alt="请输入客户名称"/>
            </p>
            <p>
                <label>密码：</label>
                <input name="password" class="required" type="password" size="30" alt="请输入密码"/>
            </p>
            <p>
                <label>角色：</label>
                <select name="role">
                    <option value="2" selected>业务员</option>
                    <option value="1">管理员</option>
                </select>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
