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
        <input name="date" class="required" type="date" autocomplete="off" size="30"  value="${bill.date}" readOnly="true"  alt="请选择开票日期"/>
      </p>
      <p>
        <label>数量：</label>
        <input name="number" class="required" type="number" min="0"  autocomplete="off" size="30" value="${bill.number}" readOnly="true" alt="请输入药品数量"/>
      </p>

      <p>
        <label>客户名称：</label>
        <input id="clientName" name="clientName" type="hidden"  value="${bill.clientName}" />
        <select id="clientCode" name="clientCode" class="required" style="width: 220px" onchange="clientChange()" >
          <c:forEach items="${clients}" var="client">
            <option value="${client.code}"  disabled <c:if test="${bill.clientCode == client.code}">selected </c:if>>${client.name}</option>
          </c:forEach>
        </select>
      </p>

      <c:choose>
        <c:when test="${user.getRole() == 1}">
          <p>
            <input id="userName" name="userName" type="hidden" value="${bill.userName}"/>
            <label>业务员姓名：</label>
            <select id="userCode" name="userCode" class="required"  onchange="salesmanChange()">
              <c:forEach items="${salesmen}" var="salesman">
                <option value="${salesman.code}" disabled <c:if test="${bill.userCode == salesman.code}">selected  </c:if>>${salesman.username}</option>
              </c:forEach>
            </select>
          </p>
        </c:when>
        <c:otherwise>
          <input name="userName" type="hidden" value="${bill.userName}" />
          <input name="userCode" type="hidden" value="${bill.userCode}" />
        </c:otherwise>

      </c:choose>


      <p>
        <input id="medicineName" name="medicineName" type="hidden" value="${bill.medicineName}"/>
        <label>药品名称：</label>
        <select id="medicineCode" name="medicineCode" class="required" onchange="medicineChange()" readOnly="true">
          <c:forEach items="${medicines}" var="medicine">
            <option value="${medicine.code}" <c:if test="${bill.medicineCode == medicine.code}">selected disabled</c:if>>${medicine.name}</option>
          </c:forEach>
        </select>
      </p>

    </div>
    <div class="formBar">
      <ul>
        <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
        <li>
          <div class="buttonActive">
            <div class="buttonContent">
              <button type="submit"><a href="bill/edit?id=${bill.id}" target="dialog">编辑</a></button>
            </div>
          </div>
        </li>
        <li>
          <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
        </li>
      </ul>
    </div>
  </form>
</div>
