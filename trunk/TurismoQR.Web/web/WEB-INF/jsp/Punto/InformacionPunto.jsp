<%-- 
    Document   : InformacionPunto
    Created on : 04-sep-2012, 20:33:44
    Author     : Federico
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion del Punto de Interes</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosMapa.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <script type="text/javascript">
            
            $(document).ready(function(){
                inicializarComponentes();
                inicializarCambioIdiomaInformacionPunto();
                
                tqrmapas.contenedorMapas = "contenedorMapa";
                tqrmapas.lat = '<core:out value="${punto.localizacion.latitud}" />';
                tqrmapas.lng = '<core:out value="${punto.localizacion.longitud}" />';
                tqrmapas.crearMapa();
                tqrmapas.crearNuevoMarcador('<core:out value="${punto.informacion.nombre}" />', null, tqrmapas.lat, tqrmapas.lng);
            });

        </script>
    </head>
    <body>

        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>
        
        <div style="position: relative; padding: 0px 30px;" class="ui-widget-header">
            <div style="display: inline-block;">
                <h3>Informacion punto de interes</h3>
            </div>
            <div style="display: inline-block; position: absolute; right: 30px; margin-top: -9px; top: 50%;" align="right">
                <%@ include  file="/WEB-INF/jsp/Utils/ComboIdiomas.jsp" %>
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
                    <core:forEach var="link" items="${punto.links}">
                        <li>
                        <core:out value="${link.url}" />
                        </li>
                    </core:forEach>
                </ul>
            </div>
        </div>


        <div id="contenedorMapa" style="display: inline-block; position: absolute; right: 30px; ; width: 50%; margin-top: 30px;" align="right"></div>
        <div>Contenedor de imagenes</div>
    </body>
</html>
