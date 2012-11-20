<%-- 
    Document   : InformacionPunto
    Created on : 04-sep-2012, 20:33:44
    Author     : Federico
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion del Punto de Interes</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosMapa.html" %>
        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/jquery.lightbox-0.5.css">
        <script src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery.lightbox-0.5.js"></script>  
        <script type="text/javascript">
            
            $(function(){
                $('#galeria a').lightBox({
                    fixedNavigation : true,
                    imageLoading:'${pageContext.request.contextPath}/Vistas/Imagenes/lightbox-ico-loading.gif',		// (string) Path and the name of the loading icon
                    imageBtnPrev:'${pageContext.request.contextPath}/Vistas/Imagenes/lightbox-btn-prev.gif',			// (string) Path and the name of the prev button image
                    imageBtnNext:'${pageContext.request.contextPath}/Vistas/Imagenes/lightbox-btn-next.gif',			// (string) Path and the name of the next button image
                    imageBtnClose:'${pageContext.request.contextPath}/Vistas/Imagenes/lightbox-btn-close.gif',		// (string) Path and the name of the close btn
                    imageBlank:'${pageContext.request.contextPath}/Vistas/Imagenes/lightbox-blank.gif'			// (string) Path and the name of a blank image (one pixel)
                });
            });
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
        <style type="text/css">
            /* jQuery lightBox plugin - Gallery style */
            #galeria,#galeria ul {
                background-color: #444;
                padding: 10px;
            }
            #galeria ul { list-style: none; }
            #galeria ul li { display: inline; }
            #galeria ul img {
                border: 5px solid #3e3e3e;
                border-width: 5px 5px 20px;
            }
            #galeria ul a:hover img {
                border: 5px solid #fff;
                border-width: 5px 5px 20px;
                color: #fff;
            }
            #galeria ul a:hover { color: #fff; }

        </style>
    </head>
    <body>

        <%@ include  file="/WEB-INF/jsp/Utils/Cabecera.jsp" %>

        <sec:authorize ifNotGranted="PERMISO_TURISTA">
            <div id="contenedorMenu" class="ui-widget-header">
                <%@ include  file="/WEB-INF/jsp/Utils/MenuCabecera.jsp" %>
            </div>
        </sec:authorize>

        <div style="position: relative; padding: 0px 30px;" class="ui-widget-header">
            <div style="display: inline-block;">
                <h3>Informacion punto de interes</h3>
            </div>
            <div style="display: inline-block; position: absolute; right: 1%; margin-top: -9px; top: 50%;" align="right">
                <%@ include  file="/WEB-INF/jsp/Utils/ComboIdiomas.jsp" %>
            </div>
        </div>

        <div id="tabsInformacionPunto" style="display: inline-block; position: relative; width: 45%;">
            <ul>
                <li><a href="#tabInformacionPunto">Informacion</a></li>

            </ul>
            <div id="tabInformacionPunto">
                <h1>
                    <core:out value="${punto.informacion.nombre}" />
                </h1>
                <div>
                    ${punto.informacion.texto}
                </div>
            </div>
            <div id="galeria" class="ui-corner-all">
                <core:if test="${punto.imagenes != null}">
                    <ul class="ui-corner-all">
                        <core:forEach var="imagen" items="${punto.imagenes}">
                            <li>
                                <a href="<%=request.getContextPath()%>/imagenes/mostrarImagen?img=<core:out value="${imagen.url}"/>" title="<core:out value="${imagen.informacion.texto}"/>">
                                    <img src="<%=request.getContextPath()%>/imagenes/mostrarImagen?img=<core:out value="${imagen.url}"/>" width="72" height="72" alt=""/>
                                </a>
                            </li>
                        </core:forEach>
                    </ul>
                </core:if>
                <core:if test="${punto.imagenes == null}">
                    <ul class="ui-corner-all" style="margin: 0px;">
                        <div id="contenedorMensaje" style="color: white; text-shadow: none;">
                            No existen imagenes para este punto.
                        </div>
                    </ul>
                </core:if>
            </div>

        </div>


        <div id="contenedorMapa" style="display: inline-block; position: absolute; right: 1%; ; width: 50%; margin-top: 30px;" align="right"></div>



    </body>
</html>
