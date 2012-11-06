<%-- 
    Document   : FormularioImagenesPunto
    Created on : 03/11/2012, 20:35:06
    Author     : Chelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<fieldset id="camposImagenesPunto" style="display : none;">
    <legend>Agregar imagenes al punto de interes</legend>
    <div>
        <div style="width: 100%; text-align: center;">
            <%@ include  file="/WEB-INF/jsp/Administracion/Punto/GaleriaImagenes.jsp" %>
                <a id="dialog_link" class="btn btn-success" style="color: white; float: left; margin-top: 20px;" href="#">Agregar Imagen...</a>
        </div>
    </div>
</fieldset>
