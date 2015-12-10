<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pageContent">
    <form method="post" action="cgsqorder/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${cgsqorder.id}"/>
            <p>
                <label>采购申请单编号：</label>
                <input name="code" type="text" size="30" class="required" value="${cgsqorder.code}"/>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineId" type="hidden" value="${cgsqorder.medicineId}"/>
                <input name="medicine.id" type="hidden" value="${cgsqorder.medicineId}"/>
                <input type="text" class="required" name="medicine.name" rel="lookup" value="${cgsqorder.medicineName}" postField="name"
                       suggestFields="name,code" suggestUrl="medicine/lookup_suggest" lookupGroup="medicine"/>
                <a class="btnLook" href="medicine/lookup" lookupGroup="medicine">查找带回</a>
            </p>

            <p>
                <label>操作人名称：</label>
                <input name="sysUserId" type="hidden" value="${cgsqorder.sysUserId}"/>
                <input name="user.id" type="hidden" value="${cgsqorder.sysUserId}"/>
                <input type="text" class="required" name="user.username" rel="lookup" value="${cgsqorder.operatorName}" postField="name"
                       suggestFields="name,code" suggestUrl="user/lookup_suggest" lookupGroup="user"/>
                <a class="btnLook" href="user/lookup" lookupGroup="user">查找带回</a>
            </p>

            <p>
                <label>供应商名称：</label>
                <input name="providerId" type="hidden" value="${cgsqorder.providerId}"/>
                <input name="provider.id" type="hidden" value="${cgsqorder.providerId}"/>
                <input type="text" class="required" name="agent.name" rel="lookup" value="${cgsqorder.providerName}" postField="name"
                       suggestFields="name,code" suggestUrl="provider/lookup_suggest" lookupGroup="provider"/>
                <a class="btnLook" href="provider/lookup" lookupGroup="provider">查找带回</a>
            </p>

            <p>
                <label>实际单价：</label>
                <input name="unitPrice" value="${cgsqorder.unitPrice}" type=" text" autocomplete="off" size="30"
                alt="请输入实际单价"/>
            </p>

            <p>
                <label>高开单价：</label>
                <input name="highUnitPrice" value="${cgsqorder.highUnitPrice}" type="text" autocomplete="off" size="30"
                       alt="请输入高开单价"/>
            </p>

            <p>
                <label>采购单价：</label>
                <input name="purchasePrice" type="text" value="${cgsqorder.purchasePrice}" autocomplete="off" size="30" alt="请输入采购单价"/>
            </p>

            <p>
                <label>付款金额：</label>
                <input name="purchasePrice" type="text" value="${cgsqorder.purchaseMoney}" autocomplete="off" size="30" alt="请输入付款金额"/>
            </p>

            <p>
                <label>应付税：</label>
                <input name="tax" type="text" value="${cgsqorder.tax}" autocomplete="off" size="30" alt="请输入应付税"/>
            </p>

            <p>
                <label>付税方式：</label>
                <input name="taxpayMode" type="text" value="${cgsqorder.taxpayMode}" autocomplete="off" size="30" alt="请输入付税方式"/>
            </p>

            <p>
                <label>付税日期：</label>
                <input name="storeDate" class="date" value="${cgsqorder.taxpayDate}" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" value="${cgsqorder.descript}" autocomplete="off" cols="28" alt="请输入备注"></textarea>
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

