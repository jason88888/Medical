<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="commercialcompany/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>代理商代码：</label>
                <input name="code" class="required" type="text" autocomplete="off" size="30"
                       alt="请输入代理商代码"/>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="name" class="required" type="text" autocomplete="off"
                       size="30" alt="请输入代理商名称"/>
            </p>

            <p>
                <label>英文名</label>
                <input name="engName" type="text"  autocomplete="off" size="30"
                       alt="请输入英文名"/>
            </p>

            <p>
                <label>地区</label>
                <input name="areaName" type="text"  autocomplete="off" size="30"
                       alt="请输入地区"/>
            </p>

            <p>
                <label>负责人</label>
                <input name="chiefName" type="text"  autocomplete="off" size="30"
                       alt="请输入负责人"/>
            </p>

            <p>
                <label>传真</label>
                <input name="faxNo" type="text" autocomplete="off" size="30"
                       alt="请输入传真"/>
            </p>

            <p>
                <label>联系电话</label>
                <input name="telephone" type="text"  autocomplete="off" size="30"
                       alt="请输入联系电话"/>
            </p>

            <p>
                <label>采购销售区域</label>
                <input name="saleArea" type="text"  autocomplete="off" size="30"
                       alt="请输入采购销售区域"/>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" autocomplete="off" cols="28"
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
