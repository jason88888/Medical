<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="pagerForm" method="post" action="purchase/list">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}" />
    <input type="hidden" name="currentPage" value="1" />
    <input type="hidden" name="numPerPage" value="${model.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="purchase/list" method="post">
        <div class="searchBar">
            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
                    <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <%--<li><a class="add" href="purchase/insert" target="dialog"><span>添加</span></a></li>--%>
            <%--<li><a class="delete" href="purchase/delete" target="selectedTodo" title="确定要删除吗?"><span>删除</span></a></li>--%>
            <%--<li><a class="edit" href="purchase/view?id={id}" target="dialog" warn="请选择要查看的数据"><span>详情</span></a></li>--%>
            <li><a class="icon" href="purchase/upload" target="dialog"><span>导入EXCEL</span></a></li>
        </ul>
    </div>
    <%--<table class="table" width="100%" layoutH="138">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th style="width: 18px; cursor: col-resize;"><div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div></th>--%>
            <%--<th>采购销售类别</th>--%>
            <%--<th>采购付款日期</th>--%>
            <%--<th>采购入库日期</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<c:forEach items="${page.list}" var="purchasement">--%>
            <%--<tr target="id" rel="${purchasement.id}">--%>
                <%--<td><div><input name="ids" value="${purchasement.id}" type="checkbox"></div></td>--%>
                <%--<td>${purchasement.purchaseSaleType}</td>--%>
                <%--<td>${purchasement.purchasePayDate}</td>--%>
                <%--<td>${purchasement.purchaseStoreDate}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--</tbody>--%>
    <%--</table>--%>
    <%--<div class="panelBar">--%>
        <%--<div class="pages">--%>
            <%--<span>显示</span>--%>
            <%--<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">--%>
                <%--<option value="20" <c:if test="${page.numPerPage == 20}">selected</c:if>>20</option>--%>
                <%--<option value="50" <c:if test="${page.numPerPage == 50}">selected</c:if>>50</option>--%>
                <%--<option value="100" <c:if test="${page.numPerPage == 100}">selected</c:if>>100</option>--%>
                <%--<option value="200" <c:if test="${page.numPerPage == 200}">selected</c:if>>200</option>--%>
            <%--</select>--%>
            <%--<span>条，共${page.totalCount}条</span>--%>
        <%--</div>--%>

        <%--<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="${page.numPerPage}" currentPage="${page.currentPage}"></div>--%>
    <%--</div>--%>
</div>
