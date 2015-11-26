<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="agent/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>代理商代码：</label>
                <input name="code" class="required textInput valid" type="text" autocomplete="off" size="30" alt="请输入代理商代码"/>
            </p>

            <p>
                <label>代理商姓名：</label>
                <input name="name" type="text" autocomplete="off" size="30" alt="请输入代理商姓名"/>
            </p>

            <p>
                <label>代理级别</label>
                <select name="level">
                    <option value="2" <c:if test='${level == "2"}'>selected="selected"</c:if>>2</option>
                    <option value="3" <c:if test='${level == "3"}'>selected="selected"</c:if>>3</option>
                </select>
            </p>
            <p>
                <label>备注</label>
                <textarea name="descript"  type="text" autocomplete="off" cols="28" alt="请输入备注"/>
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
