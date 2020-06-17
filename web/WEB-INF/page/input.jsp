<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/5/19
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Input</title>
  <%--  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js">
   --%>
</head>
<body>

    <form action="test.servlet" method="post">

        ProductName:<input type="text" name="productname"/>
        <br><br>

        ProductPasswd:<input type="text" name="productpasswd"/>
        <br><br>

        <input type="submit" value="提交">


    </form>
</body>
</html>
