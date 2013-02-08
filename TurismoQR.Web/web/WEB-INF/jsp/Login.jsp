<%-- 
    Document   : Login
    Created on : 24-ago-2012, 16:50:13
    Author     : Federico
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div>
            <form name="formularioDeLogin" action="<core:url value='loginUsuario'/>" method="POST">
                <div>
                    <div>
                        <table>
                            <tr>
                                <td>Usuario:</td>
                                <td><input id="lineaDatosUsuario" type='text' id='username' name='usuario'></td>
                            </tr>
                            <tr>
                                <td>Contraseña:</td>
                                <td><input id="lineaDatosPassword" type='password' name='password'></td>
                            </tr>
                            <tr>
                                <td><a id="recuperarContraseñaLink" href="#">¿Olvidaste tu contraseña?</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <input id="botonIniciarSesion" type="submit" value="Iniciar sesión" style="width: 100%;" />
            </form>
        </div>
    </body>
</html>
