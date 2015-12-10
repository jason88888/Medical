<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    function medicineChange() {
        var value = $("#medicineUniqueCode").find("option:selected").text();
        $("#medicineName").val(value);
    }

</script>

<div class="pageContent">
    <form method="post" action="xsthorder/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>销售出库单编号：</label>
                <input name="code" type="text" size="30" value="${xsthorder.code}" readonly/>
            </p>

            <p>
                <label>单据日期：</label>
                <input name="billDate" type="text" autocomplete="off" size="30" value="${xsthorder.billDate}"
                       alt="请选择单据日期" readonly/>
            </p>

            <p>
                <label>仓库名称：</label>
                <input name="warehouseId" type="text" autocomplete="off" size="30" value="${xsthorder.warehouseName}"
                       readonly/>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="text" autocomplete="off" size="30" value="${xsthorder.medicineName}"
                       readonly/>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="text" autocomplete="off" size="30" value="${xsthorder.operatorName}"
                       readonly/>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="agentId" type="text" autocomplete="off" size="30" value="${xsthorder.agentName}" readonly/>
            </p>

            <p>
                <label>购进商业公司名称：</label>
                <input name="commercialCompanyId" type="text" autocomplete="off" size="30"
                       value="${xsthorder.commercialCompanyName}" readonly/>
            </p>

            <p>
                <label>销售单价：</label>
                <input name="salePrice" type="text" autocomplete="off" size="30" value="${xsthorder.salePrice}"
                       readonly/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="saleMoney" type="text" autocomplete="off" size="30" value="${xsthorder.saleMoney}"
                       readonly/>
            </p>

            <p>
                <label>数量：</label>
                <input name="invoiceNumber" type="text" autocomplete="off" size="30" value="${xsthorder.quantity}"
                       readonly/>
            </p>

            <p>
                <label>备注：</label>
                <input name="invoiceDate" type="text" autocomplete="off" size="30" value="${xsthorder.descript}"
                       readonly/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <a href="xsthorder/edit?id=${xsthorder.id}" target="dialog" rel="form"
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
