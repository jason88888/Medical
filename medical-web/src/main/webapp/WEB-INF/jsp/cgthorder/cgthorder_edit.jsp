<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="cgthorder/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${cgthorder.id}"/>
            <p>
                <label>入库单编号：</label>
                <input name="code" type="text" size="30" class="required" value="${cgthorder.code}"/>
            </p>

            <p>
                <label>单据日期：</label>
                <input name="billDate" class="date" type="text" readonly="true" value="${cgthorder.billDate}"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>仓库名称：</label>
                <input name="warehouseId" type="hidden" value="${cgthorder.warehouseId}"/>
                <input name="warehouse.id" type="hidden" value="${cgthorder.warehouseId}"/>
                <input type="text" class="required" value="${cgthorder.warehouseName}" name="warehouse.name"
                       rel="lookup" value="" postField="name" suggestFields="name,code"
                       suggestUrl="warehouse/lookup_suggest" lookupGroup="warehouse"/>
                <a class="btnLook" href="warehouse/lookup" lookupGroup="warehouse">查找带回</a>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="hidden" value="${cgthorder.medicineId}"/>
                <input name="medicine.id" type="hidden" value="${cgthorder.medicineId}"/>
                <input type="text" class="required" value="${cgthorder.medicineName}" name="medicine.name" rel="lookup"
                       value="" postField="name" suggestFields="name,code" suggestUrl="medicine/lookup_suggest"
                       lookupGroup="medicine"/>
                <a class="btnLook" href="medicine/lookup" lookupGroup="medicine">查找带回</a>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="hidden" value="${cgthorder.sysUserId}"/>
                <input name="user.id" type="hidden" value="${cgthorder.sysUserId}"/>
                <input type="text" class="required" value="${cgthorder.operatorName}" name="user.username" rel="lookup"
                       value="" postField="name" suggestFields="name,code" suggestUrl="user/lookup_suggest"
                       lookupGroup="user"/>
                <a class="btnLook" href="user/lookup" lookupGroup="user">查找带回</a>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="agentId" type="hidden" value="${cgthorder.agentId}"/>
                <input name="agent.id" type="hidden" value="${cgthorder.agentId}"/>
                <input type="text" class="required" value="${cgthorder.agentName}" name="agent.name" rel="lookup"
                       value="" postField="name"
                       suggestFields="name,code" suggestUrl="agent/lookup_suggest" lookupGroup="agent"/>
                <a class="btnLook" href="agent/lookup" lookupGroup="agent">查找带回</a>
            </p>

            <p>
                <label>购进商业公司名称：</label>
                <input name="commercialCompanyId" type="hidden" value="${cgthorder.commercialCompanyId}"/>
                <input name="commercialcompany.id" type="hidden" value="${cgthorder.commercialCompanyId}"/>
                <input type="text" class="required" value="${cgthorder.commercialCompanyName}"
                       name="commercialcompany.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="commercialcompany/lookup_suggest"
                       lookupGroup="commercialcompany"/>
                <a class="btnLook" href="commercialcompany/lookup" lookupGroup="commercialcompany">查找带回</a>
            </p>

            <p>
                <label>供应商名称：</label>
                <input name="providerId" type="hidden" value="${cgthorder.providerId}"/>
                <input name="provider.id" type="hidden" value="${cgthorder.providerId}"/>
                <input type="text" class="required" value="${cgthorder.providerName}" name="provider.name" rel="lookup"
                       value="" postField="name" suggestFields="name,code" suggestUrl="provider/lookup_suggest"
                       lookupGroup="provider"/>
                <a class="btnLook" href="provider/lookup" lookupGroup="provider">查找带回</a>
            </p>

            <p>
                <label>实际单价：</label>
                <input name="unitPrice" value="${cgthorder.unitPrice}" type="text" autocomplete="off" size="30"
                       alt="请输入实际单价"/>
            </p>

            <p>
                <label>高开单价：</label>
                <input name="highUnitPrice" value="${cgthorder.highUnitPrice}" type="text" autocomplete="off" size="30"
                       alt="请输入高开单价"/>
            </p>

            <p>
                <label>退货收款日期：</label>
                <input name="payDate" class="date" type="text" value="${cgthorder.returnDate}" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>退货出库日期：</label>
                <input name="storeDate" class="date" type="text" value="${cgthorder.outStoreDate}" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>采购单价：</label>
                <input name="purchasePrice" type="text" value="${cgthorder.purchasePrice}" autocomplete="off" size="30"
                       alt="请输入采购单价"/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="purchasePrice" type="text" value="${cgthorder.purchaseMoney}" autocomplete="off" size="30"
                       alt="请输入付款金额"/>
            </p>

            <p>
                <label>入库数量：</label>
                <input name="quantity" class="required" type="text" value="${cgthorder.quantity}" autocomplete="off"
                       size="30" alt="请输入入库数量"/>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" value="${cgthorder.descript}" autocomplete="off" cols="28"
                          alt="请输入备注"></textarea>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>