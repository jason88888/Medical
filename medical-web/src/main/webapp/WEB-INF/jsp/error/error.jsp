<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="alertMsgBox" class="alert" style="top: 0px;">
    <div class="alertContent">
        <div class="error">
            <div class="alertInner"><h1>错误提示</h1>

                <div class="msg">${msg}</div>
            </div>
            <div class="toolBar">
                <ul>
                    <li><a class="button" rel="" onclick="alertMsg.close()" href="javascript:"><span>OK</span></a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="alertFooter">
        <div class="alertFooter_r">
            <div class="alertFooter_c"></div>
        </div>
    </div>
    <input type="text" style="width: 0px; height: 0px; display: none;" name="_alertFocusCtr">
</div>