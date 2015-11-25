<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="pageContent">
    <form method="post" action="bill/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);" autocomplete="off">
        <input type="hidden" name="id" value="${bill.id}"/>
        <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>单据编号：</label>
                <input name="code" type="text" size="30" class="required" value="${bill.code}" readOnly="true"/>
            </p>

            <p>
                <label>开票日期：</label>
                <input name="date" class="required" type="date" autocomplete="off" size="30" value="${bill.date}"
                       readOnly="true"/>
            </p>

            <p>
                <label>数量：</label>
                <input name="number" class="required" type="number" min="0" autocomplete="off" size="30"
                       value="${bill.number}" readOnly="true"/>
            </p>

            <p>
                <label>客户名称：</label>
                <input name="clientName" type="text" autocomplete="off" size="30" value="${bill.clientName}"
                       readOnly="true"/>
            </p>

            <p>
                <label>业务员姓名：</label>
                <input name="userName" type="text" autocomplete="off" size="30" value="${bill.userName}"
                       readOnly="true"/>
            </p>

            <p>
                <label>药品名称：</label>
                <input name="medicineName" type="text" autocomplete="off" size="30" value="${bill.medicineName}"
                       readOnly="true"/>
            </p>

            <p>
                <label>备注</label>
                <textarea name="descript" type="text" autocomplete="off" cols="28"
                          readonly>${bill.descript}</textarea>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <a href="bill/edit?id=${bill.id}" target="dialog" rel="form"
                                                     width="820" height="400">编辑</a>

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
