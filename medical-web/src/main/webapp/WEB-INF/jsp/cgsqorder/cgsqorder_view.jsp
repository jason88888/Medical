<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pageContent">
    <form method="post" action="cgsqorder/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <p>
                <label>采购申请单编号：</label>
                <input name="code" type="text" size="30" class="required" value="${cgsqorder.id}" readonly/>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="text" autocomplete="off" size="30" value="${cgsqorder.medicineName}"
                       alt="请输入药品名称" readonly/>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="text" min="0" autocomplete="off" size="30"
                       value="${cgsqorder.operatorName}"
                       alt="请输入操作人名称" readonly/>
            </p>

            <p>
                <label>供应商名称：</label>
                <input name="providerId" type="text" autocomplete="off" size="30" value="${cgsqorder.providerName}"
                       alt="请输入配送商名称" readonly/>
            </p>

            <p>
                <label>实际单价：</label>
                <input name="unitPrice" value="${cgsqorder.unitPrice}" type="text" autocomplete="off" size="30"
                       alt="请输入实际单价" readonly/>
            </p>

            <p>
                <label>高开单价：</label>
                <input name="highUnitPrice" value="${cgsqorder.highUnitPrice}" type="text" autocomplete="off" size="30"
                       alt="请输入高开单价" readonly/>
            </p>

            <p>
                <label>采购申请单号：</label>
                <input name="orderCode" class="required" value="${cgsqorder.orderCode}" type="text" autocomplete="off"
                       size="30" alt="请输入采购申请单号" readonly/>
            </p>

            <p>
                <label>采购单价：</label>
                <input name="purchasePrice" type="text" value="${cgsqorder.purchasePrice}" autocomplete="off" size="30"
                       alt="请输入采购单价" readonly/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="purchasePrice" type="text" value="${cgsqorder.purchaseMoney}" autocomplete="off" size="30"
                       alt="请输入付款金额" readonly/>
            </p>

            <p>
                <label>应付税：</label>
                <input name="tax" type="text" value="${cgsqorder.tax}" autocomplete="off" size="30" alt="请输入应付税"
                       readonly/>
            </p>

            <p>
                <label>付税方式：</label>
                <input name="taxpayMode" type="text" value="${cgsqorder.taxpayMode}" autocomplete="off" size="30"
                       alt="请输入付税方式" readonly/>
            </p>

            <p>
                <label>付税日期：</label>
                <input name="tax" type="text" autocomplete="off" size="30" value="${cgsqorder.taxpayDate}" alt="请输入付税日期"
                       readonly/>
            </p>

            <p>
                <label>备注：</label>
                <input name="invoiceDate" type="text" autocomplete="off" size="30" value="${cgsqorder.descript}"
                       alt="请输入备注" readonly/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit"><a href="cgsqorder/edit?id=${cgsqorder.id}" target="dialog" rel="form"
                                                     width="820" height="400">编辑</a></button>
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