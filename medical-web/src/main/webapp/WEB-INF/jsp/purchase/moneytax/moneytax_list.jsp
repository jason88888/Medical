<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="pagerForm" method="post" action="purchase/moneytax/list">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}"/>
    <input type="hidden" name="currentPage" value="1"/>
    <input type="hidden" name="numPerPage" value="${model.numPerPage}"/>
    <input type="hidden" name="orderField" value="${param.orderField}"/>
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="purchase/moneytax/list" method="post" rel="pagerForm">
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
            <li><a class="add" href="purchase/moneytax/insert" target="dialog"><span>添加</span></a></li>
            <li><a class="delete" href="purchase/moneytax/delete" target="selectedTodo" rel="ids" title="不建议删除基础数据！！确定要删除吗?"><span>删除</span></a>
            </li>
            <li><a class="edit" href="purchase/moneytax/view?id={id}" target="dialog" warn="请选择一个"><span>详情</span></a></li>
        </ul>
    </div>
    <table class="table" width="120%" layoutH="138">
        <thead>
        <tr>
            <th style="width: 18px; cursor: col-resize;">
                <div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div>
            </th>
            <th width="120">打款分类</th>
            <th width="200">付款方式</th>
            <th width="100">付款金额</th>
            <th width="250">业务流程及价</th>
            <th width="120">进项单价</th>
            <th width="120">进项金额</th>
            <th width="120">应付税</th>
            <th width="150">付税方式</th>
            <th width="150">付税日期</th>
            <th width="150">发票号码</th>
            <th width="150">开票日期</th>
            <th width="150">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="purchaseMoneytax">
            <tr target="id" rel="${purchaseMoneytax.id}">
                <td>
                    <div><input name="ids" value="${purchaseMoneytax.id}" type="checkbox"></div>
                </td>
                <td>${purchaseMoneytax.paymentCategory}</td>
                <td>${purchaseMoneytax.paymentMode}</td>
                <td>${purchaseMoneytax.paymentMoney}</td>
                <td>${purchaseMoneytax.workFlow}</td>
                <td>${purchaseMoneytax.purchaseUnitPrice}</td>
                <td>${purchaseMoneytax.purchaseMoney}</td>
                <td>${purchaseMoneytax.tax}</td>
                <td>${purchaseMoneytax.taxPayMode}</td>
                <td>${purchaseMoneytax.taxPayDate}</td>
                <td>${purchaseMoneytax.invoiceNumber}</td>
                <td>${purchaseMoneytax.invoiceDate}</td>
                <td>${purchaseMoneytax.descript}</td>
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
