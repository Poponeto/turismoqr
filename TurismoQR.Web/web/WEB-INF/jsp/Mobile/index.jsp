<%-- 
    Document   : index
    Created on : 10/11/2012, 22:27:28
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/jquery.mobile-1.2.0.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Vistas/HojasDeEstilo/jquery.lightbox-0.5.css">
        <script src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery-1.8.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery.mobile-1.2.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/Vistas/JavaScript/JQuery/jquery.lightbox-0.5.js"></script>
        <script src="https://maps.google.com/maps/api/js?sensor=true"></script>
        <script src="${pageContext.request.contextPath}/Vistas/JavaScript/Mapa.js"></script>
        <script>
            $(document).ready(function(){
                tqrmapas.inicializarLocalizacion($('#latitudPunto').text(), $('#longitudPunto').text());
                tqrmapas.inicializarContenedor('contenedorMapa');
                tqrmapas.crearMapa();
                tqrmapas.crearNuevoMarcador('', null);
            });
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
        <title>${punto.nombrePunto}</title>
    </head>
    <body>
        <div id="index" data-role="page" style="background: lightgray;">
            <div id="header" data-role="header" data-position="fixed" data-tap-toggle="false" style="padding: 10px; height: 20px;" align="center">
                ${punto.nombrePunto}
            </div>
            <div id="content" data-role="content">
                <div id="latitudPunto" style="display: none;">${punto.localizacion.latitud}</div>
                <div id="longitudPunto" style="display: none;">${punto.localizacion.longitud}</div>
                <div id="contenedorMapa" style="height: 500px;"></div>
                <div id="categoriaPunto"  class="ui-corner-all" style="border: 1px solid black; padding: 10px; margin-top: 10px; background: white;">
                    <label for="textoInformacion">
                        <h3 style="margin: 0px; display: inline;">Categoria: </h3>
                        <div id="textoInformacion" style="display: inline;">
                            ${punto.categoria.nombreCategoria}
                        </div>
                    </label>
                </div>
                <div id="informacionPunto"  class="ui-corner-all" style="border: 1px solid black; padding: 10px; margin-top: 10px; background: white;">
                    <label for="textoInformacion">
                        <h3 style="margin: 0px;">Informacion:</h3>
                        <div id="textoInformacion">
                            ${punto.informacion.texto}
                        </div>
                    </label>
                </div>
                <div id="galeria" class="ui-corner-all" style="border: 1px solid black; padding: 10px; margin-top: 10px; background: white;">
                    <core:if test="${punto.imagenes != null}">
                        <ul class="ui-corner-all" style="margin: 0px;">
                            <core:forEach var="imagen" items="${punto.imagenes}">
                                <li>
                                    <a href="<%=request.getContextPath()%>/imagenes/mostrarImagen?img=<core:out value="${imagen.url}"/>" title="<core:out value="${imagen.informacion.informacionEnIdiomas.texto}"/>">
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
            <div id="footer" data-role="footer" data-position="fixed" data-tap-toggle="false" style="padding: 10px;"  align="center">
                <img alt="" src="${pageContext.request.contextPath}/Vistas/Imagenes/TurismoQRTitulo.png" style="height: 20px; vertical-align: middle;"/>
            </div>
        </div>
    </body>
</html>