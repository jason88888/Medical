<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="pagerForm" method="post" action="warehouse/list">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}"/>
    <input type="hidden" name="currentPage" value="1"/>
    <input type="hidden" name="numPerPage" value="${model.numPerPage}"/>
    <input type="hidden" name="orderField" value="${param.orderField}"/>
</form>


<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="warehouse/list" method="post">
        <div class="searchBar">
            <div class="subBar">
                <ul>
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">检索</button>
                            </div>
                        </div>
                    </li>
                    <li><a class="button" href="demo_page6.html" target="dialog" mask="true"
                           title="查询框"><span>高级检索</span></a></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="warehouse/insert<c:if test="${!(empty warehouseLevel)}">?warehouseLevel=${warehouseLevel}</c:if>" target="dialog" width="820" height="400"><span>添加</span></a></li>
            <li><a class="delete" href="warehouse/delete<c:if test="${!(empty warehouseLevel)}">?warehouseLevel=${warehouseLevel}</c:if>" target="selectedTodo"
                   title="不建议删除基础数据！！确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="warehouse/view?id={id}<c:if test="${!(empty warehouseLevel)}">&warehouseLevel=${warehouseLevel}</c:if>"  target="dialog" warn="请选择一个仓库" width="820"
                   height="400"><span>详情</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th style="width: 18px; cursor: col-resize;">
                <div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div>
            </th>
            <th width="120">仓库编号</th>
            <th width="200">仓库名称</th>
            <th width="100">联系人员</th>
            <th width="250">联系电话</th>
            <th width="250">仓库地址</th>
            <th width="250">仓库级别</th>
            <th width="250">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="warehouse">
            <tr target="id" rel="${warehouse.id}">
                <td>
                    <div><input name="ids" value="${warehouse.id}" type="checkbox"></div>
                </td>
                <td>${warehouse.code}</td>
                <td>${warehouse.name}</td>
                <td>${warehouse.linkMan}</td>
                <td>${warehouse.telephone}</td>
                <td>${warehouse.address}</td>
                <td>${warehouse.warehouseLevel}</td>
                <td>${warehouse.descript}</td>
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

        <div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}"
             pageNumShown="${page.numPerPage}" currentPage="${page.currentPage}"></div>
    </div>
</div>
