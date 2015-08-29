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
//注意action地址，还有enctype要写成multipart/form-data，和method="POST"
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

<form method="POST" enctype="multipart/form-data"
      action="excel/upload">
  File to upload: <input type="file" name="file"><br /> Name: <input
        type="text" name="name"><br /> <br /> <input type="submit"
                                                     value="Upload"> Press here to upload the file!
</form>
</body>
</html>