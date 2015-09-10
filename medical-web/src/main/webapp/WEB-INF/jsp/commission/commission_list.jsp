<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="pagerForm" method="post" action="commission/l">
    <input type="hidden" name="status" value="${param.status}">
    <input type="hidden" name="keywords" value="${param.keywords}" />
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="numPerPage" value="${model.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="commission/list" method="post">
        <div class="searchBar">
            <!--<ul class="searchContent">
                <li>
                    <label>我的客户：</label>
                    <input type="text"/>
                </li>
                <li>
                <select class="combox" name="province">
                    <option value="">所有省市</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                    <option value="天津">天津</option>
                    <option value="重庆">重庆</option>
                    <option value="广东">广东</option>
                </select>
                </li>
            </ul>
            -->
            <table class="searchContent">
                <tr>
                    <td>
                        我的客户：<input type="text" name="keyword" />
                    </td>
                    <td>
                        <select class="combox" name="province">
                            <option value="">所有省市</option>
                            <option value="北京">北京</option>
                            <option value="上海">上海</option>
                            <option value="天津">天津</option>
                            <option value="重庆">重庆</option>
                            <option value="广东">广东</option>
                        </select>
                    </td>
                    <td>
                        建档日期：<input type="text" class="date" readonly="true" />
                    </td>
                </tr>
            </table>
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
            <li><a class="add" href="commission/insert" target="dialog"><span>添加</span></a></li>
            <li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th style="width: 18px; cursor: col-resize;"><div class="gridCol" title=""><input type="checkbox" group="ids" class="checkboxCtrl"></div></th>
            <th width="120">药品编码</th>
            <th width="250">药品名称</th>
            <th width="100">客户码</th>
            <th width="250">客户名称</th>
            <th width="150">开票日期</th>
            <th width="150">业务员姓名</th>
            <th width="150">业务员费用</th>
            <th width="150">二级费用</th>
            <th width="150">三级费用</th>
            <th width="150">厂家费用</th>
            <th width="150">附加费用1</th>
            <th width="150">附加费用2</th>
            <th width="150">附加费用3</th>
            <th width="150">营业额</th>
            <th width="150">总费用</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${commissions}" var="commission">
            <tr>
                <td><div><input name="ids" value="${commission.id}" type="checkbox"></div></td>
                <td>${commission.medicineCode}</td>
                <td>${commission.medicineName}</td>
                <td>${commission.clientCode}</td>
                <td>${commission.clientName}</td>
                <td>${commission.invoiceDate}</td>
                <td>${commission.salesmanName}</td>
                <td>${commission.salesmanCharge}</td>
                <td>${commission.twoLevelCharge}</td>
                <td>${commission.threeLevelCharge}</td>
                <td>${commission.manufacturerCharge}</td>
                <td>${commission.addCharge1}</td>
                <td>${commission.addCharge2}</td>
                <td>${commission.addCharge3}</td>
                <td>${commission.businessFee}</td>
                <td>${commission.totalCharge}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="200">200</option>
            </select>
            <span>条，共${totalCount}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

    </div>
</div>
