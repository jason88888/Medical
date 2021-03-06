<%@ page import="com.taotaotech.domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>麦鼎业务管理系统</title>
    <%@include file="/WEB-INF/jsp/include/head.jsp" %>
</head>

<body scroll="no">
<div id="layout">
    <div id="header">
        <div class="headerNav">
            <a class="logo" href="${basePath}">标志</a>
            <ul class="nav">
                <li><a href="javascript:">${user.username}</a></li>
                <li id="switchEnvBox"><a href="javascript:">（<span>杭州</span>）切换城市</a>
                    <ul>
                        <li><a href="sidebar_1.html">北京</a></li>
                        <li><a href="sidebar_2.html">上海</a></li>
                        <li><a href="sidebar_2.html">南京</a></li>
                        <li><a href="sidebar_2.html">深圳</a></li>
                        <li><a href="sidebar_2.html">广州</a></li>
                        <li><a href="sidebar_2.html">天津</a></li>
                        <li><a href="sidebar_2.html">杭州</a></li>
                    </ul>
                </li>
                <%--<li><a href="https://me.alipay.com/dwzteam" target="_blank">捐赠</a></li>--%>
                <li><a href="javascript:" width="600">设置</a></li>
                <%-- target="dialog"--%>
                <%--<li><a href="http://www.cnblogs.com/dwzjs" target="_blank">博客</a></li>--%>
                <%--<li><a href="http://weibo.com/dwzui" target="_blank">微博</a></li>--%>
                <%--<li><a href="http://bbs.dwzjs.com" target="_blank">论坛</a></li>--%>
                <li><a href="logout">退出</a></li>
            </ul>
            <ul class="themeList" id="themeList">
                <li theme="default">
                    <div class="selected">蓝色</div>
                </li>
                <li theme="green">
                    <div>绿色</div>
                </li>
                <li theme="silver">
                    <div>银色</div>
                </li>
                <li theme="azure">
                    <div>天蓝</div>
                </li>
            </ul>
        </div>

        <!-- navMenu -->

    </div>

    <div id="leftside">
        <div id="sidebar_s">
            <div class="collapse">
                <div class="toggleCollapse">
                    <div></div>
                </div>
            </div>
        </div>
        <div id="sidebar">
            <div class="toggleCollapse"><h2>主菜单</h2>

                <div>收缩</div>
            </div>

            <div class="accordion" fillSpace="sidebar">
                <c:if test="${user.role == 1}">
                    <div class="accordionHeader">
                        <h2>
                            <span>Folder</span>基础数据管理
                        </h2>
                    </div>
                    <div class="accordionContent">
                        <ul class="tree treeFolder">
                            <li><a href="medicine/list" target="navTab" rel="medicine_list">产品目录</a></li>
                            <li><a href="provider/list" target="navTab" rel="provider_list">供应商管理</a></li>
                            <li><a href="client/list" target="navTab" rel="client_list">医疗机构管理</a></li>
                            <li><a href="agent/list" target="navTab" rel="agent_list">代理商管理</a></li>
                            <li><a href="commercialcompany/list" target="navTab"
                                   rel="commercialcompany_list">购进商业公司管理</a></li>
                            <li><a href="policy/list" target="navTab" rel="policy_list">销售政策管理</a></li>
                            <li><a href="user/list" target="navTab" rel="user_list">公司人员管理</a></li>
                            <li><a href="upload/view" target="navTab">数据导入</a></li>
                                <%--<li><a href="coming.html" target="navTab" rel="list3">管理员设置</a></li>--%>
                        </ul>
                    </div>
                    <div class="accordionHeader">
                        <h2>
                            <span>Folder</span>药品采购管理
                        </h2>
                    </div>
                    <div class="accordionContent">
                        <ul class="tree treeFolder">
                            <li><a href="cgsqorder/list" target="navTab" rel="cgsqorder_list">采购申请单管理</a></li>
                            <li><a href="cgrkorder/list" target="navTab" rel="cgrkorder_list">采购入库单管理</a></li>
                            <li><a href="cgthorder/list" target="navTab" rel="cgthorder_list">采购退货单管理</a></li>
                                <%--<li><a href="coming" target="navTab" rel="category_list">厂家发货与结算</a></li>--%>
                                <%--<li><a href="coming" target="navTab" rel="category_list">结算方式匹配</a></li>--%>
                        </ul>
                    </div>
                </c:if>
                <div class="accordionHeader">
                    <h2>
                        <span>Folder</span>药品销售管理
                    </h2>
                </div>
                <div class="accordionContent">
                    <ul class="tree treeFolder">
                        <li><a href="xssqorder/list" target="navTab" rel="xssqorder_list">销售申请单管理</a></li>
                        <li><a href="xsckorder/list" target="navTab" rel="xsckorder_list">销售出库单管理</a></li>
                        <li><a href="xsthorder/list" target="navTab" rel="xsthorder_list">销售退货单管理</a></li>
                        <li><a href="bill/list" target="navTab"
                               rel="bill_list">销售流向</a></li>
                        <li><a href="commission/list" target="navTab"
                               rel="admin_info">销售费用结算</a></li>
                        <c:if test="${user.role == 1}">
                            <li><a href="coming" target="navTab"
                                   rel="admin_info">费用结算复核</a></li>
                        </c:if>
                    </ul>
                </div>

                <c:if test="${user.role == 1}">
                    <div class="accordionHeader">
                        <h2>
                            <span>Folder</span>库存相关管理
                        </h2>
                    </div>
                    <div class="accordionContent">
                        <ul class="tree treeFolder">
                            <li><a href="warehouse/list?warehouseLevel=1" target="navTab" rel="warehouse_list">一级仓库管理</a></li>
                            <li><a href="warehouse/list?warehouseLevel=2" target="navTab" rel="warehouse_list">二级仓库管理</a></li>
                            <li><a href="stock/list" target="navTab" rel="warehouse_list">库存管理</a></li>
                        </ul>
                    </div>

                    <div class="accordionHeader">
                        <h2>
                            <span>Folder</span>财务管理
                        </h2>
                    </div>
                    <div class="accordionContent">
                        <ul class="tree treeFolder">
                            <li>尚未开发</li>
                        </ul>
                    </div>

                    <div class="accordionHeader">
                        <h2>
                            <span>Folder</span>领导审批
                        </h2>
                    </div>
                    <div class="accordionContent">
                        <ul class="tree treeFolder">
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">收入流水账审批</a></li>
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">支出流水账审批</a></li>
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">销售政策审批</a></li>
                        </ul>
                    </div>

                    <div class="accordionHeader">
                        <h2>
                            <span>Folder</span>业务分析
                        </h2>
                    </div>
                    <div class="accordionContent">
                        <ul class="tree treeFolder">
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">销售指标</a></li>
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">业务统计</a></li>
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">医院覆盖情况</a></li>
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">财务情况</a></li>
                            <li><a href="coming" target="dialog"
                                   rel="admin_info">业务员业绩</a></li>
                        </ul>
                    </div>
                </c:if>

            </div>
        </div>
    </div>
    <div id="container">
        <div id="navTab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                    <ul class="navTab-tab">
                        <li tabid="main" class="main"><a href="javascript:;"><span><span
                                class="home_icon">欢迎页</span></span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft">left</div>
                <!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                <div class="tabsRight">right</div>
                <!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                <div class="tabsMore">more</div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">欢迎页</a></li>
            </ul>
            <div class="navTab-panel tabsPageContent layoutBox">
                <div class="page unitBox">
                    <div class="pageFormContent" layoutH="80" style="margin-right:230px">
                        欢迎！
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

<div id="footer">Copyright &copy; 2015 <%--<a href="demo_page2.html" target="dialog">--%>taotao-tech团队</a>
    Tel：15158121565
</div>

</body>
</html>