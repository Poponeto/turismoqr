<%-- 
    Document   : GaleriaImagenes
    Created on : 04/11/2012, 02:17:30
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<div id="contenedorPreviewImagenes">
    
</div>
<div id="contenedorGaleriaImagenes">
    <ul id="galeriaImagenes">
        <li>
<!--            <span class="title">The first image</span>-->
            <img src="<%=request.getContextPath()%>/imagenes/mostrarImagen?img=C:/Users/Chelo/Downloads/FotosMendoza/Mendoza (1).jpg">
        </li>
        <li>
<!--            <span class="title">A second image</span>-->
            <img src="<%=request.getContextPath()%>/imagenes/mostrarImagen?img=C:/Users/Chelo/Downloads/FotosMendoza/Mendoza (2).jpg">
        </li>
        <li>
<!--            <span class="title">This is the description</span>-->
            <img src="<%=request.getContextPath()%>/imagenes/mostrarImagen?img=C:/Users/Chelo/Downloads/FotosMendoza/Mendoza (3).jpg">
        </li>
        <li>
<!--            <span class="title">Another description</span>-->
            <img src="<%=request.getContextPath()%>/imagenes/mostrarImagen?img=C:/Users/Chelo/Downloads/FotosMendoza/Mendoza (4).jpg">
        </li>
    </ul>
</div>
