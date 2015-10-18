<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="policy/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="id" value="${policy.id}"/>
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <p>
                <label>所属区域：</label>
                <select name="regional">
                    <option value="杭州市" <c:if test='${policy.regional == "杭州市"}'>selected="selected"</c:if>>杭州市</option>
                    <option value="湖州市" <c:if test='${policy.regional == "湖州市"}'>selected="selected"</c:if>>湖州市</option>
                </select>
            </p>
            <p>
                <label>月份：</label>
                <input name="month" class="date valid" type="text" dateFmt="yyyy/MM" value="${policy.month}" readonly/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>
            <p>
                <label>所属药品：</label>
                <input name="medicineCode" type="hidden" value="${policy.medicineCode}"/>
                <input name="medicine.code" type="hidden" value="${policy.medicineCode}"/>
                <input type="text" class="required" name="medicine.name" rel="lookup" value="" postField="name" suggestFields="name,code" suggestUrl="medicine/lookup_suggest" lookupGroup="medicine" />
                <a class="btnLook" href="medicine/lookup" lookupGroup="medicine">查找带回</a>
            </p>
            <p>
                <label>客户名称：</label>
                <input name="clientCode" type="hidden" value="${policy.clientCode}"/>
                <input name="client.code" type="hidden" value="${policy.clientCode}"/>
                <input type="text" class="required" name="client.name" rel="lookup" value="" postField="name" suggestFields="name,code" suggestUrl="client/lookup_suggest" lookupGroup="client" />
                <a class="btnLook" href="client/lookup" lookupGroup="client">查找带回</a>
            </p>
            <p>
                <label>单价：</label>
                <input name="price" type="text" value="${policy.price}"/>
            </p>
            <div class="divider"></div>
            <p>
                <label>业务员政策：</label>
                <input name="salesmanPolicy" type="text" value="${policy.salesmanPolicy}"/>
            </p>
            <p>
                <label>临床政策：</label>
                <input name="clinicalPolicy" class="" type="text" value="${policy.clinicalPolicy}"/>
            </p>
            <p>
                <label>厂家政策：</label>
                <input name="manufacturerPolicy" class="" type="text" value="${policy.manufacturerPolicy}"/>
            </p>
            <div class="divider"></div>
            <p>
                <label>二级政策：</label>
                <input name="twoLevelPolicy" class="" type="text" value="${policy.twoLevelPolicy}"/>
            </p>
            <p>
                <label>三级政策：</label>
                <input name="threeLevelPolicy" class="" type="text" value="${policy.threeLevelPolicy}"/>
            </p>
            <div class="divider"></div>
            <p>
                <label>附加政策1：</label>
                <input name="addPolicy1" class="" type="text" value="${policy.addPolicy1}"/>
            </p>
            <p>
                <label>附加政策2：</label>
                <input name="addPolicy2" class="" type="text" value="${policy.addPolicy2}"/>
            </p>
            <p>
                <label>附加政策3：</label>
                <input name="addPolicy3" class="" type="text" value="${policy.addPolicy3}"/>
            </p>
            <p>
                <label>备注</label>
                <textarea name="descript"  type="text" autocomplete="off" cols="28" alt="请输入备注">${policy.descript}</textarea>
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
