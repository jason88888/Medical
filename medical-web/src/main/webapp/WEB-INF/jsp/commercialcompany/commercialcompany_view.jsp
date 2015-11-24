<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="commercialcompany/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>代理商代码：</label>
                <input name="code" class="required" type="text" value="${commercialcompany.code}" autocomplete="off" size="30" readonly/>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="name" class="required" type="text" value="${commercialcompany.name}" autocomplete="off" size="30" readonly/>
            </p>

            <p>
                <label>英文名</label>
                <input name="engName" type="text" value="${commercialcompany.engName}" autocomplete="off" size="30" readonly/>
            </p>

            <p>
                <label>地区</label>
                <input name="areaName" type="text" value="${commercialcompany.areaName}" autocomplete="off" size="30"  readonly/>
            </p>

            <p>
                <label>负责人</label>
                <input name="chiefName" type="text" value="${commercialcompany.chiefName}" autocomplete="off" size="30"  readonly/>
            </p>

            <p>
                <label>传真</label>
                <input name="faxNo" type="text" value="${commercialcompany.faxNo}" autocomplete="off" size="30"  readonly/>
            </p>

            <p>
                <label>联系电话</label>
                <input name="telephone" type="text" value="${commercialcompany.telephone}" autocomplete="off" size="30"  readonly/>
            </p>


            <p>
                <label>采购销售区域</label>
                <input name="saleArea" type="text" value="${commercialcompany.saleArea}" autocomplete="off" size="30" readonly/>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" autocomplete="off" cols="28" readonly>${commercialcompany.descript}</textarea>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit"><a href="commercialcompany/edit?id=${commercialcompany.id}" target="dialog" width="800" height="400">编辑</a>
                            </button>
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
