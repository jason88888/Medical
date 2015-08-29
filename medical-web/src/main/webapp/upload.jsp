<%--
  Created by IntelliJ IDEA.
  User: cclin
  Date: 15/8/28
  Time: 上午5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Insert title here</title>
</head>
<body>
<%--<form name="uploadform" method="POST" action="excel/upload" ENCTYPE="multipart/form-data">--%>

  <%--<table border="1" width="450" cellpadding="4" cellspacing="2" bordercolor="#9BD7FF">--%>
    <%--<tr>--%>
      <%--<td width="100%" colspan="2">--%>

        <%--文件：<input name="file" size="40" type="file">--%>

      <%--</td>--%>
    <%--</tr>--%>
  <%--</table>--%>
  <%--<br/><br/>--%>

  <%--<table>--%>
    <%--<tr><td align="center"><input name="upload" type="submit" value="开始上传"/></td></tr>--%>
  <%--</table>--%>

<%--</form>--%>
销售政策表<br>
<form method="POST" enctype="multipart/form-data"
      action="upload/policy">
  <input type="file" name="file"><br />
  <input type="submit" value="上传政策表">
</form>
<br/>
<br/>
<br/>
<br/>
<br/>
单据表<br>
<form method="POST" enctype="multipart/form-data"
      action="upload/bill">
  <input type="file" name="file"><br />
  <input type="submit" value="上传单据表">
</form>
</body>
</html>