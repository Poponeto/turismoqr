<%-- 
    Document   : PaginaAdministracion
    Created on : Sep 13, 2012, 10:37:56 AM
    Author     : ftacchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion TurismoQR</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosMapa.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Administracion.css">

        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();

                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.obtenerUbicacionUsuario(function(){
                    tqrmapas.crearMapa();
                    tqrmapas.crearNuevoMarcador("Posicion actual");
                });
            });
            
        </script>
    </head>
    <body style="margin: 0px;">
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <div id="contenedorMenu" class="ui-widget-header">
            <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
        </div>

        <div id="Contenedor" style="width: 100%; height: 450px; margin-top: 30px;">
            <div id="contenedorMapa"></div>
        </div>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosSlider.html" %>

    </body>
</html>
