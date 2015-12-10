<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="xssqorder/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${xssqorder.id}"/>
            <p>
                <label>销售出库单编号：</label>
                <input name="code" type="text" size="30" class="required" value="${xssqorder.code}"/>
            </p>

            <p>
                <label>单据日期：</label>
                <input name="billDate" class="date" type="text" readonly="true" value="${xssqorder.billDate}"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>仓库名称：</label>
                <input name="warehouseId" type="hidden" value="${xssqorder.warehouseId}"/>
                <input name="warehouse.id" type="hidden" value="${xssqorder.warehouseId}"/>
                <input type="text" class="required" value="${xssqorder.warehouseName}" name="warehouse.name"
                       rel="lookup" value="" postField="name" suggestFields="name,code"
                       suggestUrl="warehouse/lookup_suggest" lookupGroup="warehouse"/>
                <a class="btnLook" href="warehouse/lookup" lookupGroup="warehouse">查找带回</a>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="hidden" value="${xssqorder.medicineId}"/>
                <input name="medicine.id" type="hidden" value="${xssqorder.medicineId}"/>
                <input type="text" class="required" value="${xssqorder.medicineName}" name="medicine.name" rel="lookup"
                       value="" postField="name" suggestFields="name,code" suggestUrl="medicine/lookup_suggest"
                       lookupGroup="medicine"/>
                <a class="btnLook" href="medicine/lookup" lookupGroup="medicine">查找带回</a>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="hidden" value="${xssqorder.sysUserId}"/>
                <input name="user.id" type="hidden" value="${xssqorder.sysUserId}"/>
                <input type="text" class="required" value="${xssqorder.operatorName}" name="user.username" rel="lookup"
                       value="" postField="name" suggestFields="name,code" suggestUrl="user/lookup_suggest"
                       lookupGroup="user"/>
                <a class="btnLook" href="user/lookup" lookupGroup="user">查找带回</a>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="agentId" type="hidden" value="${xssqorder.agentId}"/>
                <input name="agent.id" type="hidden" value="${xssqorder.agentId}"/>
                <input type="text" class="required" value="${xssqorder.agentName}" name="agent.name" rel="lookup"
                       value="" postField="name"
                       suggestFields="name,code" suggestUrl="agent/lookup_suggest" lookupGroup="agent"/>
                <a class="btnLook" href="agent/lookup" lookupGroup="agent">查找带回</a>
            </p>

            <p>
                <label>购进商业公司名称：</label>
                <input name="commercialCompanyId" type="hidden" value="${xssqorder.commercialCompanyId}"/>
                <input name="commercialcompany.id" type="hidden" value="${xssqorder.commercialCompanyId}"/>
                <input type="text" class="required" value="${xssqorder.commercialCompanyName}"
                       name="commercialcompany.name" rel="lookup" value="" postField="name"
                       suggestFields="name,code" suggestUrl="commercialcompany/lookup_suggest"
                       lookupGroup="commercialcompany"/>
                <a class="btnLook" href="commercialcompany/lookup" lookupGroup="commercialcompany">查找带回</a>
            </p>

            <p>
                <label>销售单价：</label>
                <input name="salePrice" type="text" value="${xssqorder.salePrice}" autocomplete="off" size="30"
                       alt="请输入销售单价"/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="saleMoney" type="text" value="${xssqorder.saleMoney}" autocomplete="off" size="30"
                       alt="请输入付款金额"/>
            </p>

            <p>
                <label>入库数量：</label>
                <input name="quantity" class="required" type="text" value="${xssqorder.quantity}" autocomplete="off"
                       size="30" alt="请输入入库数量"/>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" value="${xssqorder.descript}" autocomplete="off" cols="28"
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
