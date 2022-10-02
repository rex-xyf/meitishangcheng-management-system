<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>登录</h1>
        <span>没有账号？</span> <a href="register.jsp">注册</a>
    </div>
    <br>
    <span class="err_msg" id="false"><center>${fell}</center></span>

    <form id="reg-form" action="/meitishangcheng-system/managerSelect" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username" value="${cookie.username.value}">
                    <br>
<!--                    <span id="username_err" class="err_msg" style="display: none">用户名格式错误</span>-->
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password" value="${cookie.password.value}">
                    <br>
<!--                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>-->
                </td>
            </tr>

            <tr>
                <td>记住我</td>
                <td>
                    <input type="checkbox" id="remember" name="remember" value="1" checked>
                </td>
            </tr>
<!--            <tr>-->
<!--                <td>手机号</td>-->
<!--                <td class="inputs"><input name="tel" type="text" id="tel">-->
<!--                    <br>-->
<!--&lt;!&ndash;                    <span id="tel_err" class="err_msg" style="display: none">手机号格式有误</span>&ndash;&gt;-->
<!--                </td>-->
<!--            </tr>-->

        </table>

        <div class="buttons">
            <input value="登 陆" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>


<script>


</script>
</body>
</html>