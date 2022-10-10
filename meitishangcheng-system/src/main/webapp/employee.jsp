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
    <h1><center>Welcome to MeiTiShangCheng System</center></h1>
    <span id="white"></span>
    <button class="button" onclick="add()"><span>ADD </span></button>
    <span id="user">
        ${manager.username}|<a href="login.jsp">Log out</a>
    </span>
    <hr>
<table border="1" cellspacing="0" width="1000" align="center">
    <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th class="address">员工住址</th>
        <th>小时工资</th>
        <th>所属部门</th>
        <th>工作班次</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${employee}" var="employee" varStatus="id">
        <tr>
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
                <a href="/meitishangcheng-system/employeeSelectById?id=${employee.id}">修改</a>
                <a href="/meitishangcheng-system/employeeDelete?id=${employee.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<script>
    function add(){
        location.href="add.jsp";
    }
</script>
