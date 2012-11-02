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
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/Mapa.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Mapas.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/Administracion.css">

        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();
                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.crearMapa();
                   
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

        <div id="contenedorMapa"></div>


        <%@ include  file="/WEB-INF/jsp/Punto/TablaPuntos.jsp" %>
    </body>
</html>
