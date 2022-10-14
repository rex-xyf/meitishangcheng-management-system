<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: v
  Date: 2022/4/17
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>update</title>
    <link rel="stylesheet" href="css/styleForChange.css">
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">Update</div>
        <div class="form-wrapper">
            <form action="/meitishangcheng-system/employeeUpdate?id=${employee.id}" method="post">
                <input type="text" name="name" placeholder="name" class="input-item" value="${employee.name}">
                <input type="text" name="address" placeholder="address" class="input-item" value="${employee.address}">
                <input type="text" name="hourWages" placeholder="hourWages" class="input-item" value="${employee.hourWages}">
                <input type="text" name="department" placeholder="department" class="input-item" value="${employee.department}">
                <input type="text" name="workShifts" placeholder="workShifts" class="input-item" value="${employee.workShifts}">
                <input type="text" value="<%=request.getAttribute("page")%>" hidden name="page">
                <input type="submit" class="btn" value="update">
            </form>
        </div>
    </div>
</div>
</body>
</html>
