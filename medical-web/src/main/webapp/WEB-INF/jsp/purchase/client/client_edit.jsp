<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="purchase/client/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${purchaseClient.id}"/>
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>我司上家销货单位：</label>
                <input name="saleCompany" class="required" type="text" autocomplete="off" size="30" value="${purchaseClient.saleCompany}" />
            </p>
            <p>
                <label>我司下家购货单位：</label>
                <input name="buyCompany" class="required" type="text" autocomplete="off" size="30" value="${purchaseClient.buyCompany}" />
            </p>
            <p>
                <label>为所属客户：</label>
                <input name="clientName"  type="text" autocomplete="off" size="30" value="${purchaseClient.clientName}" />
            </p>
            <p>
                <label>采购销售区域：</label>
                <input name="saleArea"  type="text" autocomplete="off" size="30" value="${purchaseClient.saleArea}" />
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript"  type="text" autocomplete="off" cols="28" alt="请输入备注" >${purchaseClient.descript}</textarea>
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
