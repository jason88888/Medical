<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    function medicineChange(){
        var value = $("#medicineUniqueCode").find("option:selected").text();
        $("#medicineName").val(value);
    }

</script>

<div class="pageContent">
    <form method="post" action="purchase/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>采购销售类别：</label>
                <input name="purchaseSaleType" type="text" size="30" class="required" />
            </p>
            <p>
                <label>采购付款日期：</label>
                <input name="purchasePayDate" class="required" type="date" autocomplete="off" size="30" alt="请选择付款日期"/>
            </p>
            <p>
                <label>采购入库日期：</label>
                <input name="purchaseStoreDate" class="required" type="date" autocomplete="off" size="30" alt="请选择入库日期"/>
            </p>
            <p>
                <label>实际入库地点：</label>
                <input name="actualStorePlace" class="required" type="text" autocomplete="off" size="30" alt="请选择开票日期"/>
            </p>
            <p>
                <label>采购申请单号：</label>
                <input name="purchaseSaleCode" class="required" type="text" min="0"  autocomplete="off" size="30" alt="请输入采购申请单号"/>
            </p>
            <p>
                <label>生产厂家：</label>
                <input name="manufacturerName" class="required" type="text" autocomplete="off" size="30" alt="请输入生产厂家"/>
            </p>
            <p>
                <label>规格：</label>
                <input name="specification" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>单位：</label>
                <input name="units" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>装箱量：</label>
                <input name="packageNumber" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>我司上家销货单位：</label>
                <input name="saleCompany" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>我司或下家购货单位：</label>
                <input name="buyCompany" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>打款分类：</label>
                <input name="paymentCategory" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>付款方式：</label>
                <input name="paymentMode" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>购进数量：</label>
                <input name="purchaseNumber" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>进项单价：</label>
                <input name="purchaseUnitPrice" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>进项金额：</label>
                <input name="purchaseMoney" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>应付税：</label>
                <input name="tax" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>付税方式：</label>
                <input name="taxPayMode" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>

            <p>
                <label>付税日期：</label>
                <input name="taxPayDate" class="required" type="date" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>发票号码：</label>
                <input name="invoiceNumber" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>开票日期：</label>
                <input name="invoiceDate" class="required" type="date" autocomplete="off" size="30" alt="请输入规格"/>
            </p>
            <p>
                <label>采购条目是否已核对：</label>
                <input name="ifCheck" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
            </p>

            <p>
                <input id="medicineName" name="medicineName" type="hidden" value="${medicines.size()>0?medicines[0].name:""}"/>
                <label>药品名称：</label>
                <select id="medicineUniqueCode" name="medicineUniqueCode" class="required" onchange="medicineChange()">
                    <c:forEach items="${medicines}" var="medicine">
                        <option value="${medicine.uniqueCode}">${medicine.name}[${medicine.lotNumber}]</option>
                    </c:forEach>
                </select>
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
