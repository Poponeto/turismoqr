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
            <form name="loginComoTurista" action="<core:url value='login/ingresarComoTurista.htm'/>" method="GET">
                <div>
                    <input id="botonIngresarComoTurista" type="submit" value="Ingresar como turista!" />
                </div>
            </form>
            <form name="crearPuntoDeInteres" action="<core:url value='/crearPunto/crearPuntoDeInteres.htm'/>" method="GET">
                <div>
                    <input type="submit" value="Crear Nuevo Punto De Interes" />
                </div>
            </form>
            <form name="formularioDeLogin" action="<core:url value='loginUsuario'/>" method="POST">
                <div>
                    <div>
                        Username:
                        <input id="lineaDatosUsuario" type='text' id='username' name='usuario'>
                    </div>
                    <div>
                        Password:
                        <input id="lineaDatosPassword" type='password' name='password'>
                    </div>
                </div>
                <input id="botonIniciarSesion" type="submit" value="Iniciar sesión" />
            </form>
        </div>
    </body>
</html>
