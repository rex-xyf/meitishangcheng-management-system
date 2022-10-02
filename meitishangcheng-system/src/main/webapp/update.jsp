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
    <title>修改</title>
</head>
<body>
<form action="/meitishangcheng-system/employeeUpdate?id=${employee.id}" method="post">
    请修改员工姓名：<input type="text" name="name" value="${employee.name}"><br>
    请修改员工住址：<input type="text" name="address" value="${employee.address}"><br>
    请修改小时工资：<input type="text" name="hourWages" value="${employee.hourWages}"><br>
    请修改所属部门：<input type="text" name="department" value="${employee.department}"><br>
    请修改工作班次：<input type="text" name="workShifts" value="${employee.workShifts}"><br>
<%--    请修改状态：--%>
<%--    <c:if test="${Employee.state == 1}">--%>
<%--    <input type="radio" name="state" id="1" value="1" checked><label for="1">启用</label>--%>
<%--    <input type="radio" name="state" id="0" value="0"><label for="0">禁用</label>--%>
<%--    </c:if>--%>
<%--    <c:if test="${Employee.state == 0}">--%>
<%--        <input type="radio" name="state" id="1" value="1"><label for="1">启用</label>--%>
<%--        <input type="radio" name="state" id="0" value="0" checked><label for="0">禁用</label>--%>
<%--    </c:if>--%>
<%--    <br>--%>
    <input type="submit" value="提交">
</form>
</body>
</html>
