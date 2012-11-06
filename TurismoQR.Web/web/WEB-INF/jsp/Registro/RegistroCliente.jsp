<%-- 
    Document   : RegistroCliente
    Created on : Sep 13, 2012, 12:36:15 PM
    Author     : ftacchini
--%>

<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-responsive.min.css">
        <!--[if lt IE 7]><link rel="stylesheet" href="http://blueimp.github.com/cdn/css/bootstrap-ie6.min.css"><![endif]-->
        <link rel="stylesheet" href="http://blueimp.github.com/Bootstrap-Image-Gallery/css/bootstrap-image-gallery.min.css">

        <script type="text/javascript">

            $(document).ready(function(){
                inicializarComponentes();

                $.get('${pageContext.request.contextPath}/${formularioCliente}', function(data) {
                    $('#contenedorFormularioCliente').html(data);
                });
            });
        </script>

        <style TYPE="text/css">
            input {
                width: 100%;
            }
        </style>

    </head>
    <body>
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="Contenedor">

            <form action=""  id="Contenido" style="padding: 30px;">
                
                <div id="contenedorFormularioCliente">
                </div>

                <fieldset>
                    <label for="cantidadDePuntosDeseados">
                        Cantidad de Puntos:<br>
                        <input id="lineaDatoscantidadDePuntosDeseados" name="cantidadDePuntosDeseados" type="text" required="false"/>
                    </label>
                    <br>
                </fieldset>

                <%@ include file = "/WEB-INF/jsp/Registro/FormularioContacto.jsp" %>

                <div>
                    <button id="botonRegistrarse">Registrarse</button>
                </div>

            </form>
        </div>
    </body>
</html>
