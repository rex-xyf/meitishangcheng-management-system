<%--
  Created by IntelliJ IDEA.
  User: v
  Date: 2022/10/10
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>register</title>
    <link rel="stylesheet" href="css/styleForSign.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
</head>
<body>

<form action="/meitishangcheng-system/managerRegister" class="login-form" method="post">
    <h1>Sign Up</h1>
    <span class="error"><center>${registerFell}</center></span>

    <div class="txt">
        <input type="text" name="username" required oninvalid="setCustomValidity('Please input a username');" oninput="setCustomValidity('');" value="${registerUsername}">
        <span data-placeholder="Username"></span>
    </div>

    <div class="txt">
        <input type="password" name="password" required oninvalid="setCustomValidity('Please input a password');" oninput="setCustomValidity('');" value="${registerPassword}">
        <span data-placeholder="Password"></span>
    </div>

    <div class="txt">
        <input type="text" name="email" required oninvalid="setCustomValidity('Please input an e-mail address');" oninput="setCustomValidity('');" value="${registerEmail}">
        <span data-placeholder="E-mail"></span>
    </div>

    <div class="txt" >
        <input type="text" name="code" >
        <span data-placeholder="Verification Code"></span>
    </div>

    <input type="submit" class="signup" value="Get verification code" id="code" formaction="http://localhost:8080/meitishangcheng-system/userCheckCode">
    <input type="submit" class="signup" value="Sign up">

    <div class="bottom-text">
        Have an account? <a href="login.jsp">Login</a>
    </div>

</form>

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
