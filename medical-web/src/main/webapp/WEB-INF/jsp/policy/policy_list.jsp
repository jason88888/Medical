<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="pagerForm" method="post" action="policy/search">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}" />
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="numPerPage" value="${model.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="policy/list" method="post">
        <div class="searchBar">
            <%--<table class="searchContent">--%>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--我的客户：<input type="text" name="keyword" />--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<select class="combox" name="province">--%>
                            <%--<option value="">所有省市</option>--%>
                            <%--<option value="北京">北京</option>--%>
                            <%--<option value="上海">上海</option>--%>
                            <%--<option value="天津">天津</option>--%>
                            <%--<option value="重庆">重庆</option>--%>
                            <%--<option value="广东">广东</option>--%>
                        <%--</select>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--建档日期：<input type="text" class="date" readonly="true" />--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</table>--%>
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
            <li><a class="add" href="policy/insert" target="dialog"><span>添加</span></a></li>
            <li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="policy/upload" target="dialog"><span>导入EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th style="width: 18px; cursor: col-resize;"><div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div></th>
            <th>所属区域</th>
            <%--<th>业务员编码</th>--%>
            <th>月份</th>
            <th>药品编号</th>
            <th>客户代码</th>
            <th>业务员政策</th>
            <th>临床政策</th>
            <th>厂家政策</th>
            <%--<th>二级代码</th>--%>
            <th>二级政策</th>
            <%--<th>三级代码</th>--%>
            <th>三级政策</th>
            <th>附加政策1</th>
            <th>附加政策2</th>
            <th>附加政策3</th>
            <th>单价</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="policy">
            <tr>
                <td><div><input name="ids" value="${policy.id}" type="checkbox"></div></td>
                <td>${policy.regional}</td>
                <%--<td>${policy.userCode}</td>--%>
                <td>${policy.month}</td>
                <td>${policy.medicineCode}</td>
                <td>${policy.clientCode}</td>
                <td>${policy.salesmanPolicy}</td>
                <td>${policy.clinicalPolicy}</td>
                <td>${policy.manufacturerPolicy}</td>
                <%--<td>${policy.twoLevelCode}</td>--%>
                <td>${policy.twoLevelPolicy}</td>
                <%--<td>${policy.threeLevelCode}</td>--%>
                <td>${policy.threeLevelPolicy}</td>
                <td>${policy.addPolicy1}</td>
                <td>${policy.addPolicy2}</td>
                <td>${policy.addPolicy3}</td>
                <td>${policy.price}</td>
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
