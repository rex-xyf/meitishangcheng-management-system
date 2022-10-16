<%--
  Created by IntelliJ IDEA.
  User: v
  Date: 2022/10/9
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
</head>
<body>

<form action="/meitishangcheng-system/managerSelect" class="login-form" method="post">
    <h1>Log In</h1>
    <span class="error"><center>${fell}</center></span>

    <div class="txt">
        <input type="text" name="username" required oninvalid="setCustomValidity('Please input a username');" oninput="setCustomValidity('');" maxlength="12" value="${cookie.username.value}">
        <span data-placeholder="Username"></span>
    </div>

    <div class="txt">
        <input type="password" name="password" required oninvalid="setCustomValidity('Please input a password');" oninput="setCustomValidity('');" maxlength="12" value="${cookie.password.value}">
        <span data-placeholder="Password"></span>
    </div>

    <div class="img">
        <input type="text" name="code" class="code" placeholder=" CAPTCHA" required oninvalid="setCustomValidity('Please input a Captcha');" maxlength="4" oninput="setCustomValidity('');">
        <img class="checkCodeImg" id="checkCodeImg" src="/meitishangcheng-system/loginCheckCode">
    </div>

    <div class="check">
        <span class="remember">Remember Me</span><input type="checkbox" id="remember" name="remember" value="1" checked>
    </div>


    <input type="submit" class="login" value="Log In">

    <div class="bottom-text">
        <a href="register.jsp">Sign up</a>
        |
        <a href="forget.jsp">forget?</a>
    </div>

</form>
<script>
    document.getElementById("checkCodeImg").onclick=function (){
        document.getElementById("checkCodeImg").src="/meitishangcheng-system/loginCheckCode?"+new Date().getMilliseconds();
    }
</script>
<script type="text/javascript">
    $(".txt input").on("focus", function(){
        $(this).addClass("focus");
    });

    $(".txt input").on("blur", function(){
        if($(this).val() == "")
            $(this).removeClass("focus");
    });
</script>

</body>
</html>
