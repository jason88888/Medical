<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="pagerForm" action="user/lookup">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}"/>
    <input type="hidden" name="currentPage" value="1"/>
    <input type="hidden" name="numPerPage" value="${param.numPerPage}" ${param.numPerPage}/>
    <input type="hidden" name="orderField" value="${param.orderField}"/>
</form>

<div class="pageHeader">
    <form target="dialog" rel="pagerForm" method="post" action="user/lookup" onsubmit="return dwzSearch(this, 'dialog');">
        <div class="searchBar">
            <ul class="searchContent">
                <li>
                    <label>用户编号:</label>
                    <input class="textInput" name="id" value="${param.id}" type="text">
                </li>
                <li>
                    <label>用户名称:</label>
                    <input class="textInput" name="name" value="${param.name}" type="text">
                </li>
            </ul>
            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">

    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th style="width: 18px; cursor: col-resize;"><div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div></th>
            <th width="120">用户编号</th>
            <th width="120">用户名</th>
            <th width="100">密码</th>
            <th width="150">角色</th>
            <th width="150">备注</th>
            <th width="150">查找带回</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="user">
            <tr target="id" rel="${user.id}">
                <td>
                    <div><input name="ids" value="${user.id}" type="checkbox"></div>
                </td>
                <td>${user.code}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <c:choose>
                    <c:when test="${user.role == 2}">
                        <td>业务员</td>
                    </c:when>
                    <c:when test="${user.role == 1}">
                        <td>管理员</td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
                <td>${user.descript}</td>
                <td>
                    <a class="btnSelect" href="javascript:$.bringBack({id:'${user.id}',code:'${user.code}', username:'${user.username}'})" title="查找带回">选择</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="dialogPageBreak({numPerPage:this.value})">
                <option value="20" <c:if test="${page.numPerPage == 20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${page.numPerPage == 50}">selected</c:if>>50</option>
                <option value="100" <c:if test="${page.numPerPage == 100}">selected</c:if>>100</option>
                <option value="200" <c:if test="${page.numPerPage == 200}">selected</c:if>>200</option>
            </select>
            <span>条，共${page.totalCount}条</span>
        </div>

        <div class="pagination" targetType="dialog" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}"
             pageNumShown="${page.numPerPage}" currentPage="${page.currentPage}"></div>
    </div>
</div>