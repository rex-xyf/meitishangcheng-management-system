<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <br>
    <span class="err_msg" id="false"><center>${registerFell}</center></span>
    <form id="reg-form" action="/meitishangcheng-system/managerRegister" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" style="display: none">用户名格式错误</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/meitishangcheng-system/userCheckCode">
                    <a href="register.jsp" target="_self" id="changeImg">换一张?</a>
                    <br>
                    <span id="code_err" class="err_msg" >${codeFell}</span>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>


<script>
    document.getElementById("checkCodeImg").onclick=function (){
        document.getElementById("checkCodeImg").src="/meitishangcheng-system/userCheckCode?"+new Date().getMilliseconds();
    }

    var usernameInput = document.getElementById("username");
    usernameInput.onblur= check1;
        function check1 () {
        var username=usernameInput.value.trim();
        var reg =/^\w{6,12}$/;
        var flag =reg.test(username);
        if (flag){
            document.getElementById("username_err").style.display="none";
        }
        else {
            document.getElementById("username_err").style.display="";
        }
            return flag;
    }


    var passwordInput = document.getElementById("password");
    passwordInput.onblur=check2;
        function check2() {
        var password=passwordInput.value.trim();
        var reg =/^.{6,12}$/;
        var flag =reg.test(password);
        if (flag ){
            document.getElementById("password_err").style.display="none";
        }
        else {
            document.getElementById("password_err").style.display="";
        }
            return flag;
    }

    // var telInput = document.getElementById("tel");
    // telInput.onblur=check3;
    // <!--script的函数调用不用（）-->
    //     function check3 () {
    //     var tel=telInput.value.trim();
    //     var reg = /^[1]\d{10}$/;
    //     var flag =reg.test(tel);
    //     if (flag){
    //         document.getElementById("tel_err").style.display="none";
    //     }
    //     else {
    //         document.getElementById("tel_err").style.display="";
    //     }
    //         return flag;
    // }
    
    var submit = document.getElementById("reg-form")
    submit.onsubmit=function () {
        var flag = check1()&&check2()//&&check3()
        if (flag){
            // alert("恭喜你注册成功，5秒内跳转登录页面")
            return flag
        }
        else{
            alert("格式有误请查看")
            return flag
        }
    }

</script>
</body>
</html>