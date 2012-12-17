<%-- 
    Document   : FormularioInformacionPunto
    Created on : 03/11/2012, 20:34:53
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<fieldset id="camposInformacionPunto" style="display : none;">
    <legend>Informacion del punto de interes</legend>
    <div>
        <input id="idPunto" name="idPunto" value="${punto.idPunto}" style="display: none;"/>
        <label for="informacionPunto">
            Nombre:<br>
            <input id="nombrePunto" name="nombrePunto" type="text" placeholder="Ingrese el nombre del punto" required="true" value="${punto.nombrePunto}"/>
        </label>
        <div id="esperaVerificacion" style="display:none;">
            <img src="${pageContext.request.contextPath}/Vistas/Imagenes/loading.gif" style="height : 20px;"/>
        </div>
        <div id="nombrePuntoError" style="display:none; border: 1px solid black; padding: 2px; color: white; background: red; text-align: center;">
        </div>
        <br>
        <label for="categoriaPunto">
            Categoria:<br>
            <div id="categoriaPunto" name="categoriaPunto" style="display: none;">${punto.categoria.nombreCategoria}</div>
            <%@ include  file="/WEB-INF/jsp/Utils/ComboCategoria.jsp" %>
        </label>
        <div id="categoriaPuntoError" style="display:none; border: 1px solid black; padding: 2px; color: white; background: red; text-align: center;">
        </div>
        <br>
        <label for="informacionPunto">
            Informacion relacionada:<br>
            <textarea id="informacionPunto" name="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18">${punto.informacion.texto}</textarea>
        </label>
        <input id="fechaCreacion" name="fechaCreacion" type="text" value="${punto.fechaCreacion}" style="display: none;"/>
        <input id="cantidadDeVisitas" name="cantidadDeVisitas" type="text" value="${punto.cantidadDeVisitas}" style="display: none;"/>
    </div>
</fieldset>
<input id="idioma" name="idioma" type="text" style="display: none;"/>
