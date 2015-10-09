<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
  function clientChange(){
    var value = $("#clientCode").find("option:selected").text();
    $("#clientName").val(value);
  }
  function salesmanChange(){
    var value = $("#userCode").find("option:selected").text();
    $("#userName").val(value);
  }
  function medicineChange(){
    var value = $("#medicineCode").find("option:selected").text();
    $("#medicineName").val(value);
  }

</script>

<div class="pageContent">
  <form method="post" action="bill/save" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <div class="pageFormContent" layoutH="56" autocomplete="off">
      <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
      <p>
        <label>单据编号：</label>
        <input name="code" type="text" size="30" class="required" />
      </p>
      <p>
        <label>开票日期：</label>
        <input name="date" class="date" type="text" readonly="true"/>
        <a class="inputDateButton" href="javascript:;">选择</a>
      </p>
      <p>
        <label>数量：</label>
        <input name="number" class="required" type="number" min="0"  autocomplete="off" size="30" alt="请输入药品数量"/>
      </p>
      <p>
        <label>客户名称：</label>
        <input id="clientName" name="clientName" type="hidden" value="${clients.size()>0?clients[0].name:""}"/>
        <select id="clientCode" name="clientCode" class="required" style="width: 220px" onchange="clientChange()">
          <c:forEach items="${clients}" var="client">
            <option value="${client.code}">${client.name}</option>
          </c:forEach>
        </select>
      </p>

      <c:choose>
        <c:when test="${user.getRole() == 1}">
          <p>
            <input id="userName" name="userName" type="hidden" value="${salesmen.size()>0?salesmen[0].username:""}"/>
            <label>业务员姓名：</label>
            <select id="userCode" name="userCode" class="required" onchange="salesmanChange()">
              <c:forEach items="${salesmen}" var="salesman">
                <option value="${salesman.code}">${salesman.username}</option>
              </c:forEach>
            </select>
          </p>
        </c:when>
        <c:otherwise>
          <input name="userName" type="hidden" value="${user.username}" />
          <input name="userCode" type="hidden" value="${user.code}" />
        </c:otherwise>

      </c:choose>

      <p>
        <input id="medicineName" name="medicineName" type="hidden" value="${medicines.size()>0?medicines[0].name:""}"/>
        <label>药品名称：</label>
        <select id="medicineCode" name="medicineCode" class="required" onchange="medicineChange()">
          <c:forEach items="${medicines}" var="medicine">
            <option value="${medicine.code}">${medicine.name}[${medicine.lotNumber}]</option>
          </c:forEach>
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
        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
        <li>
          <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
        </li>
      </ul>
    </div>
  </form>
</div>
