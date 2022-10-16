<%--
  Created by IntelliJ IDEA.
  User: v
  Date: 2022/10/16
  Time: 10:32
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

<form action="/meitishangcheng-system/managerExist" class="login-form" id="forget" method="post">
    <h1>Retrieve Password</h1>
    <span class="error"><center>${findFell}</center></span>
    <div class="txt">
        <input type="text" name="username" required oninvalid="setCustomValidity('Please input a username');" oninput="this.value=this.value.replace(/[^\w_]/g,'');" maxlength="12" value="${forgetUsername}">
        <span data-placeholder="Username"></span>
    </div>

    <div class="txt">
        <input type="text" name="email" required oninvalid="setCustomValidity('Please input an e-mail address');" oninput="setCustomValidity('');" value="${forgetEmail}">
        <span data-placeholder="E-mail"></span>
    </div>

    <div class="txt" >
        <input type="text" name="code" maxlength="5">
        <span data-placeholder="Verification Code"></span>
    </div>

    <input type="submit" class="signup" value="Get verification code" id="code" formaction="http://localhost:8080/meitishangcheng-system/userFindCode">
    <input type="submit" class="signup" value="Send">

    <div class="bottom-text">
        Remember? <a href="login.jsp">Login</a>
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
