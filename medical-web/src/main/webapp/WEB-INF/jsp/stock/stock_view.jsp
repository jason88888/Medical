<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="stock/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${stock.id}"/>
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>药品名称：</label>
                <input name="code" class="required" type="text" value="${stock.medicineName}" autocomplete="off" size="30" alt="请输入供应商编号" readonly/>
            </p>
            <p>
                <label>仓库名称：</label>
                <input name="name" class="required" type="text" value="${stock.warehouseName}" autocomplete="off" size="30" alt="请输入供应商名称" readonly/>
            </p>
            <p>
                <label>现有数量</label>
                <input name="areaName" type="text" value="${stock.nowQuantity}" autocomplete="off" size="30" alt="请输入地区" readonly/>
            </p>
            <p>
                <label>备注</label>
                <textarea name="descript"  type="text" autocomplete="off" cols="28" alt="请输入备注" readonly>${stock.descript}</textarea>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <%--<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><a href="stock/edit?id=${stock.id}" target="dialog">编辑</a></button></div></div></li>--%>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
