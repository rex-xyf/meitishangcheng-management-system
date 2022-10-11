<%--
  Created by IntelliJ IDEA.
  User: v
  Date: 2022/4/16
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有</title>
    <link rel="stylesheet" href="css/styleForMain.css">
</head>
<body>
    <form action="/meitishangcheng-system/employeeDeleteByIds" method="post">
    <h1><center>Welcome to MeiTiShangCheng System</center></h1>
    <span id="white"></span>
    <button class="button" type="button" onclick="add()"><span>ADD </span></button>
    <button class="button" type="submit"><span>DeleteAll </span></button>
    <span id="user">
        ${manager.username}|<a href="login.jsp">Log out</a>
    </span>
    <hr>
<table border="1" cellspacing="0" width="1000" align="center">
    <tr>
        <th>check</th>
        <th class="id">id</th>
        <th>name</th>
        <th class="address">address</th>
        <th>hour wages</th>
        <th>department</th>
        <th>work shifts</th>
        <th>operation</th>
    </tr>
    <c:forEach items="${employee}" var="employee" varStatus="id">
        <tr>
            <td><input type="checkbox" value="${employee.id}" name="select"></td>
            <td>${id.count}</td>
            <td>${employee.name}</td>
            <td>${employee.address}</td>
            <td>${employee.hourWages}</td>
            <td>${employee.department}</td>
            <td>${employee.workShifts}</td>
<%--            <td>--%>
<%--                <c:if test="${employees.state==1}">--%>
<%--                    启用--%>
<%--                </c:if>--%>
<%--                <c:if test="${employees.state!=1}">--%>
<%--                    禁用--%>
<%--                </c:if>--%>
<%--            </td>--%>
            <td>
                <a href="/meitishangcheng-system/employeeSelectById?id=${employee.id}">update</a>
                <a href="/meitishangcheng-system/employeeDelete?id=${employee.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
    </form>
</body>
</html>

<script>
    function add(){
        location.href="add.jsp";
    }
</script>
