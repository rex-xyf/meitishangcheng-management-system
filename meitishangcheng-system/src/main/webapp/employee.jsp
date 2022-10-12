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
    <div class="top">
        <span class="welcome"><img src="img/logo.png"></span>
        <span class="user">${manager.username} | <a href="login.jsp">Log out</a></span>
        <span class="userPhoto"><img src="img/user.png"></span>
    </div>
    <div class="bottom">
    <div class="bar">
        <a href="http://localhost:8080/meitishangcheng-system/employeeSelectAll">Employee</a>
        <a href="#">Stock</a>
        <a href="#">Information</a>
    </div>
    <div class="table">
    <form action="/meitishangcheng-system/employeeDeleteByIds" method="post">
<%--    <span id="white"></span>--%>
    <button class="button" type="button" onclick="add()"><span>ADD </span></button>
    <button class="button" id="delete" type="submit"><span>DeleteAll </span></button>
    <select class="selected" name="selected" >
        <option value="name" ${selectName}>name</option>
        <option value="address" ${selectAddress}>address</option>
        <option value="hourWages" ${selectHourWages}>hourWages</option>
        <option value="department" ${selectDepartment}>department</option>
        <option value="workShifts" ${selectWorkShifts}>workShifts</option>
    </select>
    <input type="text" name="text" class="text" placeholder="Please enter to search..." value="${text}">
    <input type="submit"  class="submit" formaction="http://localhost:8080/meitishangcheng-system/employeeSelect" value="Search">
    <hr>
    <table border="1" cellspacing="0" width="1000" align="center">
    <tr>
        <th>check</th>
        <th class="id">noun</th>
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
    </div>
    </div>
</body>
</html>

<script>
    function add(){
        location.href="add.jsp";
    }
</script>
