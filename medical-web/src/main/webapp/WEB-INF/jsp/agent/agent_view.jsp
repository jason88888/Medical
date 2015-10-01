<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="agent/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>代理商代码：</label>
                <input name="code" class="required" type="text" value="${agent.code}" autocomplete="off" size="30"
                       alt="请输入代理商代码" readonly/>
            </p>

            <p>
                <label>代理商姓名：</label>
                <input name="name" type="text" value="${agent.name}" autocomplete="off" size="30" alt="请输入代理商姓名"
                       readonly/>
            </p>

            <p>
                <label>代理级别</label>
                <input name="level" class="required" type="text" value="${agent.level}" autocomplete="off" size="30"
                       alt="请输入代理级别" readonly/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit"><a href="agent/edit?id=${agent.id}" target="dialog">编辑</a></button>
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
