<%--
  Created by IntelliJ IDEA.
  User: ludy
  Date: 2019/7/29
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'Login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<form action="login.do" method="post">
    applicationCode:<input type="code" name="application code"/><br/>
    applicationName:<input type="name" name="application name"/><br/>
    applicationType:<input type="type" name="application type"/><br/>
    applicationDescription:<input type="description" name="application description"/><br/>
    <input type="submit" value="Login"/><input type="reset" value="reset"/>
</form>
</body>
</html>
