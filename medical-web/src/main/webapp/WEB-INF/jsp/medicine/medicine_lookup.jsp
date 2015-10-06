<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="pagerForm" action="medicine/lookup">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}"/>
    <input type="hidden" name="currentPage" value="1"/>
    <input type="hidden" name="numPerPage" value="${param.numPerPage}" ${param.numPerPage}/>
    <input type="hidden" name="orderField" value="${param.orderField}"/>
</form>

<div class="pageHeader">
    <form target="dialog" rel="pagerForm" method="post" action="medicine/lookup" onsubmit="return dwzSearch(this, 'dialog');">
        <div class="searchBar">
            <ul class="searchContent">
                <li>
                    <label>药品编号:</label>
                    <input class="textInput" name="code" value="${param.code}" type="text">
                </li>
                <li>
                    <label>药品名称:</label>
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
            <th style="width: 18px; cursor: col-resize;">
                <div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div>
            </th>
            <th width="120">药品编码</th>
            <th width="200">药品名称</th>
            <th width="100">药品规格</th>
            <th width="250">生产厂商名称</th>
            <th width="120">单位</th>
            <th width="120">单价</th>
            <th width="120">药品批号</th>
            <th width="150">有效期</th>
            <th width="150">查找带回</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="medicine">
            <tr target="id" rel="${medicine.id}">
                <td>
                    <div><input name="ids" value="${medicine.id}" type="checkbox"></div>
                </td>
                <td>${medicine.code}</td>
                <td>${medicine.name}</td>
                <td>${medicine.specification}</td>
                <td>${medicine.manufacturerName}</td>
                <td>${medicine.units}</td>
                <td>${medicine.price}</td>
                <td>${medicine.lotNumber}</td>
                <td>${medicine.validityPeriod}</td>
                <td>
                    <a class="btnSelect" href="javascript:$.bringBack({id:'${medicine.id}', code:'${medicine.code}', name:'${medicine.name}'})" title="查找带回">选择</a>
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