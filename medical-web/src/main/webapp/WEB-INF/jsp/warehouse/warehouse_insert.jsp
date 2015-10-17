<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="warehouse/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>仓库编号：</label>
                <input name="code" class="required" type="text" autocomplete=" off" size="30" alt="请输入仓库编号"/>
            </p>

            <p>
                <label>仓库名称：</label>
                <input name="name" class="required" type="text" autocomplete=" off" size="30" alt="请输入仓库名称"/>
            </p>

            <p>
                <label>联系人员</label>
                <input name="linkMan" type="text" autocomplete=" off" size="30" alt="请输入联系人员"/>
            </p>

            <p>
                <label>联系电话：</label>
                <input name="telephone" type="text" autocomplete=" off" size="30" alt="请输入联系电话"/>
            </p>

            <p>
                <label>仓库地址</label>
                <input name="address" type="text" autocomplete=" off" cols="30" alt="请输入仓库地址"/>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" value="${warehouse.descript}" autocomplete=" off" cols="28"
                          alt="请输入备注"/>
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
