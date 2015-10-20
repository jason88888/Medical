<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    function medicineChange(){
        var value = $("#medicineUniqueCode").find("option:selected").text();
        $("#medicineName").val(value);
    }

</script>

<div class="pageContent">
    <form method="post" action="rkorder/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>入库单编号：</label>
                <input name="rkorderSaleType" type="text" size="30" class="required" value="${rkorder.code}" readonly/>
            </p>
            <p>
                <label>单据日期：</label>
                <input name="rkorderPayDate" class="required" type="text" autocomplete="off" size="30"  value="${rkorder.billDate}" alt="请选择单据日期" readonly/>
            </p>
            <p>
                <label>仓库名称：</label>
                <input name="rkorderStoreDate" class="required" type="text" autocomplete="off" size="30" value="${rkorder.warehouseId}" alt="请输入仓库名称" readonly/>
            </p>
            <p>
                <label>药品名称：</label>
                <input name="actualStorePlace" class="required" type="text" autocomplete="off" size="30" value="${rkorder.medicineId}" alt="请输入药品名称" readonly/>
            </p>
            <p>
                <label>操作人名称：</label>
                <input name="rkorderSaleCode" class="required" type="text" min="0"  autocomplete="off" size="30" value="${rkorder.sysUserId}" alt="请输入操作人名称" readonly/>
            </p>
            <p>
                <label>代理商名称：</label>
                <input name="manufacturerName" class="required" type="text" autocomplete="off" size="30" value="${rkorder.agentClientId}" alt="请输入代理商名称" readonly/>
            </p>
            <p>
                <label>配送商名称：</label>
                <input name="specification" class="required" type="text" autocomplete="off" size="30" value="${rkorder.providerId}" alt="请输入配送商名称" readonly/>
            </p>
            <p>
                <label>实际单价：</label>
                <input name="units" class="required" type="text" autocomplete="off" size="30" value="${rkorder.unitPrice}" alt="请输入实际单价" readonly/>
            </p>
            <p>
                <label>高开单价：</label>
                <input name="packageNumber" class="required" type="text" autocomplete="off" size="30" value="${rkorder.highUnitPrice}" alt="请输入高开单价" readonly/>
            </p>
            <p>
                <label>采购付款日期：</label>
                <input name="saleCompany" class="required" type="text" autocomplete="off" size="30" value="${rkorder.payDate}" alt="请输入采购付款日期" readonly/>
            </p>
            <p>
                <label>采购入库日期：</label>
                <input name="buyCompany" class="required" type="text" autocomplete="off" size="30" value="${rkorder.storeDate}" alt="请输入采购入库日期" readonly/>
            </p>
            <p>
                <label>采购申请单号：</label>
                <input name="payCategory" class="required" type="text" autocomplete="off" size="30" value="${rkorder.orderCode}" alt="请输入采购申请单号" readonly/>
            </p>
            <p>
                <label>采购单价：</label>
                <input name="payMode" class="required" type="text" autocomplete="off" size="30" value="${rkorder.purchasePrice}" alt="请输入采购单价" readonly/>
            </p>
            <p>
                <label>付款金额：</label>
                <input name="rkorderNumber" class="required" type="text" autocomplete="off" size="30" value="${rkorder.purchaseMoney}" alt="请输入付款金额" readonly/>
            </p>
            <p>
                <label>应付税：</label>
                <input name="rkorderUnitPrice" class="required" type="text" autocomplete="off" size="30" value="${rkorder.tax}" alt="请输入应付税" readonly/>
            </p>
            <p>
                <label>付税方式：</label>
                <input name="rkorderMoney" class="required" type="text" autocomplete="off" size="30" value="${rkorder.taxpayMode}" alt="请输入付税方式" readonly/>
            </p>
            <p>
                <label>付税日期：</label>
                <input name="tax" class="required" type="text" autocomplete="off" size="30" value="${rkorder.taxpayDate}" alt="请输入付税日期" readonly/>
            </p>
            <p>
                <label>发票号码：</label>
                <input name="taxPayMode" class="required" type="text" autocomplete="off" size="30" value="${rkorder.invoiceNumber}" alt="请输入发票号码" readonly/>
            </p>

            <p>
                <label>开票日期：</label>
                <input name="taxPayDate" class="required" type="text" autocomplete="off" size="30" value="${rkorder.invoiceDate}" alt="请输入开票日期" readonly/>
            </p>
            <p>
                <label>数量：</label>
                <input name="invoiceNumber" class="required" type="text" autocomplete="off" size="30" value="${rkorder.quantity}" alt="请输入数量" readonly/>
            </p>
            <p>
                <label>备注：</label>
                <input name="invoiceDate" class="required" type="text" autocomplete="off" size="30" value="${rkorder.descript}" alt="请输入备注" readonly/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit"><a href="rkorder/edit?id=${rkorder.id}" target="dialog" rel="form">编辑</a></button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
