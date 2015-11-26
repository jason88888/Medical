<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="warehouse/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${warehouse.id}"/>
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>仓库编号：</label>
                <input name="code" class="required" type="text" value="${warehouse.code}" autocomplete=" off" size="30"
                       alt="请输入仓库编号"/>
            </p>

            <p>
                <label>仓库名称：</label>
                <input name="name" class="required" type="text" value="${warehouse.name}" autocomplete=" off" size="30"
                       alt="请输入仓库名称"/>
            </p>

            <p>
                <label>联系人员</label>
                <input name="areaName" type="text" value="${warehouse.linkMan}" autocomplete=" off" size="30"
                       alt="请输入联系人员"/>
            </p>

            <p>
                <label>联系电话：</label>
                <input name="chiefName" type="text" value="${warehouse.telephone}" autocomplete=" off" size="30"
                       alt="请输入联系电话"/>
            </p>

            <p>
                <label>仓库地址</label>
                <input name="faxNo" type="text" value="${warehouse.address}" autocomplete=" off" cols="28"
                       alt="请输入仓库地址"/>
            </p>

            <p>
                <label>仓库级别</label>
                <select name="warehouseLevel">
                    <option value="1" <c:if test='${warehouse.warehouseLevel == "1"}'>selected="selected"</c:if>>1</option>
                    <option value="2" <c:if test='${warehouse.warehouseLevel == "2"}'>selected="selected"</c:if>>2</option>
                </select>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" autocomplete=" off" cols="28"
                          alt="请输入备注">${warehouse.descript}</textarea>
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
