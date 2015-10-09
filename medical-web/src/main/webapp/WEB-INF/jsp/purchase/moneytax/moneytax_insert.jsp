<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="purchase/moneytax/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>打款分类：</label>
                <input name="paymentCategory" class="required" type="text" autocomplete="off" size="30" alt="请输入打款分类"/>
            </p>
            <p>
                <label>付款方式：</label>
                <input name="paymentMode" class="required" type="text" autocomplete="off" size="30" alt="请输入付款方式"/>
            </p>
            <p>
                <label>付款金额：</label>
                <input name="paymentMoney"  type="text" autocomplete="off" size="30" alt="请输入付款金额"/>
            </p>
            <p>
                <label>业务流程及价：</label>
                <input name="workFlow"  type="text" autocomplete="off" size="30" alt="请输入业务流程及价"/>
            </p>
            <p>
                <label>进项单价：</label>
                <input name="purchaseUnitPrice"  type="text" autocomplete="off" size="30" alt="请进项单价"/>
            </p>
            <p>
                <label>进项金额：</label>
                <input name="purchaseMoney" type="text" autocomplete="off" size="30" alt="请进项金额"/>
            </p>
            <p>
                <label>应付税：</label>
                <input name="tax" type="text" autocomplete="off" size="30" alt="请输入应付税"/>
            </p>
            <p>
                <label>付税方式：</label>
                <input name="taxPayMode" type="text" autocomplete="off" size="30" alt="请输入付税方式"/>
            </p>
            <p>
                <label>付税日期：</label>
                <input name="taxPayDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<span class="info">yyyy-MM-dd</span>--%>
                <%--<input name="taxPayDate" type="text" autocomplete="off" size="30" alt="请输入付税日期"/>--%>
            </p>
            <p>
                <label>发票号码：</label>
                <input name="invoiceNumber" type="text" autocomplete="off" size="30" alt="请输入发票号码"/>
            </p>
            <p>
                <label>开票日期：</label>
                <input name="invoiceDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<input name="invoiceDate" type="text" autocomplete="off" size="30" alt="请输入开票日期"/>--%>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
