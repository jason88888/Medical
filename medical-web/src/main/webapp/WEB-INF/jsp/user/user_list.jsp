<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="pagerForm" method="post" action="user/list">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}" />
    <input type="hidden" name="currentPage" value="1" />
    <input type="hidden" name="numPerPage" value="${model.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="user/list" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        用户编号：<input type="text" name="code" value="${param.code}"/>
                    </td>
                    <td>
                        用户名：<input type="text" class="username" value="${param.username}"/>
                    </td>
                    <td>
                        <select class="combox" name="role">
                            <option value="">所有角色</option>
                            <option value="1">管理员</option>
                            <option value="2">业务员</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="user/insert" target="dialog"><span>添加</span></a></li>
            <li><a class="delete" href="user/delete" target="selectedTodo" rel="ids" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="user/edit?id={id}" target="dialog" warn="请选择一个用户"><span>修改</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th style="width: 18px; cursor: col-resize;"><div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div></th>
            <th width="120">用户编号</th>
            <th>用户名</th>
            <th width="100">密码</th>
            <th width="150">角色</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="user">
            <tr target="id" rel="${user.id}">
                <td><div><input name="ids" value="${user.id}" type="checkbox"></div></td>
                <td>${user.code}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20" <c:if test="${page.numPerPage == 20}">selected</c:if>>20</option>
                <option value="50" <c:if test="${page.numPerPage == 50}">selected</c:if>>50</option>
                <option value="100" <c:if test="${page.numPerPage == 100}">selected</c:if>>100</option>
                <option value="200" <c:if test="${page.numPerPage == 200}">selected</c:if>>200</option>
            </select>
            <span>条，共${page.totalCount}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="${page.numPerPage}" currentPage="${page.currentPage}"></div>

    </div>
</div>
