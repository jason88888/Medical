<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="cgrkorder/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>入库单编号：</label>
                <input name="code" type="text" size="30" class="required"/>
            </p>

            <p>
                <label>单据日期：</label>
                <input name="billDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>仓库名称：</label>
                <input name="warehouseId" type="hidden" value="${cgrkorder.warehouseId}"/>
                <input name="warehouse.id" type="hidden" value="${cgrkorder.warehouseId}"/>
                <input type="text" class="required" value="" name="warehouse.name" rel="lookup" postField="name"
                       suggestFields="name,code" suggestUrl="warehouse/lookup_suggest" lookupGroup="warehouse"/>
                <a class="btnLook" href="warehouse/lookup" lookupGroup="warehouse">查找带回</a>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="hidden" value="${cgrkorder.medicineId}"/>
                <input name="medicine.id" type="hidden" value="${cgrkorder.medicineId}"/>
                <input type="text" class="required" name="medicine.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="medicine/lookup_suggest" lookupGroup="medicine"/>
                <a class="btnLook" href="medicine/lookup" lookupGroup="medicine">查找带回</a>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="hidden" value="${cgrkorder.sysUserId}"/>
                <input name="user.id" type="hidden" value="${cgrkorder.sysUserId}"/>
                <input type="text" class="required" name="user.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="user/lookup_suggest" lookupGroup="user"/>
                <a class="btnLook" href="user/lookup" lookupGroup="user">查找带回</a>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="agentId" type="hidden" value="${cgrkorder.agentId}"/>
                <input name="agent.id" type="hidden" value="${cgrkorder.agentId}"/>
                <input type="text" class="required" name="agent.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="agent/lookup_suggest" lookupGroup="agent"/>
                <a class="btnLook" href="agent/lookup" lookupGroup="agent">查找带回</a>
            </p>

            <p>
                <label>购进商业公司名称：</label>
                <input name="commercialCompanyId" type="hidden" value="${cgrkorder.commercialCompanyId}"/>
                <input name="commercialcompany.id" type="hidden" value="${cgrkorder.commercialCompanyId}"/>
                <input type="text" class="required" name="agent.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="commercialcompany/lookup_suggest"
                       lookupGroup="commercialcompany"/>
                <a class="btnLook" href="commercialcompany/lookup" lookupGroup="commercialcompany">查找带回</a>
            </p>

            <p>
                <label>供应商名称：</label>
                <input name="providerId" type="hidden" value="${cgrkorder.providerId}"/>
                <input name="provider.id" type="hidden" value="${cgrkorder.providerId}"/>
                <input type="text" class="required" name="provider.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="provider/lookup_suggest" lookupGroup="provider"/>
                <a class="btnLook" href="provider/lookup" lookupGroup="provider">查找带回</a>
            </p>

            <p>
                <label>实际单价：</label>
                <input name="unitPrice" type="text" autocomplete="off" size="30" alt="请输入实际单价"/>
            </p>

            <p>
                <label>高开单价：</label>
                <input name="highUnitPrice" type="text" autocomplete="off" size="30" alt="请输入高开单价"/>
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
                <label>入库单编号：</label>
                <input name="orderCode" class="required" type="text" autocomplete="off" size="30" alt="请输入入库单编号"/>
            </p>

            <p>
                <label>采购单价：</label>
                <input name="purchasePrice" type="text" autocomplete="off" size="30" alt="请输入采购单价"/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="purchasePrice" type="text" autocomplete="off" size="30" alt="请输入付款金额"/>
            </p>

            <p>
                <label>应付税：</label>
                <input name="tax" type="text" autocomplete="off" size="30" alt="请输入应付税"/>
            </p>

            <p>
                <label>付税方式：</label>
                <input name="taxpayMode" type="text" autocomplete="off" size="30" alt="请输入付税方式"/>
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
                <textarea name="descript" type="text" autocomplete="off" cols="28" alt="请输入备注"></textarea>
            </p>

        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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
