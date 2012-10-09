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
        <script type="text/javascript" src="../../../Vistas/JavaScript/Mapa.js"></script>
        <script type="text/javascript" src="../../../Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script type="text/javascript" src="../../../Vistas/JavaScript/JQuery/jquery-ui-1.8.24.custom.min.js"></script>
        <script type="text/javascript" src="../../../Vistas/JavaScript/InicializadorComponentes.js"></script>
        <link rel="stylesheet" type="text/css" media="screen" href="../../../Vistas/HojasDeEstilo/jquery.ui.potato.menu.css" />
        <script type="text/javascript" src="../../../Vistas/JavaScript/JQuery/jquery.ui.potato.menu.js"></script>
        <link rel="stylesheet" type="text/css" href="../../../Vistas/HojasDeEstilo/jquery-ui-1.8.24.custom.css">
        <link rel="stylesheet" type="text/css" href="../../../Vistas/HojasDeEstilo/Mapas.css">
        <script type="text/javascript">
            
            $(document).ready(function(){
                inicializarComponentes();
               
                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.lat = '<core:out value="${punto.localizacion.latitud}" />';
                tqrmapas.lng = '<core:out value="${punto.localizacion.longitud}" />';
                tqrmapas.crearMapa();
                tqrmapas.crearNuevoMarcador('<core:out value="${punto.informacion.nombre}" />', null, tqrmapas.lat, tqrmapas.lng);
            });

        </script>
    </head>
    <body>

        <div id="Cabecera" style="padding: 15px 30px; height: 70px;">
            <img alt="" src="../../../Vistas/Imagenes/TurismoQRLogo.jpg" style="display: inline-block; margin-right: 15px;  height: 70px;"/>
            <img alt="" src="../../../Vistas/Imagenes/TurismoQRTitulo.png" style="display: inline-block;  height: 60px;"/>
        </div>
        <div style="position: relative; padding: 0px 30px;" class="ui-widget-header">
            <div style="display: inline-block;">
                <h3>Informacion punto de interes</h3>
            </div>
            <div style="display: inline-block; position: absolute; right: 30px; margin-top: -9px; top: 50%;" align="right">
                <label style="display: inline-block;">Idioma: </label>
                <select id="idiomaSeleccionado" size=1 >
                    <option value="Español">Español</option>
                </select>
            </div>
        </div>

        <div id="tabsInformacionPunto" style="display: inline-block; position: relative; width: 45%;">
            <ul>
                <li><a href="#tabInformacionPunto">Informacion</a></li>
                <li><a href="#tabLinks">Links</a></li>
            </ul>
            <div id="tabInformacionPunto">
                <h1>
                    <core:out value="${punto.informacion.nombre}" />
                </h1>
                <textarea cols="45" rows="25">
                    <core:out value="${punto.informacion.texto}" />
                </textarea>
            </div>
            <div id="tabLinks">
                <ul>
                    <c:forEach var="link" items="${punto.links}">
                        <li>
                        <c:out value="${link.url}" />
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>


        <div id="contenedorMapa" style="display: inline-block; position: absolute; right: 30px; ; width: 50%; margin-top: 30px;" align="right"></div>
        <div>Contenedor de imagenes</div>
    </body>
</html>
