<%-- 
    Document   : InformacionPersonalUsuario
    Created on : 09-dic-2012, 15:55:34
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Personal del Usuario</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosError.html" %>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Fieldset.css">

        <script type="text/javascript" >
            $(document).ready(function(){

                inicializarComponentes();

            });

        </script>
    </head>
    <body>

        <p>
            Nombre de Usuario: ${usuario}
        </p>

        <button id="botonCambiarNombreUsuario">Cambiar Nombre de Usuario</button>
        <button id="botonCambiarContrasenia">Cambiar Contraseña</button>
    </body>
</html>
