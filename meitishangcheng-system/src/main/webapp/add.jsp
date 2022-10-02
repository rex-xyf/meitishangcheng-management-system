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
</head>
<body>
    <form action="/meitishangcheng-system/employeeAdd" method="post">
        请输入员工姓名：<input type="text" name="name"><br>
        请输入员工住址：<input type="text" name="address"><br>
        请输入小时工资：<input type="text" name="hourWages"><br>
        请输入所属部门：<input type="text" name="department"><br>
        请输入工作班次：<input type="text" name="workShifts"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
