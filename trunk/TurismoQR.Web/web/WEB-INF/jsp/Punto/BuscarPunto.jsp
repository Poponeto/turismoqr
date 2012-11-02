<%-- 
    Document   : BuscarPunto
    Created on : Sep 19, 2012, 3:12:43 PM
    Author     : ftacchini
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion TurismoQR</title>
        
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosMapa.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/BuscarPuntos.js"></script>

        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();

                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.obtenerUbicacionUsuario(function(){
                    tqrmapas.crearMapa();
                    tqrmapas.crearNuevoMarcador("Posicion actual");
                });

            });

            $(window).load(function() {
                inicializarPaginaBuscarPuntos("${pageContext.request.contextPath}/buscarPunto/obtenerInformacionTabla.htm", tqrmapas);
            });

        </script>
    </head>
    <body style="margin: 0px;">
        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <sec:authorize ifNotGranted="PERMISO_TURISTA">
            <div id="contenedorMenu" class="ui-widget-header">
                <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
            </div>
        </sec:authorize>

        <div id="contenedorMapa" style="position: absolute; width: 90%; margin-top: 30px; height: 400px;" ></div>

        <div id="contenedorTabla" style="position: absolute; margin-top: 30px;">
            <%@ include  file="/WEB-INF/jsp/Punto/TablaPuntos.jsp" %>
        </div>

    </body>
</html>
