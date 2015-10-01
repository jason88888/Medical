<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="client/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <input type="hidden" name="id" value="${client.id}"/>
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>客户编码：</label>
                <input name="code" class="required" type="text" value="${client.code}" autocomplete="off" size="30" alt="请输入客户编码" readonly/>
            </p>
            <p>
                <label>医院名称：</label>
                <input name="name" class="required" type="text" value="${client.name}" autocomplete="off" size="30" alt="请输入医院名称" readonly/>
            </p>
            <p>
                <label>区域名称</label>
                <input name="regional" type="text" value="${client.regional}" autocomplete="off" size="30" alt="请输入区域名称" readonly/>
            </p>
            <p>
                <label>商业类型：</label>
                <input name="businessType" type="text" value="${client.businessType}" autocomplete="off" size="30" alt="请输入商业类型" readonly/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit"><a href="client/edit?id=${client.id}" target="dialog">编辑</a></button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
