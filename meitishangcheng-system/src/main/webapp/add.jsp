<%--
  Created by IntelliJ IDEA.
  User: v
  Date: 2022/4/16
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <link rel="stylesheet" href="css/styleForChange.css">
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">ADD</div>
        <div class="form-wrapper">
            <form action="/meitishangcheng-system/employeeAdd" method="post">
                <input type="text" name="name" placeholder="name" class="input-item">
                <input type="text" name="address" placeholder="address" class="input-item">
                <input type="text" name="hourWages" placeholder="hourWages" class="input-item">
                <input type="text" name="department" placeholder="department" class="input-item">
                <input type="text" name="workShifts" placeholder="workShifts" class="input-item">
                <input hidden type="text" name="page" value="<%=request.getParameter("page")%>">
                <input type="submit" class="btn" value="Add">
            </form>
        </div>
    </div>
</div>
</body>
</html>
