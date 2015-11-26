<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    function medicineChange() {
        var value = $("#medicineUniqueCode").find("option:selected").text();
        $("#medicineName").val(value);
    }

</script>

<div class="pageContent">
    <form method="post" action="cgthorder/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>采购退货单编号：</label>
                <input name="code" type="text" size="30" value="${cgthorder.code}" readonly/>
            </p>
            <%--<p>--%>
            <%--<label>单据日期：</label>--%>
            <%--<input name="cgthorderPayDate"  type="text" autocomplete="off" size="30"  value="${cgthorder.billDate}" alt="请选择单据日期" readonly/>--%>
            <%--</p>--%>
            <p>
                <label>仓库名称：</label>
                <input name="warehouseId" type="text" autocomplete="off" size="30" value="${cgthorder.warehouseName}" readonly/>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="text" autocomplete="off" size="30" value="${cgthorder.medicineName}" readonly/>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="text" autocomplete="off" size="30" value="${cgthorder.operatorName}" readonly/>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="agentId" type="text" autocomplete="off" size="30" value="${cgthorder.agentName}" readonly/>
            </p>

            <p>
                <label>供应商名称：</label>
                <input name="providerId" type="text" autocomplete="off" size="30" value="${cgthorder.providerName}" readonly/>
            </p>

            <p>
                <label>购进商业公司名称：</label>
                <input name="commercialCompanyId" type="text" autocomplete="off" size="30"
                       value="${cgthorder.commercialCompanyName}" readonly/>
            </p>

            <p>
                <label>实际单价：</label>
                <input name="units" type="text" autocomplete="off" size="30" value="${cgthorder.unitPrice}" readonly/>
            </p>

            <p>
                <label>高开单价：</label>
                <input name="packageNumber" type="text" autocomplete="off" size="30" value="${cgthorder.highUnitPrice}" readonly/>
            </p>

            <p>
                <label>退货收款日期：</label>
                <input name="saleCompany" type="text" autocomplete="off" size="30" value="${cgthorder.returnDate}" readonly/>
            </p>

            <p>
                <label>退货出库日期：</label>
                <input name="buyCompany" type="text" autocomplete="off" size="30" value="${cgthorder.outStoreDate}" readonly/>
            </p>

            <p>
                <label>采购单价：</label>
                <input name="payMode" type="text" autocomplete="off" size="30" value="${cgthorder.purchasePrice}" readonly/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="cgthorderNumber" type="text" autocomplete="off" size="30" value="${cgthorder.purchaseMoney}" readonly/>
            </p>

            <p>
                <label>备注：</label>
                <input name="invoiceDate" type="text" autocomplete="off" size="30" value="${cgthorder.descript}" readonly/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <a href="cgthorder/edit?id=${cgthorder.id}" target="dialog" rel="form"
                                                     width="820" height="400">编辑</a>
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
