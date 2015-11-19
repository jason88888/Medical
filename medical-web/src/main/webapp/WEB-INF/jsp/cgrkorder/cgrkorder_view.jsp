<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    function medicineChange() {
        var value = $("#medicineUniqueCode").find("option:selected").text();
        $("#medicineName").val(value);
    }

</script>

<div class="pageContent">
    <form method="post" action="cgrkorder/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>入库单编号：</label>
                <input name="code" type="text" size="30" value="${cgrkorder.id}" readonly/>
            </p>
            <%--<p>--%>
            <%--<label>单据日期：</label>--%>
            <%--<input name="cgrkorderPayDate"  type="text" autocomplete="off" size="30"  value="${cgrkorder.billDate}" alt="请选择单据日期" readonly/>--%>
            <%--</p>--%>
            <p>
                <label>仓库名称：</label>
                <input name="warehouseId" type="text" autocomplete="off" size="30" value="${cgrkorder.warehouseName}"
                       alt="请输入仓库名称" readonly/>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="text" autocomplete="off" size="30" value="${cgrkorder.medicineName}"
                       alt="请输入药品名称" readonly/>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="text" min="0" autocomplete="off" size="30" value="${cgrkorder.operatorName}"
                       alt="请输入操作人名称" readonly/>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="agentId" type="text" autocomplete="off" size="30" value="${cgrkorder.agentName}"
                       alt="请输入代理商名称" readonly/>
            </p>

            <p>
                <label>供应商名称：</label>
                <input name="providerId" type="text" autocomplete="off" size="30" value="${cgrkorder.providerName}"
                       alt="请输入配送商名称" readonly/>
            </p>

            <p>
                <label>购进商业公司名称：</label>
                <input name="commercialCompanyId" type="text" autocomplete="off" size="30"
                       value="${cgrkorder.commercialCompanyName}" alt="请输入配送商名称" readonly/>
            </p>

            <p>
                <label>实际单价：</label>
                <input name="units" type="text" autocomplete="off" size="30" value="${cgrkorder.unitPrice}" alt="请输入实际单价"
                       readonly/>
            </p>

            <p>
                <label>高开单价：</label>
                <input name="packageNumber" type="text" autocomplete="off" size="30" value="${cgrkorder.highUnitPrice}"
                       alt="请输入高开单价" readonly/>
            </p>

            <p>
                <label>采购付款日期：</label>
                <input name="saleCompany" type="text" autocomplete="off" size="30" value="${cgrkorder.payDate}"
                       alt="请输入采购付款日期" readonly/>
            </p>

            <p>
                <label>采购入库日期：</label>
                <input name="buyCompany" type="text" autocomplete="off" size="30" value="${cgrkorder.storeDate}"
                       alt="请输入采购入库日期" readonly/>
            </p>

            <p>
                <label>采购申请单号：</label>
                <input name="payCategory" type="text" autocomplete="off" size="30" value="${cgrkorder.orderCode}"
                       alt="请输入采购申请单号" readonly/>
            </p>

            <p>
                <label>采购单价：</label>
                <input name="payMode" type="text" autocomplete="off" size="30" value="${cgrkorder.purchasePrice}"
                       alt="请输入采购单价" readonly/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="cgrkorderNumber" type="text" autocomplete="off" size="30" value="${cgrkorder.purchaseMoney}"
                       alt="请输入付款金额" readonly/>
            </p>

            <p>
                <label>应付税：</label>
                <input name="cgrkorderUnitPrice" type="text" autocomplete="off" size="30" value="${cgrkorder.tax}"
                       alt="请输入应付税" readonly/>
            </p>

            <p>
                <label>付税方式：</label>
                <input name="cgrkorderMoney" type="text" autocomplete="off" size="30" value="${cgrkorder.taxpayMode}"
                       alt="请输入付税方式" readonly/>
            </p>

            <p>
                <label>付税日期：</label>
                <input name="tax" type="text" autocomplete="off" size="30" value="${cgrkorder.taxpayDate}" alt="请输入付税日期"
                       readonly/>
            </p>

            <p>
                <label>发票号码：</label>
                <input name="taxPayMode" type="text" autocomplete="off" size="30" value="${cgrkorder.invoiceNumber}"
                       alt="请输入发票号码" readonly/>
            </p>

            <p>
                <label>开票日期：</label>
                <input name="taxPayDate" type="text" autocomplete="off" size="30" value="${cgrkorder.invoiceDate}"
                       alt="请输入开票日期" readonly/>
            </p>

            <p>
                <label>数量：</label>
                <input name="invoiceNumber" type="text" autocomplete="off" size="30" value="${cgrkorder.quantity}"
                       alt="请输入数量" readonly/>
            </p>

            <p>
                <label>备注：</label>
                <input name="invoiceDate" type="text" autocomplete="off" size="30" value="${cgrkorder.descript}"
                       alt="请输入备注" readonly/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit"><a href="cgrkorder/edit?id=${cgrkorder.id}" target="dialog" rel="form"
                                                     width="800" height="400">编辑</a></button>
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
