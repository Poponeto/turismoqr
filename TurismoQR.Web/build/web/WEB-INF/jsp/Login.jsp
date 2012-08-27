<%-- 
    Document   : Login
    Created on : 24-ago-2012, 16:50:13
    Author     : Federico
--%>

<%@taglib prefix="core" uri="http://java.sun.com/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div>
            <form:form commandName="login" method="POST" name="login">
                Username: <form:input path="username"/>
                Password: <form:password path="password"/>
            </form:form>
        </div>
    </body>
</html>
