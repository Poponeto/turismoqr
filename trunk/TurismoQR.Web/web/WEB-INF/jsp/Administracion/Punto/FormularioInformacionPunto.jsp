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
        <br>
        <label for="categoriaPunto">
            Categoria:<br>
            <div id="categoriaPunto" name="categoriaPunto" style="display: none;">${punto.categoria.nombreCategoria}</div>
            <%@ include  file="/WEB-INF/jsp/Utils/ComboCategoria.jsp" %>
        </label>
        <br>
        <label for="informacionPunto">
            Informacion relacionada:<br>
            <textarea id="informacionPunto" name="informacionPunto" placeholder="Ingrese la informacion correspondiente al punto" rows="18">${punto.informacion.texto}</textarea>
        </label>
    </div>
</fieldset>
<input id="idioma" name="idioma" type="text" style="display: none;"/>