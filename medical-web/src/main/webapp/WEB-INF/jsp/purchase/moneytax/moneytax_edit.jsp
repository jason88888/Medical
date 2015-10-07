<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="purchase/moneytax/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${purchaseMoneytax.id}"/>
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>打款分类：</label>
                <input name="paymentCategory" type="text" autocomplete="off" value="${purchaseMoneytax.paymentCategory}"/>
            </p>
            <p>
                <label>付款方式：</label>
                <input name="paymentMode" type="text" autocomplete="off" size="30" value="${purchaseMoneytax.paymentMode}"/>
            </p>
            <p>
                <label>付款金额：</label>
                <input name="paymentMoney"  type="text" autocomplete="off" size="30" value="${purchaseMoneytax.paymentMoney}"/>
            </p>
            <p>
                <label>业务流程及价：</label>
                <input name="workFlow"  type="text" autocomplete="off" size="30" value="${purchaseMoneytax.workFlow}"/>
            </p>
            <p>
                <label>进项单价：</label>
                <input name="purchaseUnitPrice"  type="text" autocomplete="off" size="30" value="${purchaseMoneytax.purchaseUnitPrice}"/>
            </p>
            <p>
                <label>进项金额：</label>
                <input name="purchaseMoney" type="text" autocomplete="off" size="30" value="${purchaseMoneytax.purchaseMoney}"/>
            </p>
            <p>
                <label>应付税：</label>
                <input name="tax" type="text" autocomplete="off" size="30" value="${purchaseMoneytax.tax}"/>
            </p>
            <p>
                <label>付税方式：</label>
                <input name="taxPayMode" type="text" autocomplete="off" size="30" value="${purchaseMoneytax.taxPayMode}"/>
            </p>
            <p>
                <label>付税日期：</label>
                <input name="taxPayDate" class="date"  type="text" autocomplete="off" size="30" value="${purchaseMoneytax.taxPayDate}"/>
            </p>
            <p>
                <label>发票号码：</label>
                <input name="invoiceNumber" type="text" autocomplete="off" size="30" value="${purchaseMoneytax.invoiceNumber}"/>
            </p>
            <p>
                <label>开票日期：</label>
                <input name="invoiceDate" type="text" autocomplete="off" size="30" value="${purchaseMoneytax.invoiceDate}"/>
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
