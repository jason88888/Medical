<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="pagerForm" method="post" action="xsthorder/list">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}"/>
    <input type="hidden" name="currentPage" value="1"/>
    <input type="hidden" name="numPerPage" value="${model.numPerPage}"/>
    <input type="hidden" name="orderField" value="${param.orderField}"/>
</form>


<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="xsthorder/list" method="post">
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
            <li><a class="add" href="xsthorder/insert" target="dialog" rel="form" width="820"
                   height="400"><span>添加</span></a></li>
            <li><a class="delete" href="xsthorder/delete" target="selectedTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="xsthorder/view?id={id}" target="dialog" warn="请选择要查看的数据" width="820"
                   height="400"><span>详情</span></a></li>
        </ul>
    </div>
    <table class="table" width="150%" layoutH="138">
        <thead>
        <tr>
            <th style="width: 18px; cursor: col-resize;">
                <div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div>
            </th>
            <th>销售出库单编号</th>
            <th>仓库名称</th>
            <th>药品名称</th>
            <th>操作人名称</th>
            <th>代理商名称</th>
            <th>商业公司名称</th>
            <th>销售单价</th>
            <th>付款金额</th>
            <th>数量</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="xsthorder">
            <tr target="id" rel="${xsthorder.id}">
                <td>
                    <div><input name="ids" value="${xsthorder.id}" type="checkbox"></div>
                </td>
                <td>${xsthorder.code}</td>
                <td>${xsthorder.warehouseName}</td>
                <td>${xsthorder.medicineName}</td>
                <td>${xsthorder.operatorName}</td>
                <td>${xsthorder.agentName}</td>
                <td>${xsthorder.commercialCompanyName}</td>
                <td>${xsthorder.salePrice}</td>
                <td>${xsthorder.saleMoney}</td>
                <td>${xsthorder.quantity}</td>
                <td>${xsthorder.descript}</td>
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
