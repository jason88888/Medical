<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="medicine/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${medicine.id}"/>
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>药品编码：</label>
                <input name="code" class="required" type="text" size="30" value="${medicine.code}"/>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="name" class="required" type="text" value="${medicine.name}" autocomplete="off" size="30"
                       alt="请输入药品名称"/>
            </p>

            <p>
                <label>药品规格：</label>
                <input name="specification" type="text" value="${medicine.specification}" autocomplete="off" size="30"
                       alt="请输入药品规格"/>
            </p>

            <p>
                <label>生产厂商名称：</label>
                <input name="manufacturerName" type="text" value="${medicine.manufacturerName}" autocomplete="off" size="30" alt="请输入生产厂商名称"/>
            </p>

            <p>
                <label>单位：</label>
                <input name="units" type="text" value="${medicine.units}" autocomplete="off" size="30" alt="请输入单位"/>
            </p>

            <p>
                <label>单价：</label>
                <input name="price" class="required" type="text" value="${medicine.price}" autocomplete="off" size="30" alt="请输入单价"/>
            </p>

            <p>
                <label>药品批号：</label>
                <input name="lotNumber" class="required" type="text" value="${medicine.lotNumber}" autocomplete="off" size="30" alt="请输入药品批号"/>
            </p>

            <p>
                <label>有效期：</label>
                <input name="validityPeriod" type="text" value="${medicine.validityPeriod}" autocomplete="off" size="30" alt="请输入有效期"/>
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
