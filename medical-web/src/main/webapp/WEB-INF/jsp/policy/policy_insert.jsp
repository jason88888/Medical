<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="policy/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <p>
                <label>所属区域：</label>
                <select name="regional">
                    <option value="杭州市" selected>杭州市</option>
                    <option value="湖州市">湖州市</option>
                </select>
            </p>
            <p>
                <label>月份：</label>
                <input name="month" class="date valid" type="text" dateFmt="yyyy/MM" readonly/>
                <a class="inputDateButton" href="javascript:;">选择</a>
            </p>
            <p>
                <label>所属药品：</label>
                <input name="medicineCode" type="text"/>
            </p>
            <p>
                <label>客户代码：</label>
                <input name="clientCode" type="text"/>
            </p>
            <p>
                <label>单价：</label>
                <input name="price" type="text"/>
            </p>
            <div class="divider"></div>
            <p>
                <label>业务员政策：</label>
                <input name="salesmanPolicy" class="" type="text"/>
            </p>
            <p>
                <label>临床政策：</label>
                <input name="clinicalPolicy" class="" type="text"/>
            </p>
            <p>
                <label>厂家政策：</label>
                <input name="manufacturerPolicy" class="" type="text"/>
            </p>
            <div class="divider"></div>
            <p>
                <label>二级政策：</label>
                <input name="twoLevelPolicy" class="" type="text"/>
            </p>
            <p>
                <label>三级政策：</label>
                <input name="threeLevelPolicy" class="" type="text"/>
            </p>
            <div class="divider"></div>
            <p>
                <label>附加政策1：</label>
                <input name="addPolicy1" class="" type="text"/>
            </p>
            <p>
                <label>附加政策2：</label>
                <input name="addPolicy2" class="" type="text"/>
            </p>
            <p>
                <label>附加政策3：</label>
                <input name="addPolicy3" class="" type="text"/>
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
