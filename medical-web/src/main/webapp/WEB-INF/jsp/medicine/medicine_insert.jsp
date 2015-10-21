<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="medicine/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>药品代码：</label>
                <input name="uniqueCode" class="required" type="text" autocomplete="off" size="30" alt="请输入药品代码"/>
            </p>
            <p>
                <label>药品编码：</label>
                <input name="code" class="required" type="text" autocomplete="off" size="30" alt="请输入药品编码"/>
            </p>
            <p>
                <label>药品名称：</label>
                <input name="name" class="required" type="text" autocomplete="off" size="30" alt="请输入药品名称"/>
            </p>
            <p>
                <label>药品规格：</label>
                <input name="specification"  type="text" autocomplete="off" size="30" alt="请输入药品规格"/>
            </p>
            <p>
                <label>生产厂商名称：</label>
                <input name="manufacturerName"  type="text" autocomplete="off" size="30" alt="请输入生产厂商名称"/>
            </p>
            <p>
                <label>单位：</label>
                <input name="units"  type="text" autocomplete="off" size="30" alt="请输入单位"/>
            </p>
            <p>
                <label>中标单价：</label>
                <input name="bidPrice" class="required" type="text" autocomplete="off" size="30" alt="请输入中标单价"/>
            </p>
            <p>
                <label>药品批号：</label>
                <input name="lotNumber" class="required" type="text" autocomplete="off" size="30" alt="请输入药品批号"/>
            </p>
            <p>
                <label>有效期：</label>
                <input name="validityPeriod" class="date" type="text" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
                <span class="info">yyyy-MM-dd</span>
            </p>
            <p>
                <label>保质期：</label>
                <input name="shelfLife" class="required" type="text" autocomplete="off" size="30" alt="请输入保质期"/>
            </p>
            <p>
                <label>装箱数：</label>
                <input name="packageNumber" class="required" type="text" autocomplete="off" size="30" alt="请输入装箱数"/>
            </p>
            <p>
                <label>可做区域：</label>
                <input name="salesRange" class="required" type="text" autocomplete="off" size="30" alt="请输入可做区域"/>
            </p>
            <p>
                <label>备注</label>
                <textarea name="descript"  type="text" autocomplete="off" cols="28" alt="请输入备注"/>
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
