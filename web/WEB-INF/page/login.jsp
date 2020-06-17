<%--
  Created by IntelliJ IDEA.
  User: TianJun
  Date: 2020/6/15
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

    <form action="login.servlet" method="post">

            用户名:<input type="text" name="username"/>
            <br><br>

            密码:<input type="text" name="password"/>
            <br><br>

            <input type="submit" value="提交">
</body>
</html>
