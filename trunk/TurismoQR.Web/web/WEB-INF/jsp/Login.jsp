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
        <form name="formularioDeLogin" action="<core:url value='login'/>" method="POST">
            <div>
                Ingresar como Turista!
            </div>
            <div>
                <div>
                    Username:
                    <input type='text' id='username' name='usuario'>
                </div>
                <div>
                    Password:
                    <input type='password' name='password'>
                </div>
            </div>
            <input type="submit" value="Iniciar sesión" />
        </form>
    </body>
</html>
