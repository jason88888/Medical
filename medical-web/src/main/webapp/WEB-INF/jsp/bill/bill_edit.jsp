<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="pageContent">
  <form method="post" action="bill/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);" autocomplete="off">
    <input type="hidden" name="id" value="${bill.id}"/>
    <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
    <div class="pageFormContent" layoutH="56">
      <p>
        <label>单据编号：</label>
        <input name="code" type="text" size="30" class="required" value="${bill.code}" readOnly="true" />
      </p>
      <p>
        <label>开票日期：</label>
        <input name="date" class="date" type="text"/>
        <a class="inputDateButton" href="javascript:;">选择</a>
      </p>
      <p>
        <label>数量：</label>
        <input name="number" class="required" type="number" min="0"  autocomplete="off" size="30" value="${bill.number}" alt="请输入药品数量"/>
      </p>

      <p>
        <label>客户名称：</label>
        <input name="clientCode" type="hidden" value="${bill.clientCode}"/>
        <input name="client.code" type="hidden" value="${bill.clientCode}"/>
        <input type="text" class="required" value="${bill.clientName}" name="client.name" rel="lookup" value="" postField="name"
               suggestFields="name,code" suggestUrl="client/lookup_suggest" lookupGroup="client"/>
        <a class="btnLook" href="client/lookup" lookupGroup="client">查找带回</a>
      </p>

      <p>
        <label>业务员姓名：</label>
        <input name="userCode" type="hidden" value="${user.code}"/>
        <input name="user.code" type="hidden" value="${user.code}"/>
        <input type="text" class="required" value="${bill.userName}" name="user.username" rel="lookup" value="" postField="username" suggestFields="username,code" suggestUrl="user/lookup_suggest" lookupGroup="user" />
        <a class="btnLook" href="user/lookup" lookupGroup="medicine">查找带回</a>
      </p>

      <p>
        <label>所属药品：</label>
        <input name="medicineCode" type="hidden" value="${bill.medicineCode}"/>
        <input name="medicine.code" type="hidden" value="${bill.medicineCode}"/>
        <input type="text" class="required" value="${bill.medicineName}" name="medicine.name" rel="lookup" value="" postField="name" suggestFields="name,code" suggestUrl="medicine/lookup_suggest" lookupGroup="medicine" />
        <a class="btnLook" href="medicine/lookup" lookupGroup="medicine">查找带回</a>
      </p>

      <p>
        <label>备注</label>
        <textarea name="descript"  type="text" autocomplete="off" cols="28" alt="请输入备注">${bill.descript}</textarea>
      </p>
    </div>
    <div class="formBar">
      <ul>
        <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
        <li>
          <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
        </li>
      </ul>
    </div>
  </form>
</div>
