<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="rkorder/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>入库单编号：</label>
                <input name="code" type="text" size="30" class="required" />
            </p>
            <p>
                <label>单据日期：</label>
                <input name="billDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<input name="invoiceDate" type="text" autocomplete="off" size="30" alt="请输入开票日期"/>--%>
            </p>

            <p>
                <label>仓库名称：</label>
                <input name="warehouseId" type="hidden" value="${rkorder.warehouseId}"/>
                <input name="warehouse.code" type="hidden" value="${rkorder.warehouseId}"/>
                <input type="text" class="required" name="client.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="warehouse/lookup_suggest" lookupGroup="warehouse"/>
                <a class="btnLook" href="warehouse/lookup" lookupGroup="client">查找带回</a>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="hidden" value="${rkorder.medicineId}"/>
                <input name="medicine.code" type="hidden" value="${rkorder.medicineId}"/>
                <input type="text" class="required" name="medicine.name" rel="lookup" value="" postField="name" suggestFields="name,code" suggestUrl="medicine/lookup_suggest" lookupGroup="medicine" />
                <a class="btnLook" href="medicine/lookup" lookupGroup="medicine">查找带回</a>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="hidden" value="${rkorder.sysUserId}"/>
                <input name="user.code" type="hidden" value="${rkorder.sysUserId}"/>
                <input type="text" class="required" name="user.username" rel="lookup" value="" postField="username" suggestFields="username,code" suggestUrl="user/lookup_suggest" lookupGroup="user" />
                <a class="btnLook" href="user/lookup" lookupGroup="user">查找带回</a>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="agentClientId" type="hidden" value="${agentclient.code}"/>
                <input name="user.code" type="hidden" value="${agentclient.code}"/>
                <input type="text" class="required" name="user.username" rel="lookup" value="" postField="name" suggestFields="username,code" suggestUrl="agentclient/lookup_suggest" lookupGroup="agentclient" />
                <a class="btnLook" href="agentclient/lookup" lookupGroup="user">查找带回</a>
            </p>

            <p>
                <label>配送商名称：</label>
                <input name="providerId" type="hidden" value="${provider.code}"/>
                <input name="provider.code" type="hidden" value="${provider.code}"/>
                <input type="text" class="required" name="user.username" rel="lookup" value="" postField="name" suggestFields="username,code" suggestUrl="provider/lookup_suggest" lookupGroup="provider" />
                <a class="btnLook" href="provider/lookup" lookupGroup="user">查找带回</a>
            </p>

            <p>
                <label>实际单价：</label>
                <input name="unitPrice" class="required" type="text" autocomplete="off" size="30" alt="请输入实际单价"/>
            </p>

            <p>
                <label>高开单价：</label>
                <input name="highUnitPrice" class="required" type="text" autocomplete="off" size="30" alt="请输入高开单价"/>
            </p>

            <p>
                <label>采购付款日期：</label>
                <input name="payDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>采购入库日期：</label>
                <input name="storeDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>采购申请单号：</label>
                <input name="orderCode" class="required" type="text" autocomplete="off" size="30" alt="请输入采购申请单号"/>
            </p>

            <p>
                <label>采购单价：</label>
                <input name="purchasePrice" class="required" type="text" autocomplete="off" size="30" alt="请输入采购单价"/>
            </p>

            <p>
                <label>应付税：</label>
                <input name="tax" class="required" type="text" autocomplete="off" size="30" alt="请输入应付税"/>
            </p>

            <p>
                <label>付税方式：</label>
                <input name="taxpayMode" class="required" type="text" autocomplete="off" size="30" alt="请输入付税方式"/>
            </p>

            <p>
                <label>付税日期：</label>
                <input name="storeDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>发票号码：</label>
                <input name="invoiceNumber" class="required" type="text" autocomplete="off" size="30" alt="请输入发票号码"/>
            </p>

            <p>
                <label>开票日期：</label>
                <input name="storeDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>入库数量：</label>
                <input name="quantity" class="required" type="text" autocomplete="off" size="30" alt="请输入入库数量"/>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript"  type="text" autocomplete="off" cols="28" alt="请输入备注"></textarea>
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
