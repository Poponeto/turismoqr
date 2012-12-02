<%-- 
    Document   : GaleriaImagenes
    Created on : 04/11/2012, 02:17:30
    Author     : Chelo
--%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='core'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
    /* jQuery lightBox plugin - Gallery style */
    #barraHerramientas, #barraComentario {
            display: none;
            position: absolute;
            text-align: right;
            padding: 10px 0px;
            background: rgba(0,0,0,0.5);
            color: white;
    }
    #barraComentario {
            text-align: left;
            display: none;
    }
    #agregarComentario img {
            height: 20px;
            margin-left: 10px;
            margin-right: 5px;
    }
    #borrarImagen img {
            height: 20px; 
            margin-right: 10px;
            margin-left: 5px;
    }
</style>

<div id="contenedorPreviewImagenes">
    <div id="barraHerramientas">
        <a id="agregarComentario" href="">
            <img src="${pageContext.request.contextPath}/Vistas/Imagenes/comment_add.png" alt="Agregar Comentario"/>
        </a>
        <a id="borrarImagen" href="">
            <img src="${pageContext.request.contextPath}/Vistas/Imagenes/remove_256.png" alt="Borrar imagen"/>
        </a>
    </div>
    <div id="contenedorMensaje">Agrega imagenes para visualizarlas aqui</div>
    <div id="barraComentario">
        <div id="textoComentario" style="margin-left: 10px;"></div>
    </div>
</div>
<div id="contenedorGaleriaImagenes">
    <ul id="galeriaImagenes">
        <li><img alt=""  src="${pageContext.request.contextPath}/Vistas/Imagenes/ImagenDefault.jpg"/></li>
        <core:forEach var="imagen" items="${punto.imagenes}">
            <li><img alt="${imagen.informacion.texto}" src="${pageContext.request.contextPath}/imagenes/mostrarImagen.htm?img=${imagen.url}"/></li>
        </core:forEach>
    </ul>
</div>
<div id="requestContext" style="display: none;">${pageContext.request.contextPath}</div>