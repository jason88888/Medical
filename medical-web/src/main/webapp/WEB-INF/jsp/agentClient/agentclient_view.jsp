<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="pageContent">
    <form method="post" action="agentclient/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56" autocomplete="off">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <p>
                <label>代理商代码：</label>
                <input name="code" class="required" type="text" value="${agentclient.code}" autocomplete="off" size="30"
                       alt="请输入代理商代码" readonly/>
            </p>

            <p>
                <label>代理商名称：</label>
                <input name="name" class="required" type="text" value="${agentclient.name}" autocomplete="off" size="30" alt="请输入代理商名称"
                       readonly/>
            </p>

            <p>
                <label>英文名</label>
                <input name="engName"  type="text" value="${agentclient.engName}" autocomplete="off" size="30"
                       alt="请输入英文名" readonly/>
            </p>

            <p>
                <label>地区</label>
                <input name="areaName"  type="text" value="${agentclient.areaName}" autocomplete="off" size="30"
                       alt="请输入地区" readonly/>
            </p>

            <p>
                <label>负责人</label>
                <input name="chiefName"  type="text" value="${agentclient.chiefName}" autocomplete="off" size="30"
                       alt="请输入负责人" readonly/>
            </p>

            <p>
                <label>传真</label>
                <input name="faxNo"  type="text" value="${agentclient.faxNo}" autocomplete="off" size="30"
                       alt="请输入传真" readonly/>
            </p>

            <p>
                <label>联系电话</label>
                <input name="telephone"  type="text" value="${agentclient.telephone}" autocomplete="off" size="30"
                       alt="请输入联系电话" readonly/>
            </p>

            <p>
                <label>代理级别</label>
                <input name="level"  type="text" value="${agentclient.level}" autocomplete="off" size="30"
                       alt="请输入代理级别" readonly/>
            </p>

            <p>
                <label>谁的客户</label>
                <input name="whoseClient"  type="text" value="${agentclient.whoseClient}" autocomplete="off" size="30"
                       alt="请输入谁的客户" readonly/>
            </p>

            <p>
                <label>采购销售区域</label>
                <input name="saleArea"  type="text" value="${agentclient.saleArea}" autocomplete="off" size="30"
                       alt="请输入采购销售区域" readonly/>
            </p>
            <p>
                <label>备注</label>
                <textarea name="attribution"  type="text" autocomplete="off" cols="28" alt="请输入备注" readonly>${agentclient.descript}</textarea>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit"><a href="agentclient/edit?id=${agentclient.id}" target="dialog">编辑</a></button>
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
