<%-- 
    Document   : MenuMarcador
    Created on : 03-nov-2012, 12:16:52
    Author     : Federico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Marcador</title>

        <%@ include file="/WEB-INF/jsp/Utils/ArchivosJQuery.html" %>

        <script type="text/javascript" >
            $(document).ready(function(){
                inicializarComponentes();
            });
        </script>

    </head>
    <body>

        <div id="Contenido">
            <sec:authorize url="/informacionPunto/${punto.idPunto}/obtenerInformacionPuntoIdiomaDefault.htm">
                <a href="${pageContext.request.contextPath}/informacionPunto/${punto.idPunto}/obtenerInformacionPuntoIdiomaDefault.htm">Ver Informaciòn de Punto de Interés.</a>
            </sec:authorize>

            <sec:authorize url="/administracion/crearPunto/${punto.idPunto}/actualizarPuntoInteres.htm">
                <a href="${pageContext.request.contextPath}/administracion/crearPunto/${punto.idPunto}/actualizarPuntoInteres.htm">Actualizar Punto de Interés.</a>
            </sec:authorize>

            <sec:authorize url="/administracion/crearPunto/${punto.idPunto}/eliminarPuntoInteres.htm">
                <a href="${pageContext.request.contextPath}/administracion/crearPunto/${punto.idPunto}/eliminarPuntoInteres.htm">Eliminar Punto de Interés.</a>
            </sec:authorize>

            <div style="margin-top: 15px">
                <h1>
                    <core:out value="${punto.informacion.nombre}" />
                </h1>
                
                <a style="margin-top: 15px">
                    Latitud: <core:out value="${punto.localizacion.latitud}" />
                </a>
                <a>
                    Longitud: <core:out value="${punto.localizacion.longitud}" />
                </a>

                <a style="margin-top: 15px">
                    <core:out value="${punto.informacion.texto}" />
                </a>
            </div>
        </div>
    </body>
</html>