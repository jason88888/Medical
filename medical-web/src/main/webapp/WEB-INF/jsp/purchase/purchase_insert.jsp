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
                <input name="purchasePayDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<input name="invoiceDate" type="text" autocomplete="off" size="30" alt="请输入开票日期"/>--%>
            </p>
            <p>
                <label>采购入库日期：</label>
                <input name="purchaseStoreDate" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <%--<input name="invoiceDate" type="text" autocomplete="off" size="30" alt="请输入开票日期"/>--%>
            </p>
            <p>
                <label>实际入库地点：</label>
                <input name="actualStorePlace" class="required" type="text" autocomplete="off" size="30" alt="请选择实际入库地点"/>
            </p>
            <p>
                <label>采购申请单号：</label>
                <input name="purchaseSaleCode" class="required" type="text" min="0"  autocomplete="off" size="30" alt="请输入采购申请单号"/>
            </p>
            <p>
                <label>购进数量：</label>
                <input name="purchaseNumber" class="required" type="text" autocomplete="off" size="30" alt="请输入规格"/>
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
