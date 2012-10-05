<%-- 
    Document   : InformacionPunto
    Created on : 04-sep-2012, 20:33:44
    Author     : Federico
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/Mapa.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="../Vistas/HojasDeEstilo/Mapas.css">
        <script type="text/javascript">
            $(document).ready(function(){
                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.lat = '<core:out value="${dtoPunto.localizacion.latitud}" />';
                tqrmapas.lng = '<core:out value="${dtoPunto.localizacion.longitud}" />';
                tqrmapas.crearMapa();
                tqrmapas.crearNuevoMarcador('<core:out value="${dtoPunto.informacion.nombre}" />', null, tqrmapas.lat, tqrmapas.lng);
            });
            </script>
        </head>
        <body>
            <div>Header</div>
            <div>
                <a>dropdown</a>
                <h1>
                    <core:out value="${dtoPunto.informacion.nombre}" />
                </h1>
                <textarea cols="100" rows="50">
                    <core:out value="${dtoPunto.informacion.texto}" />
                </textarea>
            </div>
            <div>Contenedor de imagenes</div>
            <div>Links</div>
            <div id="contenedorMapa"></div>
        </body>
    </html>
